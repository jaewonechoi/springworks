package org.khit.myapp.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	
	static String className = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/springdb?serverTime=Asia/Seoul";
	static String username = "springuser";
	static String password = "pwspring";
	
	Connection conn = null; 
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//DB 연결 메서드
	public static Connection getConnection() {
		try {
			Class.forName(className);
			return DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//DB 종료 메서드(추가, 수정, 삭제)
	public static void close(Connection conn, PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//DB 종료 메서드(추가, 수정, 삭제, 검색)
	public static void close(Connection conn, PreparedStatement pstmt,
			ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
