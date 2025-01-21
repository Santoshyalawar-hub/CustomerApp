package com.tap.dbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtils {
	
	private static final String url="jdbc:mysql://localhost:3306/student";
	private static final String username="root";
	private static final String password="root";
	private static Connection con;
	
	public static final Connection getConnection() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public static void Disconnection(Connection con,PreparedStatement pstmt) {
		try {
			pstmt.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e2) {
			
			e2.printStackTrace();
		}
		
	}
}

