package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbOperation {

	public static int insert(int userid, String uname, String pwd) {
		int count=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","systema","root");
			PreparedStatement ps=con.prepareStatement("insert into usertab values(?,?,?)");
			ps.setInt(1, userid);
			ps.setString(2, uname);
			ps.setString(3, pwd);
			count=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public static boolean isExist(String uname,String pwd) {
		boolean flag=false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","systema","root");
			PreparedStatement ps=con.prepareStatement("select * from usertab where uname=? AND pwd=?");
			ps.setString(1, uname);
			ps.setString(2, pwd);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
