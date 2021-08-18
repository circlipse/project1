package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import comm.Forward;
import dto.SubReviewDTO;
import dto.UserDTO;
import service.ReviewService;

public class SubReviewInsertAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		int rev_no=Integer.parseInt(request.getParameter("rev_no"));

		String subcontent=request.getParameter("subcontent");
		
		SubReviewDTO dto=new SubReviewDTO();
		dto.setSubcontent(subcontent);
		dto.setRev_no(rev_no);
		
		ReviewService service=ReviewService.getInstance();
		service.insertsub(dto);
		
		
		Forward forward=new Forward();
		forward.setForward(false);
		forward.setPath("reviewdetail.2jo?rev_no="+rev_no);
		
		return forward;
	}

}
