package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import comm.Forward;
import dto.ReviewDTO;
import service.ReviewService;
 
public class ReviewModifyAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int rev_no=Integer.parseInt(request.getParameter("rev_no"));
		
		ReviewService service=ReviewService.getInstance();
		ReviewDTO dto=service.detail(rev_no);
		
		request.setAttribute("dto", dto);
		
		Forward forward=new Forward();
		forward.setForward(true);
		forward.setPath("WEB-INF/review/ReviewModifyForm.jsp");
		
		return forward;
	}

}
