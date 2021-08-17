package comm;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnection {
	
	private static DBConnection dbinstance = new DBConnection();
	public static DBConnection getdbInstance() {
		return dbinstance;
	}
	private DBConnection() {}
	
	public Connection getConnection() throws SQLException,NamingException {
		Connection conn = null;
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/kosta");

		conn = ds.getConnection();

		return conn;
	}
	
}
