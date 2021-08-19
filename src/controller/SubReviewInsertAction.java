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
		

		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		

		int rev_no=Integer.parseInt(request.getParameter("rev_no"));

		request.setAttribute("id", id);
		request.setAttribute("rev_no", rev_no);
		String subcontent=request.getParameter("subcontent");
		
		SubReviewDTO dto=new SubReviewDTO();

		Forward forward=new Forward();
		if (id == null) {
			forward.setForward(true);
			forward.setPath("/WEB-INF/main.jsp?page=review/ReviewSubNotLogin.jsp");
		
		}else {
			dto.setSubcontent(subcontent);
			dto.setRev_no(rev_no);
			dto.setUser_id(id);
			
			ReviewService service=ReviewService.getInstance();
			service.insertsub(dto);
			
			
			forward.setForward(false);
			forward.setPath("reviewdetail.2jo?rev_no="+rev_no);
		}
		
		
		return forward;
	}

}

