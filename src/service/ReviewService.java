package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import comm.DBConnection;
import dao.ReviewDAO;
import dto.ReviewDTO;
import dto.SubReviewDTO;
import dto.UserDTO;


public class ReviewService {

	private static ReviewService instance = new ReviewService();
	
	public static ReviewService getInstance()
	{
		return instance;
	}
	
	private ReviewService() {}
	
	
	public int getTotalCount() {
		DBConnection dbconn=DBConnection.getdbInstance();
		Connection conn=null;
		
		int totalcount=0;
		try {
			conn=dbconn.getConnection();
			conn.setAutoCommit(false);
			ReviewDAO dao=new ReviewDAO();
			
			totalcount=dao.getToTalCount(conn);
			
			conn.commit();
		}catch(SQLException | NamingException e)
		{
			try {conn.rollback();} catch(Exception e2) {}
		}finally {
			if(conn!=null) try {conn.close();}catch(Exception e) {}
		}
		return totalcount;
	}
	
	
	public List<ReviewDTO> getlist(int startrow, int endrow) {
		
		DBConnection dbconn=DBConnection.getdbInstance();
		Connection conn=null;
		
		List<ReviewDTO> list=new ArrayList<ReviewDTO>();
		try {
			conn=dbconn.getConnection();
			ReviewDAO dao=new ReviewDAO();
			
			list=dao.getList(conn, startrow, endrow);
			
		}catch(SQLException | NamingException e) {
			System.out.println(e);
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
		return list;
	}
	
	public void addReadCount(int rev_no) {
		
		DBConnection dbconn=DBConnection.getdbInstance();
		Connection conn=null;
		
		try {
			conn=dbconn.getConnection();
			ReviewDAO dao=new ReviewDAO();
			
			dao.addReadCount(rev_no, conn);
			
		}catch(SQLException | NamingException e) {
			System.out.println(e);
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
	}
	
	public ReviewDTO detail(int rev_no) {

		DBConnection dbconn=DBConnection.getdbInstance();
		Connection conn=null;
		ReviewDTO dto=new ReviewDTO();
		try {
			conn=dbconn.getConnection();
			ReviewDAO dao=new ReviewDAO();
			dto=dao.ReviewDetail(conn, rev_no);
			
		}catch(SQLException | NamingException e)
		{
			System.out.println(e);
		}finally {
			if(conn!=null) try {conn.close();}catch(Exception e) {}
		}
		return dto;
	}

	public ReviewDTO reviewinsert(ReviewDTO dto, int userno) {
		
		DBConnection dbconn=DBConnection.getdbInstance();
		Connection conn=null;
		
		try {
			conn=dbconn.getConnection();
			ReviewDAO dao=new ReviewDAO();
			dao.ReviewInsert(conn, dto,userno);
			
		}catch(SQLException | NamingException e)
		{
			System.out.println(e);
		}finally {
			if(conn!=null) try {conn.close();}catch(Exception e) {}
		}
		return dto;
		
	}

	public void reviewmodify(ReviewDTO dto) {
		DBConnection dbconn=DBConnection.getdbInstance();
		Connection conn=null;
		ReviewDAO dao=new ReviewDAO();
		try {
			conn=dbconn.getConnection();
			conn.setAutoCommit(false);
			
			dao.ReviewModify(conn, dto);
			
			conn.commit();
			
		}catch(SQLException | NamingException e)
		{
			System.out.println(e);
		}finally {
			if(conn!=null) try {conn.close();}catch(Exception e) {}
		}
		
	}

	public void reviewdelete(int rev_no) {
		DBConnection dbconn=DBConnection.getdbInstance();
		Connection conn=null;
		
		try {
			conn=dbconn.getConnection();
			ReviewDAO dao=new ReviewDAO();
			dao.ReviewDelete(conn, rev_no);
			
		}catch(SQLException | NamingException e)
		{
			System.out.println(e);
		}finally {
			if(conn!=null) try {conn.close();}catch(Exception e) {}
		}
		
	}

	public List<SubReviewDTO> subDetail(int rev_no) {
		// TODO Auto-generated method stub
		
		DBConnection dbconn=DBConnection.getdbInstance();
		Connection conn=null;
		
		List<SubReviewDTO> sublist=new ArrayList<SubReviewDTO>();
		try {
			conn=dbconn.getConnection();
			ReviewDAO dao=new ReviewDAO();
			sublist=dao.subdetail(conn, rev_no);
			
		}catch(SQLException | NamingException e)
		{
			System.out.println(e);
		}finally {
			if(conn!=null) try {conn.close();}catch(Exception e) {}
		}
		
		return sublist;
	}

	public void insertsub(SubReviewDTO dto) {
		// TODO Auto-generated method stub
		DBConnection dbconn=DBConnection.getdbInstance();
		Connection conn=null;
		
		try {
			conn=dbconn.getConnection();
			ReviewDAO dao=new ReviewDAO();
			dao.insertsub(conn, dto);
			
		}catch(SQLException | NamingException e)
		{
			System.out.println(e);
		}finally {
			if(conn!=null) try {conn.close();}catch(Exception e) {}
		}
	}

	public void subDelete(int subno, int rev_no) {
		DBConnection dbconn=DBConnection.getdbInstance();
		Connection conn=null;
		
		try {
			conn=dbconn.getConnection();
			ReviewDAO dao=new ReviewDAO();
			dao.deletesub(conn, subno, rev_no);
			
		}catch(SQLException | NamingException e)
		{
			System.out.println(e);
		}finally {
			if(conn!=null) try {conn.close();}catch(Exception e) {}
		}
		
	}



	public UserDTO usernorsv(String id) {
		// TODO Auto-generated method stub
		DBConnection dbconn=DBConnection.getdbInstance();
		Connection conn=null;
		UserDTO userdto = new UserDTO();
		try {
			conn=dbconn.getConnection();
			ReviewDAO dao=new ReviewDAO();
			userdto= dao.usernorsv(conn, id);
			
		}catch(SQLException | NamingException e)
		{
			System.out.println(e);
		}finally {
			if(conn!=null) try {conn.close();}catch(Exception e) {}
		}
		return userdto;
		
		
	}
	
	

	
	
	
	

}
