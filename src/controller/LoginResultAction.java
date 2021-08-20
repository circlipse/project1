package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comm.Forward;
import service.ReserveService;
import service.UserService;


public class LoginResultAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String referer = request.getParameter("referer");

		UserService service = UserService.getInstance();
		int result= service.checkUser(id,pwd);
		
		ReserveService rservice = ReserveService.getInstance();
		int user_no = rservice.getUserNo(id);
		
		
		Forward f = new Forward();
		f.setForward(true);

		//System.out.println(result);
		if(result > 0) {
			HttpSession session =request.getSession();
			session.setAttribute("id", id);
			
			if(referer.equals("/p2jo/reserveinsert.2jo")){
				f.setPath("/WEB-INF/main.jsp?page=reserve/ReserveInsertForm.jsp");
				request.setAttribute("user_no", user_no);
			}else {
				//System.out.println("id는 "+id);
				request.setAttribute("result", result);
				session.setMaxInactiveInterval(60*5);
				f.setPath("/WEB-INF/main.jsp?page=user/loginresult.jsp");
			}
		} else {
			f.setPath("/WEB-INF/main.jsp?page=user/loginfail.jsp");
		}
		
		
		
		
		
		
//		System.out.println(result);
//		if(result > 0) {
//			HttpSession session =request.getSession();
//			session.setAttribute("id", id);
//			System.out.println("id는 "+id);
//			
//			session.setMaxInactiveInterval(60*5);
//		}
//		request.setAttribute("result", result);
//		
//		f.setForward(true);
//		f.setPath("/WEB-INF/user/main.jsp?page=loginresult.jsp");
		
		
		return f;
	}

}
