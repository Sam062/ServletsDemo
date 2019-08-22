package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpJDBC {
	public static List<Employee> getAllEmp(){
		String sql="select * from emptab";
		List<Employee> lsEmp=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","systema","root");
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			lsEmp=new ArrayList<Employee>();
			
			while(rs.next()) {
				lsEmp.add(new Employee(
						rs.getInt(1),
						rs.getString(2),
						rs.getDouble(3),
						rs.getString(4))
						);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lsEmp;
		
	}

}
