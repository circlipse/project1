package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comm.Forward;
import dto.NoticeDTO;
import service.NoticeService;

public class NoticeListAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		request.setAttribute("id", id);
		
		String curr = request.getParameter("curr");
		int currpage = 1;
		if (curr != null) {
			currpage = Integer.parseInt(curr);
		}

		NoticeService service = NoticeService.getinstace();
		
		int totalcount = service.count();
		System.out.println("totalcount: "+totalcount);
		int pagesize = 10;
		int totalpage = (int) Math.ceil((float) totalcount / pagesize);

		int startrow = (currpage - 1) * pagesize + 1;
		int endrow = startrow + pagesize - 1;

		if (endrow > totalcount) {
			endrow = totalcount;
		}

		int pageblock = 5;
		int startblock = (currpage - 1) / pageblock * pageblock + 1;
		int endblock = startblock + pageblock - 1;
		if (endblock > totalpage) {
			endblock = totalpage;
		}

		System.out.println(startrow);
		System.out.println(endrow);
		
		
		List<NoticeDTO> list = new ArrayList<NoticeDTO>();
		
		list = service.getList(startrow, endrow);

		request.setAttribute("list", list);
		request.setAttribute("currpage", currpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startblock", startblock);
		request.setAttribute("endblock", endblock);
		request.setAttribute("datacount",list.size());
		
		Forward forward = new Forward();
		forward.setForward(true);
		forward.setPath("/WEB-INF/user/main.jsp?page=noticelist.jsp");
		
		return forward;
	}

}
