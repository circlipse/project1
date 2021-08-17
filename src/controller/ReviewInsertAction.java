package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import comm.Forward;

public class ReviewInsertAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Forward forward=new Forward();
		forward.setForward(true);
		forward.setPath("WEB-INF/review/ReviewInsertForm.jsp");
		
		return forward;
		
	}

}
