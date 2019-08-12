package com.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class EmployeeDao {
	public static int save(int eid,String name,String gen,String mob,String addr,String dept) throws SQLException {
		int count=0;
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","systema","root");
			PreparedStatement ps=con.prepareStatement("insert into emptable values(?,?,?,?,?,?)");
			ps.setInt(1, eid);
			ps.setString(2, name);
			ps.setString(3, gen);
			ps.setString(4, mob);
			ps.setString(5, addr);
			ps.setString(6, dept);
			count=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			con.close();
		}
		return count;
		
	}

}
