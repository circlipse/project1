package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.Forward;
import dto.UserDTO;
import service.UserService;

public class OverlapAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String inputid = request.getParameter("inputid");
		UserService service = UserService.getInstance();
		UserDTO dto = new UserDTO();
		dto = service.selectUser(inputid);

		int useid = -1;//중복 아이디 여부
		if(dto.getUser_id() == null) {	//중복 아이디 없음
			useid=0;
		}else {	//중복아이디 있음
			useid=1;
		}
		
		Forward forward = new Forward();
		forward.setForward(false);
		forward.setPath("useridinput.2jo?useid="+useid+"&inputid="+inputid);
		return forward;
	}

}
