package com.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class StudentDao {
	public static int save(int id,String sname,String sgen,String addr) {
		int count=0;
		String sql="insert into stdTAB values(?,?,?,?)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","systema","root");
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, sname);
			ps.setString(3, sgen);
			ps.setString(4, addr);
			count=ps.executeUpdate();
			if(count!=0) {
				return count;
			}
		} catch (Exception e) {e.printStackTrace();}
		return count;
	}

}
