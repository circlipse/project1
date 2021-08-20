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

	private NoticeDAO() {
	}

	public List<NoticeDTO> getList(Connection conn, int startrow, int endrow) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		List<NoticeDTO> list = new ArrayList<NoticeDTO>();
		sql.append(" SELECT * 									");
		sql.append(" FROM (SELECT S.*,@rownum:=@rownum+1 rnum   ");
		sql.append(" FROM (SELECT notice_no, notice_title, notice_readno FROM notice_2jo rv	");
		sql.append(" ,(SELECT @ROWNUM := 0) R					");
		sql.append(" WHERE 1=1  ) S								");
		sql.append(" ORDER BY notice_no DESC) AS A					");
		sql.append(" WHERE rnum >= ? AND rnum <=?				");
		
		System.out.println(sql);

		ResultSet rs=null;
		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs =pstmt.executeQuery();
			
			while (rs.next()) {
				NoticeDTO dto = new NoticeDTO();

				dto.setNotice_no(rs.getInt("notice_no"));
				dto.setNotice_title(rs.getString("notice_title"));
				dto.setNotice_readno(rs.getInt("notice_readno"));

				list.add(dto);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}

		return list;
	}

	public int addNotice(Connection conn, NoticeDTO dto, String fileRealName) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into notice_2jo (notice_title,notice_content,notice_readno,notice_img) ");
		sql.append(" values (?,?,0,?) ");
		System.out.println(sql);
		int result = 0;
		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, dto.getNotice_title());
			pstmt.setString(2, dto.getNotice_content());
			pstmt.setString(3, fileRealName);
			System.out.println( dto.getNotice_title());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e);
		}
		return result;
	}

	public NoticeDTO detail(Connection conn, int notice_no) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(" select notice_no, notice_title, notice_content ");
		sql.append(" , notice_img ");
		sql.append(" from notice_2jo where notice_no= ? ");
		System.out.println(sql);

		NoticeDTO dto = new NoticeDTO();
		ResultSet rs = null;
		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setInt(1, notice_no);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				dto.setNotice_no(rs.getInt("notice_no"));
				dto.setNotice_title(rs.getString("notice_title"));
				dto.setNotice_content(rs.getString("notice_content"));
				dto.setNotice_img(rs.getString("notice_img"));
				
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return dto;
	}

	public int modify(Connection conn, int notice_no, String notice_title, String notice_content) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(" update notice_2jo set  notice_title =? ,notice_content =?");
		sql.append(" where notice_no = ? ");

		int result = 0;
		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, notice_title);
			pstmt.setString(2, notice_content);
			pstmt.setInt(3, notice_no);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e);
		}
		return result;
	}

	public int del(Connection conn, int notice_no) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(" delete from notice_2jo	");
		sql.append(" where notice_no = ?		");

		int result = 0;
		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setInt(1, notice_no);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e);
		}
		return result;
	}

	public int totalCount(Connection conn) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(" select count(*) from notice_2jo ");

		ResultSet rs=null;
		int totalCount = 0;
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
				rs =pstmt.executeQuery();
				if(rs.next()) {
					totalCount=rs.getInt(1);
			}
				
		}catch (Exception e) {
				System.out.println(e);
		} 
			return totalCount;
	}

	public int readcount(Connection conn, int notice_no) {
		// TODO Auto-generated method stub
		StringBuilder sql=new StringBuilder();
		sql.append("  update    notice_2jo                   ");
		sql.append("  set                                    ");
		sql.append("      notice_readno=ifnull(notice_readno, 0)+1 ");
		sql.append("  where   notice_no = ?                     ");
		
		int result=0;
		try(
			PreparedStatement pstmt=conn.prepareStatement(sql.toString());
			)
		{
			pstmt.setInt(1, notice_no);
			result=pstmt.executeUpdate();
			
		}catch(SQLException e)
		{
			System.out.println(e);
		}
		return result;
	}

}
