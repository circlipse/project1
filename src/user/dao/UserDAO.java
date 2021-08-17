package user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import user.dto.UserDTO;

public class UserDAO {

	private static UserDAO dao = new UserDAO();
	public static UserDAO getinstance() {
		return dao;
	}
	private UserDAO() {}
	public List<UserDTO> getList(Connection conn) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		List<UserDTO> list =new ArrayList<UserDTO>();
		sql.append(" select user_no, user_id, user_pwd, user_name, user_phone from user_2jo ");
		System.out.println(sql);
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				ResultSet rs = pstmt.executeQuery()){

			while (rs.next()) {
				UserDTO dto = new UserDTO();
				
				dto.setUser_no(rs.getInt("user_no"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setUser_pwd(rs.getString("user_pwd"));
				dto.setUser_name(rs.getString("user_name"));
				dto.setUser_phone(rs.getString("user_phone"));
				list.add(dto);
			}
			
		}catch(SQLException e) {
			System.out.println(e);
		}
		
		return list;
	}
	public int userJoin(Connection conn, UserDTO dto) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into user_2jo (user_id,user_pwd,user_name,user_phone) ");
		sql.append(" values (?,?,?,?) ");
		
		int result = 0;
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			pstmt.setString(1, dto.getUser_id());
			pstmt.setString(2, dto.getUser_pwd());
			pstmt.setString(3, dto.getUser_name());
			pstmt.setString(4, dto.getUser_phone());
			
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
}
