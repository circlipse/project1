package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import comm.Forward;
import service.NoticeService;

public class NoticeModifyAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");
		//
		 String uploadDir =this.getClass().getResource("").getPath();

		 uploadDir = uploadDir.substring(1,uploadDir.indexOf(".metadata"))
				 +"p2jo/WebContent/uploadImage";
		
		 int maxSize = 1024 * 1024 * 100;

		String encoding = "UTF-8";
		
		MultipartRequest multipartRequest = 
				new MultipartRequest(request, uploadDir, maxSize, encoding,new DefaultFileRenamePolicy());

		String fileRealName = multipartRequest.getFilesystemName("fileName");

		
		
		//
		int notice_no = Integer.parseInt(multipartRequest.getParameter("notice_no"));
		String notice_title = multipartRequest.getParameter("notice_title");
		String notice_content = multipartRequest.getParameter("notice_content");
		
		NoticeService service = NoticeService.getinstace();
		
		int result = service.modify(notice_no,notice_title,notice_content,fileRealName);
		
		request.setAttribute("result", result);
		
		Forward f= new Forward();
		f.setForward(true);
		f.setPath("/WEB-INF/main.jsp?page=user/noticemodifyresult.jsp");
		return f;
	}

}
