package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import comm.Forward;
import dto.ReviewDTO;
import service.ReviewService;
 
public class ReviewDetailAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");

		request.setAttribute("id", id);
		int rev_no=Integer.parseInt(request.getParameter("rev_no"));
		
		
		ReviewService service=ReviewService.getInstance();
		
		//์กฐํ์
		service.addReadCount(rev_no);
		ReviewDTO dto=service.detail(rev_no);
		
		request.setAttribute("dto", dto);
		
		Forward forward=new Forward();
		forward.setForward(true);  
		forward.setPath("/WEB-INF/main.jsp?page=review/ReviewDetail.jsp");
		
		return forward;
		
	}

}
