package com.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class RetrivedataDemo {

	public static void main(String[] args) {
		//Registering the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Establishing the connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tech_learning","root","admin");
			
			//create statment
			 Statement stmt= con.createStatement();
			 System.out.println("Stament created");
			  ResultSet rs = stmt.executeQuery("select * from users");
			  while (rs.next()) {
				 Integer uid = rs.getInt("uid");
				 String usernam = rs.getString("username");
				 String eamil = rs.getString("email");
				 String addrss = rs.getString("address");
				 System.out.println("uid:"+ uid + " name: "+ usernam+ " email : "+ eamil + " addr: "+ addrss);
			  }			  
			 con.close();
			  
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
