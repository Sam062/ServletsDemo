package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbOperation {

	public static int insert(int uid, String uname, String pwd) {
		int count=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","systema","root");
			PreparedStatement ps=con.prepareStatement("insert into usertab values(?,?,?)");
			ps.setInt(1, uid);
			ps.setString(2, uname);
			ps.setString(3, pwd);
			count=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public static boolean isExist(int uid, String uname) {
		boolean flag=false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","systema","root");
			PreparedStatement ps=con.prepareStatement("select * from usertab where uid=? AND uname=?");
			ps.setInt(1, uid);
			ps.setString(2, uname);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
