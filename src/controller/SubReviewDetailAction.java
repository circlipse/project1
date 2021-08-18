package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import dto.SubReviewDTO;
import service.ReviewService;

/**
 * Servlet implementation class SubReviewDetailAction
 */
@WebServlet("/subdetail.2jo")
public class SubReviewDetailAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubReviewDetailAction() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doReq(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doReq(request, response);
	}


	private void doReq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		int rev_no=Integer.parseInt(request.getParameter("rev_no"));
		
		ReviewService service=ReviewService.getInstance();
		List<SubReviewDTO> sublist=service.subDetail(rev_no);
		
		JSONArray arr=new JSONArray();
		for(SubReviewDTO dto : sublist)
		{
			JSONObject subobject=new JSONObject();
			subobject.put("subno", dto.getSubno());
			subobject.put("subcontent", dto.getSubcontent());
			subobject.put("rev_no", dto.getRev_no());
			
			arr.add(subobject);
			
		}
		out.print(arr);
	}
	
	
}


