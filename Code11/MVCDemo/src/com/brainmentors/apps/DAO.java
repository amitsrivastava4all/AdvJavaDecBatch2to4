package com.brainmentors.apps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DAO {
	
	private Connection createConnection() throws ClassNotFoundException, SQLException{
		ResourceBundle rb = ResourceBundle.getBundle("dbconfig");
		Class.forName(rb.getString("drivername"));
		Connection connection = DriverManager.getConnection(rb.getString("dburl"));
		return connection;
		
	}
	public ArrayList<EmployeeDTO> searchBySalary(double salary) throws SQLException, ClassNotFoundException{
		ArrayList<EmployeeDTO> empList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		final String SQL = "select id, name, salary from Employee where salary>=?";
		try{
			connection = createConnection();
			pstmt = connection.prepareStatement(SQL);
			pstmt.setDouble(1, salary);
			rs = pstmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double sal = rs.getDouble("salary");
				EmployeeDTO emp = new EmployeeDTO(id, name, sal);
				empList.add(emp);
			}
		}
		finally{
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(connection!=null){
				connection.close();
			}
		}
		return empList;
	}
	
	

}






