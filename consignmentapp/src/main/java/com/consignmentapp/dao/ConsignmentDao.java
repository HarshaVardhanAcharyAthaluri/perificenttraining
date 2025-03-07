package com.consignmentapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsignmentDao {

	
	private JdbcConfig dbconfig = new JdbcConfig();
	public String saveConsignment(String cname,Integer quantity,String status) {
		
		String respmsg = "";
		try {
			Connection con = dbconfig.initConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select count(cid) from consignments");
			rs.next();
			Integer cureentId = rs.getInt("count(cid)");
			PreparedStatement pstmt = con.prepareStatement("insert into consignments values(?,?,?,?)");
			Integer cid = cureentId+1;
			pstmt.setInt(1, cid);
			pstmt.setString(2, cname);
			pstmt.setInt(3, quantity);
			pstmt.setString(4, status);
			pstmt.execute();
			respmsg = "Consignmrnt Saved";
		}catch (Exception e) {
			e.printStackTrace();
			respmsg = "Exception Occured";
		}
		return respmsg;
	}
	
	public List<ConsignmentDto> getConsignemnts(){
		List<ConsignmentDto> consignmentList = new ArrayList();
		
		try {
			Connection con  = dbconfig.initConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from consignments");
			while (rs.next()) {
				ConsignmentDto consignment = new ConsignmentDto();
				consignment.setCid(rs.getInt("cid"));
				consignment.setCname(rs.getString("cname"));
				consignment.setQuantity(rs.getInt("quantity"));
				consignment.setStatus(rs.getString("status"));
				consignmentList.add(consignment);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return consignmentList;
	}
	
	public List<ConsignmentDto> deleteConsignment(Integer cid ) {

		try {
			Connection con = dbconfig.initConnection();
			PreparedStatement stmt = con.prepareStatement("delete from consignments where cid=? ");
			stmt.setInt(1, cid);
			stmt.execute();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return getConsignemnts();

	}
}
