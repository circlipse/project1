package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import comm.Forward;
import service.ReviewService;

public class SubReviewDeleteAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");

		request.setAttribute("id", id);

		int subno = Integer.parseInt(request.getParameter("subno"));
		int rev_no = Integer.parseInt(request.getParameter("rev_no"));

		request.setAttribute("rev_no", rev_no);

		System.out.println(subno);
		ReviewService service = ReviewService.getInstance();

		String user_id = service.getUserid(subno);

		System.out.println("유저: " + user_id);
		System.out.println("세션id :" + id);

		Forward forward = new Forward();
		if (id == null) {

			forward.setForward(true);
			forward.setPath("/WEB-INF/main.jsp?page=review/ReviewSubDelFail.jsp");
		} else {

			if (id.equals(user_id)) {
				service.subDelete(subno, rev_no);

				forward.setForward(false);
				forward.setPath("reviewdetail.2jo?rev_no=" + rev_no);

			} else {

				forward.setForward(true);
				forward.setPath("/WEB-INF/main.jsp?page=review/ReviewSubDelFail.jsp");
			}
		}
		return forward;
	}

}
