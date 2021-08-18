package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.Forward;
import dto.NoticeDTO;
import service.NoticeService;

public class NotiecDetailAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		int notice_no = Integer.parseInt(request.getParameter("notice_no"));
		request.setCharacterEncoding("utf-8");
		NoticeService service =NoticeService.getinstace();
		NoticeDTO dto = new NoticeDTO();
		dto = service.detail(notice_no);
		int result = service.readcount(notice_no);
		
		request.setAttribute("dto", dto);
		
		Forward forward = new Forward();
		forward.setForward(true);
		forward.setPath("/WEB-INF/user/main.jsp?page=noticedetail.jsp");
		return forward;
		
	}
	
}
