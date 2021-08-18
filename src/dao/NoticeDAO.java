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
		
		return null;
	}

}
