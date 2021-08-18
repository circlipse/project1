package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comm.Forward;
 
public class ReserveInsertAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		Forward forward = new Forward();
		System.out.println(id);
		if (id == null) {
			forward.setForward(false);
			forward.setPath("login.2jo");
		} else {
			forward.setForward(true);
			forward.setPath("WEB-INF/reserve/ReserveInsertForm.jsp");
				
		}
		return forward;
	}

}
