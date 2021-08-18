package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.Forward;
import dto.NoticeDTO;
import dto.UserDTO;
import service.NoticeService;

public class NoticeAddAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");
		
		String notice_title = request.getParameter("notice_title");
		String notice_content = request.getParameter("notice_content");
		

		NoticeDTO dto = new NoticeDTO();

		dto.setNotice_title(notice_title);
		dto.setNotice_content(notice_content);
		
		NoticeService service = NoticeService.getinstace();
		
		int result = service.noticAdd(dto);
		
		request.setAttribute("result", result);
		Forward forward =new Forward();
		forward.setForward(true);
		forward.setPath("/WEB-INF/user/main.jsp?page=noticeaddresult.jsp");
		
		return forward;
	}

}
