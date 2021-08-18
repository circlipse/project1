package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.Forward;
import service.NoticeService;

public class NoticeModifyAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int notice_no = Integer.parseInt(request.getParameter("notice_no"));
		String notice_title = request.getParameter("notice_title");
		String notice_content = request.getParameter("notice_content");
		
		NoticeService service = NoticeService.getinstace();
		
		int result = service.modify(notice_no,notice_title,notice_content);
		
		request.setAttribute("result", result);
		
		Forward f= new Forward();
		f.setForward(true);
		f.setPath("/WEB-INF/user/main.jsp?page=noticemodifyresult.jsp");
		return f;
	}

}
