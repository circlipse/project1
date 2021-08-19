package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import comm.Forward;

public class ReviewInsertAction implements Action {
 
	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		Forward forward = new Forward();
		if (id == null) {
			forward.setForward(false);
			forward.setPath("login.2jo");
		}
		else {
			forward.setForward(true);
			forward.setPath("/WEB-INF/main.jsp?page=review/ReviewInsertForm.jsp");
		}
			
		return forward;
		
	}

}
