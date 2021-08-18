package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.ReserveDTO;

public class CartDAO {
        private static CartDAO dao = new CartDAO();
	public static CartDAO getInstance() {
		return dao;
	}
	private CartDAO() {}
	
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
	public int getBagVal(Connection conn, int rsv_no, int val) {
		StringBuilder sql = new StringBuilder();
		sql.append(" select bag_no     ");
		sql.append("        , bag_val  ");
		sql.append(" from cart_2jo     ");
		sql.append(" where rsv_no = ? and bag_no = ? ");
		
		int bag_val = 0;
		ResultSet rs = null;
		try(
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());	
			){
			pstmt.setInt(1, rsv_no);
			pstmt.setInt(2, val);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				bag_val = rs.getInt("bag_val");
			}
		} catch(SQLException e) {
			System.out.println(e);
		}
		return bag_val;
	}
	public void delRsv(Connection conn, int rsv_no) {
		StringBuilder sql = new StringBuilder();
		sql.append(" delete from cart_2jo       ");
		sql.append(" where rsv_no = ?           ");

		try(
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){
			pstmt.setInt(1, rsv_no);
			pstmt.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println(e);
		}
		
	}
	
	public void modifyCart(Connection conn, int bag_no, int rsv_no, int bag_val) {
		StringBuilder sql = new StringBuilder();
		sql.append(" update cart_2jo                   ");
		sql.append(" set    bag_val = ?                ");
		sql.append(" where rsv_no = ? and bag_no = ?   ");
		
		try(
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());	
			){
			pstmt.setInt(1, bag_val);
			pstmt.setInt(2, rsv_no);
			pstmt.setInt(3, bag_no);
			pstmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e);
		} 
	}
	
}
