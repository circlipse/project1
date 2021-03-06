package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.Forward;
import dto.ReserveDTO;
import service.ReserveService;

public class ReserveModifyAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int rsv_no=Integer.parseInt(request.getParameter("rsv_no"));
		ReserveService service=ReserveService.getInstance();
		ReserveDTO dto=service.detailRsv(rsv_no);
		request.setAttribute("dto", dto);
		
		ReserveDTO dto2 = new ReserveDTO();
		dto2 = service.getBagVal(rsv_no);
		request.setAttribute("dto2", dto2);
		
		Forward forward=new Forward();
		forward.setForward(true);
		forward.setPath("WEB-INF/main.jsp?page=reserve/ReserveModifyForm.jsp");
		return forward;
	}

}