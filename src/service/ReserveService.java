package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import comm.DBConnection;
import dao.ReserveDAO;
import dto.ReserveDTO;

public class ReserveService {
	private static ReserveService rsService=new ReserveService();
	public static ReserveService getInstance()
	{
		return rsService;
	}
	private ReserveService() {}
	 public void insertRsv(ReserveDTO dto) {
         // TODO Auto-generated method stub
         DBConnection dbconn=DBConnection.getdbInstance();
         Connection conn=null;
         try {
            conn=dbconn.getConnection();
            conn.setAutoCommit(false);
            
            ReserveDAO dao=ReserveDAO.getInstance();
            dao.addRsv(conn, dto);
            
            
         }catch(NamingException | SQLException e) {
            try {conn.rollback();} catch(SQLException e2) {}
         }finally {
            if(conn!=null) try {conn.close();} catch(SQLException e) {}
         }
      }

}
