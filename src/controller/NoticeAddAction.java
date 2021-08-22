package controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import comm.Forward;
import dto.NoticeDTO;
import dto.UserDTO;
import service.NoticeService;

public class NoticeAddAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");

//		 String uploadDir =this.getClass().getResource("").getPath();
//
//		 uploadDir = uploadDir.substring(1,uploadDir.indexOf(".metadata"))
//				 +"p2jo/WebContent/uploadImage";

//		File path = new File("p2jo/WebContent/uploadImage");
//		String uploadDir=path.getAbsolutePath();

		String uploadDir2 = request.getSession().getServletContext().getRealPath("/");

		String uploadDir = uploadDir2 + "uploadImage";

		int maxSize = 1024 * 1024 * 100;

		String encoding = "UTF-8";

		MultipartRequest multipartRequest = new MultipartRequest(request, uploadDir, maxSize, encoding,
				new DefaultFileRenamePolicy());

		String fileName = multipartRequest.getOriginalFileName("fileName");
		String fileRealName = multipartRequest.getFilesystemName("fileName");

		NoticeDTO dto = new NoticeDTO();

//		String realFolder = "";
//		String filename1 = "";
//		int maxSize = 1024 * 1024 * 100;
//		String encType = "utf-8";
//		String savefile = "img";
//		ServletContext scontext = request.getSession().getServletContext();
//		realFolder = scontext.getRealPath(savefile);
//
//		try {
//			MultipartRequest multi = 
//					new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
//
//			Enumeration<?> files = multi.getFileNames();
//			String file1 = (String) files.nextElement();
//			filename1 = multi.getFilesystemName(file1);
//			String notice_title = multi.getParameter("notice_title");
//			String notice_content = multi.getParameter("notice_content");
//			
//			String Notice_img = realFolder + "\\" + filename1;
//			request.setAttribute("Notice_img", Notice_img);
//			request.setAttribute("dto", dto);
//
//			System.out.println(Notice_img);
//			dto.setNotice_title(notice_title);
//			dto.setNotice_content(notice_content);
//			dto.setNotice_img(Notice_img);
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		String notice_title = multipartRequest.getParameter("notice_title");
		String notice_content = multipartRequest.getParameter("notice_content");
		dto.setNotice_title(notice_title);
		dto.setNotice_content(notice_content);

		NoticeService service = NoticeService.getinstace();

		int result = service.noticAdd(dto, fileRealName);

		request.setAttribute("result", result);
		Forward forward = new Forward();
		forward.setForward(true);
		forward.setPath("/WEB-INF/main.jsp?page=user/noticeaddresult.jsp");

		return forward;
	}

}