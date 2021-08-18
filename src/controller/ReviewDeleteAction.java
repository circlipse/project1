package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import comm.Forward;
import service.ReviewService;
 
public class ReviewDeleteAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int rev_no=Integer.parseInt(request.getParameter("rev_no"));
		
		ReviewService service=ReviewService.getInstance();
		service.reviewdelete(rev_no);
		
		Forward forward=new Forward();
		forward.setForward(true);  
		forward.setPath("reviewlist.2jo");
		 
		return forward;
	}

}
