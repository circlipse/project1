package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comm.Forward;

public class MainAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		Forward forward = new Forward();
		

		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		System.out.println("세션아이디:"+id);
		forward.setForward(true);
		if(id == null) {
			forward.setPath("/WEB-INF/main.jsp?page=user/login.jsp");
		}else {
			forward.setPath("/WEB-INF/main.jsp?page=user/loginresult.jsp");
		}
		
		
		
		
		
//		forward.setForward(true);
//		forward.setPath("/WEB-INF/user/main.jsp?page=login.jsp");
//		
		return forward;
	}

}
