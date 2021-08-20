package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comm.Forward;
import dto.ReserveDTO;
import service.ReserveService;

public class ReserveInsertDetailAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		int rsv_no = Integer.parseInt(request.getParameter("rsv_no"));
		ReserveService service = ReserveService.getInstance();
		ReserveDTO dto = new ReserveDTO();
		dto = service.detailRsv(rsv_no);
		//System.out.println(rsv_no);
		request.setAttribute("dto", dto);
		
		ReserveDTO dto2 = new ReserveDTO();
		dto2 = service.getBagVal(rsv_no);
		request.setAttribute("dto2", dto2);
		
		Forward forward = new Forward();
		if (id == null) {
			forward.setForward(false);
			forward.setPath("login.2jo");
		} else {
			forward.setForward(true);
			forward.setPath("WEB-INF/reserve/ReserveInsertDetail.jsp");
			session.setAttribute("id", id);
		}
		return forward;
	}

}
