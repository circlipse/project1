package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import comm.DBConnection;
import dao.CartDAO;
import dao.ReserveDAO;
import dto.ReserveDTO;

public class ReserveService {
	private static ReserveService rsService=new ReserveService();
	public static ReserveService getInstance()
	{
		return rsService;
	}
	private ReserveService() {}
	
	public int insertRsv(ReserveDTO dto) {
         DBConnection dbconn=DBConnection.getdbInstance();
         Connection conn=null;
         int rsv_no = 0;
         try {
            conn=dbconn.getConnection();
            conn.setAutoCommit(false);
            
            ReserveDAO dao=ReserveDAO.getInstance();
            rsv_no = dao.addRsv(conn, dto);            
            //item table의 bag_no를 먼저 입력해야함(참조 무결성에 따라 부모키에 해당하는 값만 넣을 수 있음)
            CartDAO cdao = CartDAO.getInstance();
            if(dto.getBag_val_1() != 0 && dto.getBag_val_2() == 0) {
            	cdao.addRsv(conn, 1, rsv_no, dto.getBag_val_1());
            } else if(dto.getBag_val_1() == 0 && dto.getBag_val_2() != 0) {
            	cdao.addRsv(conn, 2, rsv_no, dto.getBag_val_2());
            } else if(dto.getBag_val_1() != 0 && dto.getBag_val_2() != 0) {
            	cdao.addRsv(conn, 1, rsv_no, dto.getBag_val_1());
            	cdao.addRsv(conn, 2, rsv_no, dto.getBag_val_2());
            }
            
            conn.commit();
         }catch(NamingException | SQLException e) {
            try {conn.rollback();} catch(SQLException e2) {}
         }finally {
            if(conn!=null) try {conn.close();} catch(SQLException e) {}
         }
         return rsv_no;
      }
	
	public ReserveDTO detailRsv(int rsv_no) {
		DBConnection dbconn=DBConnection.getdbInstance();
        Connection conn=null;
        
        ReserveDTO dto = new ReserveDTO();
        try {
        	conn=dbconn.getConnection();
            conn.setAutoCommit(false);
            
            ReserveDAO dao=ReserveDAO.getInstance();
            dto = dao.detailRsv(conn, rsv_no);
            
        } catch(NamingException | SQLException e) {
        	try {conn.rollback();} catch(SQLException e2) {}
        }finally {
           if(conn!=null) try {conn.close();} catch(SQLException e) {}
        }
		return dto;
	}

}
