package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.Forward;
import dto.ReserveDTO;
import service.ReserveService;

public class ReserveModifyResultAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		int rsv_no = Integer.parseInt(request.getParameter("rsv_no"));
		String user_name = request.getParameter("user_name");
		String user_phone = request.getParameter("user_phone");
		String rsv_date = request.getParameter("rsv_date");
		String sub_date = request.getParameter("sub_date");
		String addr_depart = request.getParameter("addr_depart");
		String addr_arrive = request.getParameter("addr_arrive");
		
		String bagval_1 = request.getParameter("bag_val_1");
		String bagval_2 = request.getParameter("bag_val_2");
		int bag_val_1 = 0;
		int bag_val_2 = 0;
		if(bagval_1 != null) {
			bag_val_1 = Integer.parseInt(bagval_1);
		}
		if(bagval_2 != null) {
			bag_val_2 = Integer.parseInt(bagval_2);
		}
		
		String rsv_content = request.getParameter("rsv_content");
		int old_bag_val_1 = Integer.parseInt(request.getParameter("old_bag_val_1"));
		int old_bag_val_2 = Integer.parseInt(request.getParameter("old_bag_val_2"));
		
		ReserveDTO dto = new ReserveDTO();
		dto.setRsv_no(rsv_no);
		dto.setUser_name(user_name);
		dto.setUser_phone(user_phone);
		dto.setRsv_date(rsv_date);
		dto.setSub_date(sub_date);
		dto.setAddr_depart(addr_depart);
		dto.setAddr_arrive(addr_arrive);
		dto.setBag_val_1(bag_val_1);
		dto.setBag_val_2(bag_val_2);
		dto.setRsv_content(rsv_content);
		
		ReserveDTO dto2 = new ReserveDTO();
		dto2.setBag_val_1(old_bag_val_1);
		dto2.setBag_val_2(old_bag_val_2);
		
		ReserveService service = ReserveService.getInstance();
		service.modifyRsv(dto, dto2);
		
		Forward forward=new Forward();
		forward.setForward(false);
		forward.setPath("reservedetail.2jo?rsv_no="+dto.getRsv_no());
		return forward;
	}

}