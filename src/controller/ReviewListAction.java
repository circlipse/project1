package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import comm.Forward;
import dto.ReviewDTO;
import service.ReviewService;


public class ReviewListAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 request.setCharacterEncoding("utf-8");	
			
		  String curr=request.getParameter("curr"); 
		  
		   int currpage=1;
		   if(curr!=null)
		   {
			   currpage=Integer.parseInt(curr);
		   }
		
		ReviewService service=ReviewService.getInstance();
		int totalcount= service.getTotalCount();
		
		int pagepercount=5;
		
		int totalpage=(int) Math.ceil((float)totalcount/pagepercount);
		 
		 int startrow=(currpage-1)*pagepercount+1;
		 int endrow=startrow+pagepercount-1;
		 
		 if(endrow>totalcount)
			 endrow=totalcount;
		 
		 int blockcount=3;
		 int startblock=(currpage-1)/blockcount*blockcount+1;
		 int endblock=startblock+blockcount-1;
		 
		 if(endblock>totalpage)
		 {
			 endblock=totalpage;
		 }
		   
		
		List<ReviewDTO> reviewlist=service.getlist(startrow, endrow);
		
		request.setAttribute("reviewlist", reviewlist);
		request.setAttribute("currpage", currpage);
		request.setAttribute("datacount", reviewlist.size());
		request.setAttribute("startblock", startblock);
		request.setAttribute("endblock", endblock);
		request.setAttribute("totalpage", totalpage);

		
		Forward forward=new Forward();
		forward.setForward(true);
		forward.setPath("WEB-INF/review/ReviewList.jsp");
		
		return forward;
		
	}

}
