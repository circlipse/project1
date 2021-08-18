package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.Forward;
import service.ReserveService;

public class ReserveModifyResultAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int rsv_no=Integer.parseInt(request.getParameter("rsv_no"));
		
		ReserveService service=ReserveService.getInstance();
		service.modifyRsv(dto);
		
		Forward forward=new Forward();
		forward.setForward(false);
		forward.setPath("reservedetail.2jo?rsv_no=");
		return forward;
	}

}
