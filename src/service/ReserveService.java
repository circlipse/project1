package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            if(dto.getBag_val_1() != 0 || dto.getBag_val_2() != 0) {
            rsv_no = dao.addRsv(conn, dto);            
            }

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
            
            conn.commit();
        } catch(NamingException | SQLException e) {
        	try {conn.rollback();} catch(SQLException e2) {}
        }finally {
           if(conn!=null) try {conn.close();} catch(SQLException e) {}
        }
		return dto;
	}
	public ReserveDTO getBagVal(int rsv_no) {
		DBConnection dbconn=DBConnection.getdbInstance();
        Connection conn=null;
		ReserveDTO dto = new ReserveDTO();       
        try {
        	conn=dbconn.getConnection();
            conn.setAutoCommit(false);
            
            CartDAO dao=CartDAO.getInstance();
            dto.setBag_val_1(dao.getBagVal(conn, rsv_no, 1));
            dto.setBag_val_2(dao.getBagVal(conn, rsv_no, 2));
            
            conn.commit();
        } catch(NamingException | SQLException e) {
        	try {conn.rollback();} catch(SQLException e2) {}
        }finally {
        	if(conn!=null) try {conn.close();} catch(SQLException e) {}
        }
        return dto;
	}
	public void delRsv(int rsv_no) {
		DBConnection dbconn=DBConnection.getdbInstance();
        Connection conn=null;
        try {
        	conn=dbconn.getConnection();
            conn.setAutoCommit(false);
            
            ReserveDAO rdao=ReserveDAO.getInstance();
            rdao.delRsv(conn, rsv_no);
            
            CartDAO cdao=CartDAO.getInstance();
            cdao.delRsv(conn, rsv_no);
            
            conn.commit();
        } catch(NamingException | SQLException e) {
        	try {conn.rollback();} catch(SQLException e2) {}
        }finally {
        	if(conn!=null) try {conn.close();} catch(SQLException e) {}
        }
	}
	public List<ReserveDTO> getRsvList(String id) {
		// TODO Auto-generated method stub
		DBConnection dbconn=DBConnection.getdbInstance();
        Connection conn=null;
        
        List<ReserveDTO> list=new ArrayList<ReserveDTO>();
        try {
        	conn=dbconn.getConnection();
            conn.setAutoCommit(false);
            
            ReserveDAO dao=ReserveDAO.getInstance();
            list = dao.getRsvList(conn, id);
            
            conn.commit();
        } catch(NamingException | SQLException e) {
        	try {conn.rollback();} catch(SQLException e2) {}
        }finally {
           if(conn!=null) try {conn.close();} catch(SQLException e) {}
        }
		return list;

	}
	public void modifyRsv(ReserveDTO dto, ReserveDTO dto2) {
		DBConnection dbconn=DBConnection.getdbInstance();
        Connection conn=null;
        
        try {
        	conn=dbconn.getConnection();
            conn.setAutoCommit(false);
            
            ReserveDAO rdao=ReserveDAO.getInstance();
            rdao.modifyReserve(conn, dto);
            
            CartDAO cdao=CartDAO.getInstance();   
            if(dto2.getBag_val_1() != 0 && dto2.getBag_val_2() != 0 && dto.getBag_val_1() != 0 && dto.getBag_val_2() != 0) {
            	cdao.modifyCart(conn, 1, dto.getRsv_no(), dto.getBag_val_1());
            	cdao.modifyCart(conn, 2, dto.getRsv_no(), dto.getBag_val_2());
            } else if(dto2.getBag_val_1() != 0 && dto2.getBag_val_2() != 0 && dto.getBag_val_1() != 0 && dto.getBag_val_2() == 0) {
            	cdao.modifyCart(conn, 1, dto.getRsv_no(), dto.getBag_val_1());
            	cdao.delRsv(conn, dto.getRsv_no());
            } else if(dto2.getBag_val_1() != 0 && dto2.getBag_val_2() != 0 && dto.getBag_val_1() == 0 && dto.getBag_val_2() != 0) {
            	cdao.delRsv(conn, dto.getRsv_no());
            }
            
            
            
            if(dto.getBag_val_1() != 0 && dto.getBag_val_2() == 0) {
            	cdao.modifyCart(conn, 1, dto.getRsv_no(), dto.getBag_val_1());
            } else if(dto.getBag_val_1() == 0 && dto.getBag_val_2() != 0) {
            	cdao.modifyCart(conn, 2, dto.getRsv_no(), dto.getBag_val_2());
            } else if(dto.getBag_val_1() != 0 && dto.getBag_val_2() != 0) {
            	cdao.modifyCart(conn, 1, dto.getRsv_no(), dto.getBag_val_1());
            	cdao.modifyCart(conn, 2, dto.getRsv_no(), dto.getBag_val_2());
            } 
            
            conn.commit();
        } catch(NamingException | SQLException e) {
        	try {conn.rollback();} catch(SQLException e2) {}
        }finally {
           if(conn!=null) try {conn.close();} catch(SQLException e) {}
        }
	}

}
