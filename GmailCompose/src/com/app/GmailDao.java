package com.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class GmailDao {

	public static int save(String emailId, String subject, String msg) {
		int count=0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:1521:ORCL","systema","root");
			PreparedStatement ps=con.prepareStatement("insert into gmailCompose values(?,?,?)");
			ps.setString(1, emailId);
			ps.setString(2, subject);
			ps.setString(3, msg);
			
			count=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
				return count;
	}

}
