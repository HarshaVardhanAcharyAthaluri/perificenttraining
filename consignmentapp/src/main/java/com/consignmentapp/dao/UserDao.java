package com.consignmentapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {

	public String saveUser(String username,String address,String role,String password) {
		
		String respmsg = "";
		try {
			JdbcConfig config = new JdbcConfig();
			Connection con = config.initConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select count(uid) from userdetails");
			rs.next();
			Integer cureentId = rs.getInt("count(uid)");
			PreparedStatement pstmt = con.prepareStatement("insert into userdetails values(?,?,?,?,?)");
			Integer uid = cureentId+1;
			pstmt.setInt(1, uid);
			pstmt.setString(2, username);
			pstmt.setString(3, address);
			pstmt.setString(4, role);
			pstmt.setString(5, password);
			pstmt.execute();
			respmsg = "UserSaved";
		}catch (Exception e) {
			e.printStackTrace();
			respmsg = "Exception Occured";
		}
		
		
		return respmsg;
	}
	
	
}
