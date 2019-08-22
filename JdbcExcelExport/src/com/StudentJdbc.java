package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentJdbc {
	public static List<Student> getAllStudents(){
		String sql="select * from StudentExcel";
		List<Student> list=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","systema","root");
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			list=new ArrayList<>();
			while(rs.next()) {
				list.add(new Student(rs.getInt(1),
						rs.getString(2), 
						rs.getString(3), 
						rs.getDouble(4))
						);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}

}
