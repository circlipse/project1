package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.Forward;
import dto.UserDTO;
import service.UserService;

public class idCheckDAOAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		System.out.println(id);
		UserService service = UserService.getInstance();
		int result = service.overlapId(id);

		request.setAttribute("result", result);
		request.setAttribute("id", id);
		
		Forward forward = new Forward();
		forward.setForward(true);
		forward.setPath("/WEB-INF/user/idCheckDAO.jsp");
		return forward;
	}

}
