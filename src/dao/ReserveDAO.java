package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.ReserveDTO;

public class ReserveDAO {
	private static ReserveDAO dao = new ReserveDAO();

	public static ReserveDAO getInstance() {
		return dao;
	}

	private ReserveDAO() {
	}



	public int addRsv(Connection conn, ReserveDTO dto) {
		StringBuilder sql = new StringBuilder();
		
		/*
		 * System.out.println(dto.getSub_date()); System.out.println(dto.getUser_no());
		 * System.out.println(dto.getRsv_content());
		 * System.out.println(dto.getRsv_date());
		 * System.out.println(dto.getAddr_arrive());
		 * System.out.println(dto.getAddr_depart());
		 */
		 
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
		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString(),
				PreparedStatement.RETURN_GENERATED_KEYS);) {
			pstmt.setString(1, dto.getSub_date());
			pstmt.setInt(2, dto.getUser_no());
			pstmt.setString(3, dto.getRsv_date());
			pstmt.setString(4, dto.getRsv_content());
			pstmt.setString(5, dto.getAddr_depart());
			pstmt.setString(6, dto.getAddr_arrive());
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();

			if (rs.next()) {
				key = rs.getInt(1);
				// System.out.println(key);
			}

		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
		}
		return key;
	}

	public ReserveDTO detailRsv(Connection conn, int rsv_no) {
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
		sql.append(" where r1.rsv_no = ?                           ");

		ReserveDTO dto = new ReserveDTO();
		ResultSet rs = null;
		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setInt(1, rsv_no);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				dto.setRsv_no(rs.getInt("r1.rsv_no"));
				dto.setUser_no(rs.getInt("r1.user_no"));
				dto.setSub_date(rs.getString("sub_date"));
				dto.setRsv_date(rs.getString("rsv_date"));
				dto.setRsv_content(rs.getString("rsv_content"));
				dto.setAddr_depart(rs.getString("addr_depart"));
				dto.setAddr_arrive(rs.getString("addr_arrive"));
				dto.setUser_name(rs.getString("user_name"));
				dto.setUser_phone(rs.getString("user_phone"));
				dto.setBag_no(rs.getInt("bag_no"));
				dto.setBag_val(rs.getInt("bag_val"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (rs != null) try {rs.close();} catch (SQLException e) {}
		}
		return dto;
	}

	public void delRsv(Connection conn, int rsv_no) {
		StringBuilder sql = new StringBuilder();
		sql.append(" delete from reserve_2jo       ");
		sql.append(" where rsv_no = ?              ");
			
		try(
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){
			pstmt.setInt(1, rsv_no);
			pstmt.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println(e);
		}
		
	}

	public List<ReserveDTO> getRsvList(Connection conn, String id) {
		// TODO Auto-generated method stub
		StringBuilder sql=new StringBuilder();
		  sql.append(" select *                                                                   ");
		  sql.append(" from ( select @rownum:=@rownum+1 rnum, rv.rsv_no, rv.rsv_date              ");
		  sql.append("        from (select re.* ,us.user_id                                       ");
		  sql.append("              from user_2jo us                                              ");
		  sql.append("              inner join reserve_2jo re on us.user_no = re.user_no          ");
		  sql.append("              where user_id = ?                                             ");
		  sql.append("              order by re.rsv_date asc) rv,                                 ");
		  sql.append("              (select @rownum := 0 ) R                                      ");
		  sql.append("       where 1=1                                                            ");
		  sql.append("       order by rnum)   LIST                                                "); 
		
		ResultSet rs=null;
		List<ReserveDTO> arr=new ArrayList<ReserveDTO>();
		try(
			PreparedStatement pstmt=conn.prepareStatement(sql.toString());
			)
		{
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();	
			while(rs.next())
			{
				ReserveDTO dto=new ReserveDTO();
				dto.setRnum(rs.getInt("rnum"));
				dto.setRsv_no(rs.getInt("rsv_no"));
				dto.setRsv_date(rs.getString("rsv_date"));
				arr.add(dto);
			}
		}
		catch(SQLException e) {
			System.out.println(e);
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
		}
		
		return arr;
		
	}
	
	public void modifyReserve(Connection conn, ReserveDTO dto) {
		StringBuilder sql = new StringBuilder();
		sql.append(" update reserve_2jo         ");
		sql.append(" set      rsv_date = ?      ");
		sql.append("        , sub_date = ?      ");
		sql.append("        , addr_depart = ?   ");
		sql.append("        , addr_arrive = ?   ");
		sql.append("        , rsv_content = ?   ");
		sql.append(" where rsv_no = ?           ");

		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		) {
			pstmt.setString(1, dto.getRsv_date());
			pstmt.setString(2, dto.getSub_date());
			pstmt.setString(3, dto.getAddr_depart());
			pstmt.setString(4, dto.getAddr_arrive());
			pstmt.setString(5, dto.getRsv_content());
			pstmt.setInt(6, dto.getRsv_no());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public int getUserNo(Connection conn, String id) {
		StringBuilder sql = new StringBuilder();
		sql.append(" select user_no          ");
		sql.append(" from user_2jo           ");
		sql.append(" where user_id = ?       ");
		
		ResultSet rs = null;
		int user_no = 0;
		try (
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
						
		){
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user_no = rs.getInt("user_no");
			}
		} catch(SQLException e) {
			System.out.println(e);
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
		}
		return user_no;
	}


}