package com.rideCompany.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {

	private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/ride_db";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";

	private static DBConnection instance;
	private Connection connection;

	private DBConnection()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			System.out.println("Database connection established successfully!");

		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("Failed to establish database connection!");
		}
	}
	public static DBConnection getInstance() throws SQLException {
		if (instance == null || instance.getConnection().isClosed()) {
			instance = new DBConnection();
		}
		return instance;
	}

	public Connection getConnection() {

		return connection;
	}
}