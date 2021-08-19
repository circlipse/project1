package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comm.Forward;
import dto.UserDTO;
import service.UserService;

public class UserModiAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		HttpSession session =request.getSession();
		String id = (String) session.getAttribute("id");
		
		String user_pwd = request.getParameter("user_pwd");
		String user_name = request.getParameter("user_name");
		String user_phone =request.getParameter("user_phone");

		UserDTO dto = new UserDTO();
		
		dto.setUser_pwd(user_pwd);
		dto.setUser_name(user_name);
		dto.setUser_phone(user_phone); 
		
		UserService service = UserService.getInstance();
		
		int result= service.usermodify(dto,id);  

		request.setAttribute("result", result);
		
		Forward forward =new Forward();
		forward.setForward(true);
//		forward.setPath("/WEB-INF/user/insertresult.jsp");
		forward.setPath("/WEB-INF/main.jsp?page=user/usermodiresult.jsp");
		
		return forward;
	}

}
