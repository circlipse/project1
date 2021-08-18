package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.ReviewDTO;
import dto.SubReviewDTO;
import dto.UserDTO; 

public class ReviewDAO {

	public List<ReviewDTO> getList(Connection conn, int startrow, int endrow) {
		
		StringBuilder sql=new StringBuilder();
		  sql.append("   select *                                     ");
		  sql.append("   from (                                       ");
		  sql.append("          select                                ");
		  sql.append("                @rownum:=@rownum+1 rnum, rv.*   ");
		  sql.append("          from review_2jo rv,                   ");
		  sql.append("                  (                             ");
		  sql.append("                    select @ROWNUM := 0) R      ");
		  sql.append("                    where 1=1) LIST             ");
     	  sql.append(" where rnum >= ? and rnum <=?               ");
		
		ResultSet rs=null;
		List<ReviewDTO> arr=new ArrayList<ReviewDTO>();
		try(
			PreparedStatement pstmt=conn.prepareStatement(sql.toString());
			)
		{
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				ReviewDTO dto=new ReviewDTO();
				dto.setRev_no(rs.getInt("rev_no"));
				dto.setRev_title(rs.getString("rev_title"));
				dto.setRev_readno(rs.getInt("rev_readno"));
				
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

	public int addReadCount(int rev_no, Connection conn) {
		
		StringBuilder sql=new StringBuilder();
		sql.append("  update    review_2jo                   ");
		sql.append("  set                                    ");
		sql.append("      rev_readno=ifnull(rev_readno, 0)+1 ");
		sql.append("  where   rev_no = ?                     ");
		
		int result=0;
		try(
			PreparedStatement pstmt=conn.prepareStatement(sql.toString());
			)
		{
			pstmt.setInt(1, rev_no);
			result=pstmt.executeUpdate();
			
		}catch(SQLException e)
		{
			System.out.println(e);
		}
		return result;
		
	}

	public ReviewDTO ReviewDetail(Connection conn, int rev_no) {
		
		StringBuilder sql=new StringBuilder();
		sql.append(" select                                   ");
		sql.append("          re.rev_no                       ");
		sql.append("         ,re.rev_title                    ");
		sql.append("         ,us.user_id                      ");
		sql.append("         ,re.rev_content                  ");
		sql.append("         ,re.rev_readno                   ");
		sql.append("  from user_2jo us                        ");
		sql.append("  inner join review_2jo re on us.user_no  ");
		sql.append("  = re.user_no                            ");
		sql.append(" where rev_no = ?                        ");
		
		ReviewDTO dto=new ReviewDTO();
		
		ResultSet rs=null;
		try(PreparedStatement pstmt=conn.prepareStatement(sql.toString());
			)
		{
			pstmt.setInt(1, rev_no);
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				dto.setRev_no(rs.getInt("rev_no"));
				dto.setRev_title(rs.getString("rev_title"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setRev_content(rs.getString("rev_content"));
				dto.setRev_readno(rs.getInt("rev_readno"));
			}
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		
		return dto;
	}

	public int ReviewInsert(Connection conn, ReviewDTO dto, int userno) {
		
		StringBuilder sql=new StringBuilder();
		sql.append(" insert into     review_2jo ( user_no               ");
		sql.append("                            ,rev_title              ");
		sql.append("                            ,rev_content            ");
		sql.append("                     		,rev_readno  )          ");
		sql.append("    values       (? ,?, ?, 0 )                         ");
		
		int result=0;
		try(PreparedStatement pstmt=conn.prepareStatement(sql.toString());
			){
			pstmt.setInt(1, userno);
			pstmt.setString(2, dto.getRev_title());
			pstmt.setString(3, dto.getRev_content());
			
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println(e);
		}
		return result;
	}

	public void ReviewModify(Connection conn, ReviewDTO dto) {
		StringBuilder sql=new StringBuilder();
		sql.append("  update       review_2jo        ");
		sql.append("  set                            ");
		sql.append("            rev_title = ?        ");
		sql.append("           ,rev_content = ?      ");
		sql.append("  where rev_no = ?               ");
		
		
		try(
			PreparedStatement pstmt=conn.prepareStatement(sql.toString());
			)
		{
			pstmt.setString(1, dto.getRev_title());
			pstmt.setString(2, dto.getRev_content());
			pstmt.setInt(3, dto.getRev_no());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e);
		}


	}

	public void ReviewDelete(Connection conn, int rev_no) {
		StringBuilder sql=new StringBuilder();
		sql.append(" delete from review_2jo          ");
		sql.append(" where  rev_no=?                  ");
		
		try(PreparedStatement pstmt=conn.prepareStatement(sql.toString());
			)
		{
			pstmt.setInt(1, rev_no);
			pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public int getToTalCount(Connection conn) {
		
		StringBuilder sql=new StringBuilder();
	    sql.append("   select    count(*)                ");
	    sql.append("   from review_2jo                   ");
	    
	    int totalcount=0;
	    ResultSet rs=null;
	    try(PreparedStatement pstmt=conn.prepareStatement(sql.toString());
	    	)
	    {
	    	rs=pstmt.executeQuery();
	    	
	    	if(rs.next()) {
	    		totalcount=rs.getInt(1);
	    	}
	    }
	    catch(SQLException e)
	    {
	    	System.out.println(e);
	    }
	    
		return totalcount;
	}

	public void insertsub(Connection conn, SubReviewDTO dto) {
		
		StringBuilder sql=new StringBuilder();
		sql.append(" insert into  subreview_2jo (               ");
		sql.append("                     		 subcontent     ");
		sql.append("                     		,rev_no    )    ");
		sql.append(" values( ?, ? ) ");
		
		try(PreparedStatement pstmt=conn.prepareStatement(sql.toString());
			)
		{
			pstmt.setString(1, dto.getSubcontent());
			pstmt.setInt(2, dto.getRev_no());
			
			pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		
	}

	public List<SubReviewDTO> subdetail(Connection conn, int rev_no) {
		
		StringBuilder sql=new StringBuilder();
		sql.append("  select                        ");
		sql.append("            subno               ");
		sql.append("           ,subcontent          ");
		sql.append("           ,rev_no              ");
		sql.append("  from subreview_2jo            ");
		sql.append("  where rev_no = ?              ");
		
		
		ResultSet rs=null;
		List<SubReviewDTO> list=new ArrayList<SubReviewDTO>();
		try(PreparedStatement pstmt=conn.prepareStatement(sql.toString());
			){
			pstmt.setInt(1, rev_no);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				SubReviewDTO dto=new SubReviewDTO();
				dto.setSubno(rs.getInt("subno"));
				dto.setSubcontent(rs.getString("subcontent"));
				dto.setRev_no(rs.getInt("rev_no"));
				list.add(dto);
			}
			
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
		}
		return list;

	}

	public void deletesub(Connection conn, int subno, int rev_no) {
		
		StringBuilder sql=new StringBuilder();
		sql.append(" delete from subreview_2jo       ");
		sql.append(" where  subno=?                  ");
		
		try(PreparedStatement pstmt=conn.prepareStatement(sql.toString());
			)
		{
			pstmt.setInt(1, subno);
			pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

	public UserDTO usernorsv(Connection conn, String id) {
		// TODO Auto-generated method stub
		StringBuilder sql=new StringBuilder();
		sql.append("  select                       ");
		sql.append("            user_no            ");
		sql.append("  from user_2jo 	           ");
		sql.append("  where user_id = ?           ");
		
		System.out.println("id는 "+id);
		ResultSet rs=null;
		UserDTO dto=new UserDTO();
		try(PreparedStatement pstmt=conn.prepareStatement(sql.toString());
				){
				pstmt.setString(1, id);
				rs=pstmt.executeQuery();
				
				if(rs.next()) {
					dto.setUser_no(rs.getInt("user_no"));
				}
				
			}catch(SQLException e) {
				System.out.println(e);
			}finally {
				if(rs!=null) try {rs.close();} catch(SQLException e) {}
			}
			return dto;
	}


		
}
	
	




	
	
	

	

