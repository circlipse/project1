package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import comm.Forward;
import dto.ReviewDTO;
import service.ReviewService;

public class ReviewInsertResultAction implements Action {
 
	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String rev_title=request.getParameter("rev_title");
		String rev_content=request.getParameter("rev_content");
		
		ReviewService service=ReviewService.getInstance();
		
		ReviewDTO dto=new ReviewDTO();
		dto.setRev_title(rev_title);
		dto.setRev_content(rev_content);
		service.reviewinsert(dto);
		
		
		Forward forward=new Forward();
		forward.setForward(true);  
		forward.setPath("reviewlist.2jo");
		
		return forward;
	}

}
