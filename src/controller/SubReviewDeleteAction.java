package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import comm.Forward;
import service.ReviewService;

public class SubReviewDeleteAction implements Action {
  
	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int subno=Integer.parseInt(request.getParameter("subno"));
		int rev_no=Integer.parseInt(request.getParameter("rev_no"));
		
		ReviewService service=ReviewService.getInstance();
		service.subDelete(subno, rev_no);
		
		Forward forward=new Forward();
		forward.setForward(false);    
		forward.setPath("reviewdetail.2jo?rev_no="+rev_no);
		
		return forward;
	}

}
