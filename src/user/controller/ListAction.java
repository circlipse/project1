package user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.comm.Forward;
import user.dto.UserDTO;
import user.service.UserService;

public class ListAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		HttpSession session=request.getSession();
		String id= (String) session.getAttribute("id");
		Forward forward= new Forward();
		
		UserService service = UserService.getInstance();
		if(id==null) {
			forward.setForward(false);
			forward.setPath("login.2jo");
		}else {
			List<UserDTO> list= service.getList();

			request.setAttribute("list", list);
			
			forward.setForward(true);
			forward.setPath("/WEB-INF/user/main.jsp?page=list.jsp");

		}
		
		return forward;

	}

}
