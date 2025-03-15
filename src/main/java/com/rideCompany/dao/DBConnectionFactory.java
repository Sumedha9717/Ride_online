package com.rideCompany.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionFactory {
	
	 public static Connection getConnection() throws SQLException {
	        return DBConnection.getInstance().getConnection();
	    }

}