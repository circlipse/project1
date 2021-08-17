package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.Forward;
import dto.ReserveDTO;
import service.ReserveService;

public class ReserveInsertResultAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String rsv_date=request.getParameter("rsv_date");
         String sub_date=request.getParameter("sub_date");
         String addr_depart=request.getParameter("addr_depart");
        String addr_arrive=request.getParameter("addr_arrive");
         
         
         String bag_val_1=request.getParameter("bag_val_1");
         int bagval_1=0;
         if(bag_val_1!=null)
         {
        	 bagval_1=Integer.parseInt(bag_val_1);
         }
         String bag_val_2=request.getParameter("bag_val_2");
         int bagval_2=0;
         if(bag_val_2!=null)
         {
        	 bagval_2=Integer.parseInt(bag_val_2);
         }
         String rsv_content=request.getParameter("rsv_content");
         
         ReserveService service=ReserveService.getInstance();
         ReserveDTO dto=new ReserveDTO();
         dto.setRsv_date(rsv_date);
         dto.setSub_date(sub_date);
         dto.setAddr_depart(addr_depart);
         dto.setAddr_depart(addr_arrive);
         
         service.insertRsv(dto);
         
         Forward forward=new Forward();
         forward.setForward(false);
         forward.setPath("reservedetail.2jo");
         return forward;

	}

}
