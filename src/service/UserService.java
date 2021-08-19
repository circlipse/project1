package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import comm.DBConnection;
import dao.UserDAO;
import dto.UserDTO;

public class UserService {
	
	private static UserService service = new UserService();
	public static UserService getInstance() {
		return service;
	} 
	private UserService() {}
	
	public List<UserDTO> getList() {
		// TODO Auto-generated method stub
		
		DBConnection dbconn = DBConnection.getdbInstance();
		Connection conn =null;
		List<UserDTO> list =new ArrayList<UserDTO>();
		
		try {
			conn= dbconn.getConnection();
			UserDAO dao = UserDAO.getinstance();
			list = dao.getList(conn);
		}catch (SQLException|NamingException e) {
			// TODO: handle exception
		}finally {
			if (conn != null)try {conn.close();} catch (SQLException e) {}
		}
		
		return list;
	}
	public int join(UserDTO dto) {
		// TODO Auto-generated method stub

		DBConnection dbconn = DBConnection.getdbInstance();
		Connection conn =null;
		int result=0;
		try {
			conn= dbconn.getConnection();
			UserDAO dao = UserDAO.getinstance();
			result = dao.userJoin(conn,dto);
		}catch (SQLException|NamingException e) {
			// TODO: handle exception
		}finally {
			if (conn != null)try {conn.close();} catch (SQLException e) {}
		}
		
		return result;
	}
	public int checkUser(String id, String pwd) {
		// TODO Auto-generated method stub
		DBConnection dbconn = DBConnection.getdbInstance();
		Connection conn =null;
		int result=0;
		try {
			conn= dbconn.getConnection();
			UserDAO dao = UserDAO.getinstance();
			result = dao.userCheck(conn,id,pwd);
		}catch (SQLException|NamingException e) {
			// TODO: handle exception
		}finally {
			if (conn != null)try {conn.close();} catch (SQLException e) {}
		}
		
		return result;
	}
	public UserDTO userDetail(String id) {
		// TODO Auto-generated method stub
		DBConnection dbconn = DBConnection.getdbInstance();
		Connection conn =null;
		UserDTO dto =null;
		
		try {
			conn= dbconn.getConnection();
			UserDAO dao = UserDAO.getinstance();
			dto = dao.userDetail(conn,id);
		}catch (SQLException|NamingException e) {
			// TODO: handle exception
		}finally {
			if (conn != null)try {conn.close();} catch (SQLException e) {}
		}
		
		return dto;
	}
	public int userDel(String id) {
		// TODO Auto-generated method stub
		DBConnection dbconn = DBConnection.getdbInstance();
		Connection conn =null;
		int result=0;
		try {
			conn= dbconn.getConnection();
			UserDAO dao = UserDAO.getinstance();
			result = dao.userDel(conn,id);
		}catch (SQLException|NamingException e) {
			// TODO: handle exception
		}finally {
			if (conn != null)try {conn.close();} catch (SQLException e) {}
		}
		
		return result;
	}
	public int usermodify(UserDTO dto, String id) {
		// TODO Auto-generated method stub
		DBConnection dbconn = DBConnection.getdbInstance();
		Connection conn =null;
		int result=0;
		try {
			conn= dbconn.getConnection();
			UserDAO dao = UserDAO.getinstance();
			result = dao.userModi(conn,dto,id);
		}catch (SQLException|NamingException e) {
			// TODO: handle exception
		}finally {
			if (conn != null)try {conn.close();} catch (SQLException e) {}
		}
		
		return result;
	}
	
	public UserDTO selectUser(String inputid){
		
		DBConnection dbconn = DBConnection.getdbInstance();
		Connection conn = null;
		UserDTO dto = new UserDTO();
		
		try {
			conn = dbconn.getConnection();
			UserDAO dao = UserDAO.getinstance();
			dto = dao.selectUser(conn, inputid);	
			
		}catch(SQLException | NamingException e) {
			System.out.println(e);
			
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		return dto;
		
	}
	public int overlapId(String id) {
		// TODO Auto-generated method stub
		DBConnection dbconn = DBConnection.getdbInstance();
		Connection conn = null;
		
		int result = 0;
		
		try {
			conn = dbconn.getConnection();
			UserDAO dao = UserDAO.getinstance();
			result =dao.overlapId(conn,id);
		}catch(SQLException | NamingException e) {
			System.out.println(e);
			
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		return result;
	}
}
