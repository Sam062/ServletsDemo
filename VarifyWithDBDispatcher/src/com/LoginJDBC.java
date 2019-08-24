package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginJDBC {
	public static boolean isExist(String un,String pwd) {
		boolean flag=false;
		String sql="select * from userstab where username=? and password=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","systema","root");
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, un);
			pstmt.setString(2, pwd);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				//data exist
				flag=true;
			}else {
				//data not exist
				flag=false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}