package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcTemplate {
	
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##FARM", "FARM");
			conn.setAutoCommit(false); // 오토커밋 꺼주기!!

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void commit(Connection conn) {

		try {

			if(!conn.isClosed() && conn != null ){
			conn.commit();
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void rollback(Connection conn) {

		try {

			if(!conn.isClosed() && conn != null ){
			conn.rollback();
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Statement smt) {
		try {
			if(smt != null && !smt.isClosed()) {
				smt.close();
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rset) {
		try {
			if(rset != null && !rset.isClosed()) {
				rset.close();
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
