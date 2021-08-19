package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.Forward;
import dao.NoticeDAO;
import dto.NoticeDTO;
import service.NoticeService;

public class NoticeModifyFormAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		request.setCharacterEncoding("utf-8");
		
		int notice_no = Integer.parseInt(request.getParameter("notice_no"));
		NoticeService service =NoticeService.getinstace();
		NoticeDTO dto = service.detail(notice_no);

		request.setAttribute("dto", dto);
		Forward forward = new Forward();
		forward.setForward(true);
//		forward.setPath("/WEB-INF/user/insertform.jsp"); 
		forward.setPath("/WEB-INF/main.jsp?page=user/noticemodifyform.jsp"); 
   
		return forward;
	}

}
