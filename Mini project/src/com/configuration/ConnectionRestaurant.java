package com.configuration;

import java.sql.Connection;
import java.sql.*;

import java.sql.SQLException;

public class ConnectionRestaurant {
	public static Connection getConnection() 
	{
		Connection con=null;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rsystem","root","root@123");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	

}




