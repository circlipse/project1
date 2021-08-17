package user.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import user.comm.DBConnection;
import user.dao.UserDAO;
import user.dto.UserDTO;

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
}
