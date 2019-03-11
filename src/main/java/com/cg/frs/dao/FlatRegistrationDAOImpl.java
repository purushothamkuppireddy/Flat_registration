package com.cg.frs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.frs.dto.FlatRegistrationDTO;



public class FlatRegistrationDAOImpl implements IFlatRegistrationDAO {

	public FlatRegistrationDTO registerFlat(FlatRegistrationDTO dto) {
		int owner=dto.getOwnerId();
		int i=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kpr", "root", "root");
			PreparedStatement ps = con.prepareStatement("insert into flat_registration(owner_id,flat_type,flat_area,rent_amount,deposit_amount) values(?,?,?,?,?) ");
			ps.setInt(1,dto.getOwnerId());
			ps.setInt(2,dto.getFlatType());
			ps.setInt(3,dto.getFlatArea());
			ps.setInt(4,dto.getRentAmount());
			ps.setInt(5,dto.getDepositAmount());
			i=ps.executeUpdate();
			
			PreparedStatement ps2 = con.prepareStatement(" select * from  flat_registration where owner_id=?");
			ps2.setInt(1,owner);
			ResultSet rs=ps2.executeQuery();
			while(rs.next()) {
			dto.setFlatRegNo(rs.getInt(1));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		
		
		if(i==1)
		return dto;
		else
		return null;
	}

	public ArrayList<Integer> getAllOwnersIds() {
		ArrayList<Integer> al=new ArrayList<Integer>();
 		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kpr", "root", "root");
			PreparedStatement ps = con.prepareStatement("select owner_id from flat_owner");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				al.add(rs.getInt(1));
				
			}
 		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return al;
	
 		}
}
