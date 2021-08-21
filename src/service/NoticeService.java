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
	public List<NoticeDTO> getList(int startrow, int endrow) {
		// TODO Auto-generated method stub
		DBConnection dbconn = DBConnection.getdbInstance();
		Connection conn =null;
		List<NoticeDTO> list =new ArrayList<NoticeDTO>();
		
		try {
			conn = dbconn.getConnection();
			NoticeDAO dao = NoticeDAO.getinstace();
			list = dao.getList(conn,startrow, endrow);
		}catch(SQLException|NamingException e) {
			System.out.println(e);
		}finally {
			if (conn != null)try {conn.close();} catch (SQLException e) {}
		}
		
		return list;
	}
	public int noticAdd(NoticeDTO dto, String fileRealName) {
		// TODO Auto-generated method stub
		DBConnection dbconn = DBConnection.getdbInstance();
		Connection conn =null;
		int result=0;
		try {
			conn = dbconn.getConnection();
			NoticeDAO dao = NoticeDAO.getinstace();
			result = dao.addNotice(conn,dto,fileRealName);
		}catch(SQLException|NamingException e) {
			System.out.println(e);
		}finally {
			if (conn != null)try {conn.close();} catch (SQLException e) {}
		}
		
		return result;
	}
	public NoticeDTO detail(int notice_no) {
		// TODO Auto-generated method stub
		DBConnection dbconn = DBConnection.getdbInstance();
		Connection conn =null;
		NoticeDTO dto = null;
		try {
			conn = dbconn.getConnection();
			NoticeDAO dao = NoticeDAO.getinstace();
			dto = dao.detail(conn,notice_no);
		}catch(SQLException|NamingException e) {
			System.out.println(e);
		}finally {
			if (conn != null)try {conn.close();} catch (SQLException e) {}
		}
		
		return dto;		
	}
	public int modify(int notice_no, String notice_title, String notice_content, String fileRealName) {
		// TODO Auto-generated method stub
		DBConnection dbconn = DBConnection.getdbInstance();
		Connection conn =null;
		int result = 0;
		try {
			conn = dbconn.getConnection();
			NoticeDAO dao = NoticeDAO.getinstace();
			result = dao.modify(conn,notice_no,notice_title,notice_content,fileRealName);
		}catch(SQLException|NamingException e) {
			System.out.println(e);
		}finally {
			if (conn != null)try {conn.close();} catch (SQLException e) {}
		}
		
		return result;	
	}
	public int del(int notice_no) {
		// TODO Auto-generated method stub
		DBConnection dbconn = DBConnection.getdbInstance();
		Connection conn =null;
		int result = 0;
		try {
			conn = dbconn.getConnection();
			NoticeDAO dao = NoticeDAO.getinstace();
			result = dao.del(conn,notice_no);
		}catch(SQLException|NamingException e) {
			System.out.println(e);
		}finally {
			if (conn != null)try {conn.close();} catch (SQLException e) {}
		}
		
		return result;	
	}
	public int count() {
		// TODO Auto-generated method stub
		DBConnection dbconn =DBConnection.getdbInstance();
		Connection conn=null;
		int totalcount=0;
		
		try{
			conn = dbconn.getConnection();
			NoticeDAO dao = NoticeDAO.getinstace();
			totalcount= dao.totalCount(conn);
			
		}catch(SQLException|NamingException e) {
			System.out.println(e);
		}finally {
			if (conn != null)try {conn.close();} catch (SQLException e) {}
		}
		return totalcount;
	}
	public int readcount(int notice_no) {
		// TODO Auto-generated method stub
		DBConnection dbconn = DBConnection.getdbInstance();
		Connection conn =null;
		int result = 0;
		try {
			conn = dbconn.getConnection();
			NoticeDAO dao = NoticeDAO.getinstace();
			result = dao.readcount(conn,notice_no);
		}catch(SQLException|NamingException e) {
			System.out.println(e);
		}finally {
			if (conn != null)try {conn.close();} catch (SQLException e) {}
		}
		
		return result;
	}
}
