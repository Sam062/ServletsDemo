package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductJDBC {

	public static int operations(int pid, String pcode, double pcost, String pdesc, String grade) throws SQLException {
		int count=0;
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","systema","root");
			PreparedStatement ps=con.prepareStatement("insert into product values(?,?,?,?,?)");
			ps.setInt(1, pid);
			ps.setString(2, pcode);
			ps.setDouble(3, pcost);
			ps.setString(4, pdesc);
			ps.setString(5, grade);
			
			count=ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
}
