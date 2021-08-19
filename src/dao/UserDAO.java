package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.UserDTO;

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
	public int userCheck(Connection conn, String id, String pwd) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(" select count(*) from user_2jo		");
		sql.append(" where user_id = ? and user_pwd =? 	");
//		System.out.println(sql);
//		System.out.println(id);
//		System.out.println(pwd);
		ResultSet rs = null;
		int result =0;
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			pstmt.setString(1,id);
			pstmt.setString(2,pwd);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				result=rs.getInt(1);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return result;
	}
	public UserDTO userDetail(Connection conn, String id) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select user_id, user_pwd, user_name, user_phone from user_2jo ");
		sql.append(" where user_id=? ");
		System.out.println("detail "+sql);
		System.out.println("detail "+id);
		ResultSet rs = null;
		
		UserDTO dto = null;
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new UserDTO();
				
				dto.setUser_id(rs.getString("user_id"));
				dto.setUser_name(rs.getString("user_name"));
				dto.setUser_phone(rs.getString("user_phone"));
				
			}
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}finally {
			if (rs != null)try {rs.close();} catch (SQLException e) {}
		}
		return dto;
	}
	public int userDel(Connection conn, String id) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(" delete from user_2jo	");
		sql.append(" where user_id = ?		");
		
		int result = 0;
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			pstmt.setString(1, id);
			
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	public int userModi(Connection conn, UserDTO dto, String id) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(" update user_2jo set  user_pwd =? ,user_name =?,user_phone=? ");
		sql.append(" where user_id = ? ");
		
		int result = 0;
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			pstmt.setString(1, dto.getUser_pwd());
			pstmt.setString(2, dto.getUser_name());
			pstmt.setString(3, dto.getUser_phone());
			pstmt.setString(4, id);
			
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	public UserDTO selectUser(Connection conn, String inputid) {
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select 				");
		sql.append("		user_id			");
		sql.append(" from user_2jo 			");
		sql.append(" where user_id = ?		");
		
		
		UserDTO dto = new UserDTO();
		ResultSet rs = null;
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){
			pstmt.setString(1, inputid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setUser_id(rs.getString("user_id"));
			}	
			
		}catch(SQLException e) {
			System.out.println(e);
			
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException e){}
		}
			
		return dto;
	}
	public int overlapId(Connection conn, String id) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(" select 				");
		sql.append("		count(user_id)	");
		sql.append(" from user_2jo 			");
		sql.append(" where user_id = ?		");
		ResultSet rs =null;
		int result =0;
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					result = rs.getInt(1);
				}	
				
			}catch(SQLException e) {
				System.out.println(e);
				
			}finally {
				if(rs!=null) try {rs.close();} catch(SQLException e){}
			}
				
			return result;
	}
}
