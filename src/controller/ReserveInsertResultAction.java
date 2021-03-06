package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comm.Forward;
import dto.ReserveDTO;
import service.ReserveService;
 
public class ReserveInsertResultAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		System.out.println("예약결과확인"+id);
		int user_no=Integer.parseInt(request.getParameter("user_no"));
		String rsv_date=request.getParameter("rsv_date");
        String sub_date=request.getParameter("sub_date");
        String addr_depart=request.getParameter("addr_depart");
        String addr_arrive=request.getParameter("addr_arrive");
        
        String bagval_1 = request.getParameter("bag_val_1");
        int bag_val_1=0;
        if(bagval_1 != "" && bagval_1 != null)
        {
        	bag_val_1=Integer.parseInt(bagval_1);
        }
        String bagval_2 = request.getParameter("bag_val_2");
        int bag_val_2 = 0;
        if(bagval_2 != ""  && bagval_2 != null)
        {
        	bag_val_2=Integer.parseInt(bagval_2);
        }
        String rsv_content=request.getParameter("rsv_content");

        ReserveService service=ReserveService.getInstance();
        ReserveDTO dto=new ReserveDTO();
        dto.setRsv_date(rsv_date);
        dto.setSub_date(sub_date);
        dto.setAddr_depart(addr_depart);
        dto.setAddr_arrive(addr_arrive);
        dto.setBag_val_1(bag_val_1);
        dto.setBag_val_2(bag_val_2);
        dto.setRsv_content(rsv_content);
        dto.setUser_no(user_no);

        int rsv_no = service.insertRsv(dto);
        //System.out.println("에약번호" + rsv_no);

        Forward forward=new Forward();
        if (id == null) {
        	forward.setForward(false);
        	forward.setPath("login.2jo");
        } else {
        	forward.setForward(false);
        	forward.setPath("reserveinsertdetail.2jo?rsv_no="+rsv_no);
        	session.setAttribute("id", id);
        }
        return forward;

	}

}
