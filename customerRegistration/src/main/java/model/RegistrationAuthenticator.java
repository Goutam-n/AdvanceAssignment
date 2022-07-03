package model;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.JdbcConnector;
import dto.CustomerDto;


public class RegistrationAuthenticator
{
	public boolean isRegister(CustomerDto user)
	{
		String firstname = user.getFirstname();
		String lastname  = user.getLastname();
		String address   = user.getAddress();
		String city      = user.getCity();
		String zipcode   = user.getZipcode();
		String state     = user.getState();
		String country   = user.getCountry();
		String phone     = user.getPhone();
		String username  = user.getUsername();
		String password  = user.getPassword();
			
		
		try
		{
			Connection con = JdbcConnector.getConnection();
			PreparedStatement st1 = con.prepareStatement("insert into party values(?,?,?,?,?,?,?,?,?)");
			
			st1.setString(1,"104");
			st1.setString(2,firstname);
			st1.setString(3,lastname);
			st1.setString(4,address);
			st1.setString(5,city);
			st1.setString(6,zipcode);
			st1.setString(7,state);
			st1.setString(8,country);
			st1.setString(9,phone);
			
			PreparedStatement st2 = con.prepareStatement("insert into userLogin values(?,?,?)");
			
			st2.setString(1,username);
			st2.setString(2,password);			
			st2.setString(3,"104");
			
			st1.executeUpdate();
			st2.executeUpdate();
			
			st1.close();
			st2.close();
			return true;
			
		}
		catch (SQLException e)
		{
			
			System.out.println(e);
		}
		return false;
		
	}
}