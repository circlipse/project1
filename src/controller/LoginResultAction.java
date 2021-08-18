package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comm.Forward;
import service.UserService;


public class LoginResultAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		System.out.println(id);
		String pwd = request.getParameter("pwd");
		System.out.println(pwd);
		
		UserService service = UserService.getInstance();
		int result= service.checkUser(id,pwd);
		
		if(result > 0) {
			HttpSession session =request.getSession();
			session.setAttribute("id", id);
			
			session.setMaxInactiveInterval(60*5);
		}
		
		Forward f = new Forward();
		f.setForward(true);
		f.setPath("/WEB-INF/user/main.jsp?page=loginresult.jsp");
		
		
		return f;
	}

}