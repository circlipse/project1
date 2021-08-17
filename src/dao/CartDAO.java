package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.ReserveDTO;

public class CartDAO {
        private static CartDAO dao = new CartDAO();
	public static CartDAO getInstance() {
		return dao;
	}
	private CartDAO() {}

	public void modifyCart(Connection conn, ReserveDTO dto) {
		StringBuilder sql = new StringBuilder();
		sql.append(" update cart_2jo                     ");
		sql.append(" set    bag_val = ?                ");
		sql.append(" where rsv_no = ? and bag_no = ?     ");
		
		try(
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());	
			){
			pstmt.setInt(1, dto.getBag_val_1());
			pstmt.setInt(2, dto.getRsv_no());
			pstmt.setInt(3, dto.getBag_no());
			pstmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e);
		} 
	}
	public void addRsv(Connection conn, int bag_no, int rsv_no, int val) {
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into cart_2jo (            ");
		sql.append("                       rsv_no      ");
		sql.append("                       , bag_no    ");
		sql.append("                       , bag_val)  ");
		sql.append(" values( ?, ?, ?)                  ");
		
		
		
		try(
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());	
			){
			pstmt.setInt(1, rsv_no);
			pstmt.setInt(2, bag_no);
			pstmt.setInt(3, val);
			pstmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e);
		}
				
	}
}
