package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.Forward;

public class UserIdInputAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String use = request.getParameter("useid");
		String inputid = request.getParameter("inputid");
		
		int useid = -1; 
		if(use!=null) { //아이디 중복확인번호
			useid = Integer.parseInt(use);
		}

		request.setAttribute("useid",useid);
		request.setAttribute("inputid",inputid);
			
		Forward forward = new Forward();
		forward.setForward(true);
		forward.setPath("/WEB-INF/main.jsp?page=user/insertform.jsp");
		 
		return forward;
	}

}
