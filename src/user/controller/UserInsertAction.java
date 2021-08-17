package user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.Forward;
import dto.UserDTO;
import service.UserService;

public class UserInsertAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		String user_name = request.getParameter("user_name");
		String user_phone =request.getParameter("user_phone");
		
		UserDTO dto = new UserDTO();
		
		dto.setUser_id(user_id);
		dto.setUser_pwd(user_pwd);
		dto.setUser_name(user_name);
		dto.setUser_phone(user_phone);
		
		UserService service = UserService.getInstance();
		
		int result= service.join(dto);

		request.setAttribute("result", result);
		
		Forward forward =new Forward();
		forward.setForward(true);
		forward.setPath("/WEB-INF/user/insertresult.jsp");
		
		return forward;
		
		
	}

}
