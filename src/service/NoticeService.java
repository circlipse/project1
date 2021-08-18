package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import comm.DBConnection;
import dao.NoticeDAO;
import dto.NoticeDTO;

public class NoticeService {
	private static NoticeService service = new NoticeService();
	public static NoticeService getinstace() {
		return service;
	}
	private NoticeService() {}
	public List<NoticeDTO> getList() {
		// TODO Auto-generated method stub
		DBConnection dbconn = DBConnection.getdbInstance();
		Connection conn =null;
		List<NoticeDTO> list =new ArrayList<NoticeDTO>();
		
		try {
			conn = dbconn.getConnection();
			NoticeDAO dao = NoticeDAO.getinstace();
			list = dao.getList(conn);
		}catch(SQLException|NamingException e) {
			System.out.println(e);
		}finally {
			if (conn != null)try {conn.close();} catch (SQLException e) {}
		}
		
		return list;
	}
	public int noticAdd(NoticeDTO dto) {
		// TODO Auto-generated method stub
		DBConnection dbconn = DBConnection.getdbInstance();
		Connection conn =null;
		int result=0;
		try {
			conn = dbconn.getConnection();
			NoticeDAO dao = NoticeDAO.getinstace();
			result = dao.addNotice(conn,dto);
		}catch(SQLException|NamingException e) {
			System.out.println(e);
		}finally {
			if (conn != null)try {conn.close();} catch (SQLException e) {}
		}
		
		return result;
	}
}
