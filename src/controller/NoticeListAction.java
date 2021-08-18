package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comm.Forward;
import dto.NoticeDTO;
import service.NoticeService;

public class NoticeListAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		request.setAttribute("id", id);
		
		NoticeService service = NoticeService.getinstace();
		
		List<NoticeDTO> list = new ArrayList<NoticeDTO>();
		
		list = service.getList();

		request.setAttribute("list", list);
		
		Forward forward = new Forward();
		forward.setForward(true);
		forward.setPath("/WEB-INF/user/main.jsp?page=noticelist.jsp");
		
		return forward;
	}

}
