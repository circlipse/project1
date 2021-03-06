package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comm.Forward;
import service.ReserveService;
 
public class ReserveInsertAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		ReserveService service = ReserveService.getInstance();
		int user_no = service.getUserNo(id);
		
		String referer = (String)request.getRequestURI();
		
		Forward forward = new Forward();
		if (id == null) {
			forward.setForward(false);
			forward.setPath("login.2jo?referer="+referer);
		} else {
			forward.setForward(true);
			forward.setPath("WEB-INF/main.jsp?page=reserve/ReserveInsertForm.jsp");
			session.setAttribute("id", id);
			request.setAttribute("user_no", user_no);	
		}
		return forward;
	}

}
