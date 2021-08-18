package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.NoticeDTO;

public class NoticeDAO {
	private static NoticeDAO dao = new NoticeDAO();
	public static NoticeDAO getinstace() {
		return dao;
	}
	private NoticeDAO() {}
	public List<NoticeDTO> getList(Connection conn) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		List<NoticeDTO> list =new ArrayList<NoticeDTO>();
		sql.append(" select notice_no, notice_title, notice_readno from notice_2jo ");
		System.out.println(sql);
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				ResultSet rs = pstmt.executeQuery();){
			while (rs.next()) {
				NoticeDTO dto = new NoticeDTO();
				
				dto.setNotice_no(rs.getInt("notice_no"));
				dto.setNotice_title(rs.getString("notice_title"));
				dto.setNotice_readno(rs.getInt("notice_readno"));
				
				list.add(dto);
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
		
		return list;
	}
	public int addNotice(Connection conn, NoticeDTO dto) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into notice_2jo (notice_title,notice_content,notice_readno) ");
		sql.append(" values (?,?,0) ");
		System.out.println(sql);
		int result = 0;
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			pstmt.setString(1, dto.getNotice_title());
			pstmt.setString(2, dto.getNotice_content());
			
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	public NoticeDTO detail(Connection conn, int notice_no) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(" select notice_no, notice_title, notice_content from notice_2jo where notice_no= ? ");
		System.out.println(sql);
		
		NoticeDTO dto =new NoticeDTO();
		ResultSet rs = null;
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			pstmt.setInt(1, notice_no);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				dto.setNotice_no(rs.getInt("notice_no"));
				dto.setNotice_title(rs.getString("notice_title"));
				dto.setNotice_content(rs.getString("notice_content"));
				
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
		return dto;
	}

}
