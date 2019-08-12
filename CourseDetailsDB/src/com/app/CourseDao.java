package com.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CourseDao {
	public static int save(String cname,int duration,String fname,String ctype,double cfee,String note) {
		
		int count=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","systema","root");
			PreparedStatement ps=con.prepareStatement("insert into coursetab values(?,?,?,?,?,?)");
			ps.setString(1, cname);
			ps.setInt(2, duration);
			ps.setString(3, fname);
			ps.setString(4, ctype);
			ps.setDouble(5, cfee);
			ps.setString(6, note);
			count=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return count;
	}

}
