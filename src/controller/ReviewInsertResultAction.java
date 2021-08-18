package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import comm.Forward;
import dto.ReviewDTO;
import dto.UserDTO;
import service.ReviewService;

public class ReviewInsertResultAction implements Action {
 
	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		String rev_title=request.getParameter("rev_title");
		String id=(String)session.getAttribute("id");
		String rev_content=request.getParameter("rev_content");
		
		ReviewService service=ReviewService.getInstance();
		
		ReviewDTO dto=new ReviewDTO();
		dto.setRev_title(rev_title);
		dto.setId(id);
		dto.setRev_content(rev_content);
		
		UserDTO userdto =service.usernorsv(id);
		
		int userno = userdto.getUser_no();
		System.out.println(userno);
		service.reviewinsert(dto,userno);
		
		
		Forward forward=new Forward();
		forward.setForward(true);  
		forward.setPath("reviewlist.2jo");
		
		return forward;
	}

}
