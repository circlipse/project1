package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comm.Forward;

public class UserModiFormAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		HttpSession session =request.getSession();
		String id = (String) session.getAttribute("id");
		
		request.setAttribute("id", id);
		
		Forward forward = new Forward();
		forward.setForward(true);
//		forward.setPath("/WEB-INF/user/insertform.jsp"); 
		forward.setPath("/WEB-INF/main.jsp?page=user/usermodiform.jsp"); 
   
		return forward;
	}

}
