package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comm.Forward;
import dto.UserDTO;
import service.UserService;


public class DetailAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session =request.getSession();
		String id = (String) session.getAttribute("id");
		
		UserService service=UserService.getInstance();
		
		
		UserDTO dto= service.userDetail(id);
		request.setAttribute("dto", dto);
		
		Forward forward= new Forward();
		forward.setForward(true);
		forward.setPath("/WEB-INF/main.jsp?page=user/userdetail.jsp");
		
		return forward;
		
	}

	
}
