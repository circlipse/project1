package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.Forward;

public class LoginAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String referer = request.getParameter("referer");
		request.setAttribute("referer", referer);	

		Forward f= new Forward();
		f.setForward(true);
		f.setPath("/WEB-INF/main.jsp?page=user/login.jsp");
		return f;
	}

} 
 