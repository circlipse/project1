package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.ReserveDTO;

public class cartDAO {
	public void modifyCart(Connection conn, ReserveDTO dto) {
		StringBuilder sql = new StringBuilder();
		sql.append(" update cart_2jo                     ");
		sql.append(" set    bag_no = ?                   ");
		sql.append("        , bag_val = ?                ");
		sql.append(" where rsv_no = ? and bag_no = ?     ");
		
		try(
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());	
			){
			pstmt.setInt(1, dto.getBag_no());
			pstmt.setInt(2, dto.getBag_val());
			pstmt.setInt(3, dto.getRsv_no());
			pstmt.setInt(4, dto.getBag_val()); 
			pstmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e);
		} 
	}
}
