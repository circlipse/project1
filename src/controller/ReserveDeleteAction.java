package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.Forward;
import service.ReserveService;

public class ReserveDeleteAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rsv_no = Integer.parseInt(request.getParameter("rsv_no"));
		
		ReserveService service = ReserveService.getInstance();
		service.delRsv(rsv_no);
		
		Forward forward = new Forward();
		forward.setForward(true);
		forward.setPath("WEB-INF/main.jsp?page=reserve/ReserveDeleteResult.jsp");
		return forward;
	}

}
