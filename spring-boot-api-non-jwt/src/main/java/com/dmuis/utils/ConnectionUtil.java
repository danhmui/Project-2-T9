package com.dmuis.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {	
		static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
		static final String USER = "root";
		static final String PASS = "chandoi00";
		public static Connection getConnection() {
			try {
				Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				return conn;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
			
		}
}
