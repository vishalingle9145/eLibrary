package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static Connection getDBConnect() {
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/elibrary", "root", "Admin");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}
}
