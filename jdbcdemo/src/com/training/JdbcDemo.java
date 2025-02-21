package com.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcDemo {

	public static void main(String[] args) {
		
		try {
			//Registering the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Registered");
			
			//Establishing the connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tech_learning","root","admin");
			System.out.println("Conneciton established");
			
			//create statment
			 PreparedStatement stmt= con.prepareStatement("insert into users values(?,?,?,?);");
			 System.out.println("Stament created");
			 Scanner sc = new Scanner(System.in);
			 
			 System.out.println("ENTER ID");
			 stmt.setInt(1, sc.nextInt());
			 System.out.println("ENTER NAME");
			 stmt.setString(2,sc.next());
			 System.out.println("ENTER EMAIL");
			 stmt.setString(3, sc.next());
			 System.out.println("ENTER ADDRESS");
			 stmt.setString(4,sc.next());
			 //Execute the statment
			 stmt.execute();
			 System.out.println("Query executed");
			 
			 //close the connection
			 con.close();
			 System.out.println("Connection closed");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
