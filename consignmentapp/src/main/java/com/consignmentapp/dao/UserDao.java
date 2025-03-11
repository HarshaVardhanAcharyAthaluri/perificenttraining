package com.consignmentapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	
	private JdbcConfig dbconfig = new JdbcConfig();
	
	public boolean getuserByName(String username,String password) {
		boolean isUserValid = false;
		try {
			Connection con  = dbconfig.initConnection();
			PreparedStatement stmt = con.prepareStatement("select  * from userdetails where uname=? and password=?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery(); 
			rs.next();
			if(rs.getString("uname").equalsIgnoreCase(username) && rs.getString("password").equalsIgnoreCase(password)) {
				isUserValid = true;
			}
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		return isUserValid;
	}
	

	public List<UserDto> getUsers(){
		List<UserDto> userList = new ArrayList();
		
		try {
			Connection con  = dbconfig.initConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from userdetails");
			while (rs.next()) {
				UserDto user = new UserDto();
				user.setUid(rs.getInt("uid"));
				user.setUsername(rs.getString("uname"));
				user.setAddress(rs.getString("address"));
				user.setRole(rs.getString("role"));
				user.setPassword(rs.getString("password"));
				userList.add(user);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return userList;
		
	}
	
	public List<UserDto> deleteUser(String username){
		
		try {
			Connection con  = dbconfig.initConnection();
			PreparedStatement stmt = con.prepareStatement("delete from userdetails where uname=? ");
			stmt.setString(1, username);
			stmt.execute();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return getUsers();
		
	}
	
	public String saveUser(String username,String address,String role,String password) {
		
		String respmsg = "";
		try {
			Connection con = dbconfig.initConnection();
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
