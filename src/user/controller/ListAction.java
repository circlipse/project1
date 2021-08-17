package user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.comm.Forward;
import user.dto.UserDTO;
import user.service.UserService;

public class ListAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		UserService service = UserService.getInstance();
		
		List<UserDTO> list= service.getList();

		request.setAttribute("list", list);
		
		Forward forward = new Forward();
		forward.setForward(true);
		forward.setPath("/WEB-INF/user/list.jsp");

		return forward;

	}

}
