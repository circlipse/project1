package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.ReserveDTO;

public class ReserveDAO {
	
	public void modifyReserve(Connection conn, ReserveDTO dto){
		StringBuilder sql = new StringBuilder();
		sql.append(" update reserve_2jo         ");
		sql.append(" set    sub_date = ?        ");
		sql.append("        , rsv_date = ?      ");
		sql.append("        , rsv_content = ?   ");
		sql.append("        , addr_depart = ?   ");
		sql.append("        , addr_arrive = ?   ");
		sql.append(" where rsv_no = ?           ");
		
		try(
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
								
			){
			pstmt.setString(1, dto.getSub_date());
			pstmt.setString(2, dto.getRsv_date());
			pstmt.setString(3, dto.getRsv_content());
			pstmt.setString(4, dto.getAddr_depart());
			pstmt.setString(5, dto.getAddr_arrive());
			pstmt.setInt(6, dto.getRsv_no());
			pstmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e);
		}
	} 

}
