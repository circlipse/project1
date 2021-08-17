package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import comm.Forward;
import dto.ReviewDTO;
import service.ReviewService;
 
public class ReviewModifyResultAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ReviewService service=ReviewService.getInstance();
		
		request.setCharacterEncoding("utf-8");
		
		int rev_no=Integer.parseInt(request.getParameter("rev_no"));
		String rev_title=request.getParameter("rev_title");
		String rev_content=request.getParameter("rev_content");
		

		ReviewDTO dto=new ReviewDTO();
		dto.setRev_no(rev_no);
		dto.setRev_title(rev_title);
		dto.setRev_content(rev_content);
		
		service.reviewmodify(dto);
		
		Forward forward=new Forward();
		forward.setForward(true);  
		forward.setPath("reviewlist.2jo");
		
		return forward;
	}

}
