package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.ReserveDTO;

public class ReserveDAO {
	private static ReserveDAO dao=new ReserveDAO();
	   public static ReserveDAO getInstance()
	   {
	      return dao;
	   }
	   private ReserveDAO() {}
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
	public int addRsv(Connection conn, ReserveDTO dto) {
		// TODO Auto-generated method stub
		StringBuilder sql=new StringBuilder();
		sql.append(" insert into reserve_2jo (                     ");
		sql.append("                            sub_date           ");
		sql.append("                           , user_no           ");
		sql.append("                           , rsv_date          ");
		sql.append("                           , rsv_content       ");
		sql.append("                           , addr_depart       ");
		sql.append("                           , addr_arrive   )   ");
		sql.append(" values (?,?,?,?,?,?)                          ");
		
		int key = 0;
		ResultSet rs = null;
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());				
			){
			pstmt.setString(1, dto.getSub_date());
			pstmt.setInt(2, dto.getUser_no());
			pstmt.setString(3, dto.getRsv_date());
			pstmt.setString(4, dto.getRsv_content());
			pstmt.setString(5, dto.getAddr_depart());
			pstmt.setString(6, dto.getAddr_arrive());
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			
			if(rs.next()) {
				key = rs.getInt(1);
			}
			
		}catch(SQLException e) {
			System.out.println(e);
		} finally{
			if(rs != null) try {rs.close();} catch(SQLException e) {}
		}
		return key;
	}
	public void detailRsv(Connection conn, int rsv_no) {
		StringBuilder sql = new StringBuilder();
		sql.append(" select r1.rsv_no                              ");
		sql.append("        , r1.user_no                           ");
		sql.append("        , sub_date                             ");
		sql.append("        , rsv_date                             ");
		sql.append("        , rsv_content                          ");
		sql.append("        , addr_depart                          ");
		sql.append("        , addr_arrive                          ");
		sql.append("        , user_name                            ");
		sql.append("        , user_phone                           ");
		sql.append("        , bag_no                               ");
		sql.append("        , bag_val                              ");
		sql.append(" from reserve_2jo r1 inner join user_2jo u1    ");
		sql.append(" on r1.user_no = u1.user_no                    ");
		sql.append(" inner join cart_2jo c1                        ");
		sql.append(" on r1.rsv_no = c1.rsv_no                      ");
		sql.append(" where rsv_no = ?                              ");
		
		ResultSet rs = null;
		try(
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){
			pstmt.setInt(1, rsv_no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				ReserveDTO dto = new ReserveDTO();
			}
		} catch(SQLException e) {
			System.out.println(e);
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
		}
		
		
	} 

}
