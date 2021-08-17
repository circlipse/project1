package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.Forward;
import dto.ReserveDTO;
import service.ReserveService;

public class ReserveDetailAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int rsv_no = (int)request.getAttribute("rsv_no");
		ReserveService service = ReserveService.getInstance();
		ReserveDTO dto = new ReserveDTO();
		dto = service.detailRsv(rsv_no);

		
		Forward forward = new Forward();
		forward.setForward(true);
		forward.setPath("WEB-INF/reserve/detail.jsp");
		return forward;
	}

}
