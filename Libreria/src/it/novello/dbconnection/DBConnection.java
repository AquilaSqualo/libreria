package it.novello.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/libreria"; 
	private static final String USERNAME = "AquilaSqualo";
	private static final String PASSWORD = "il-Joker67";
	
	public static Connection startMySQLConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//			System.out.println("Connessione riuscita!");
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
