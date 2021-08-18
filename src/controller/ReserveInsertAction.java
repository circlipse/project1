package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.Forward;
 
public class ReserveInsertAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Forward forward=new Forward();
		forward.setForward(true);
		forward.setPath("WEB-INF/reserve/ReserveInsertForm.jsp");
		return forward;
	}

}
