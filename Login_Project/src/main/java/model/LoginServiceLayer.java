package model;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginServiceLayer {
	
	public boolean verify(String username , String password) {
		Connection dbCon = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean status = false;
		
		String query = "select * from login_info";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql123");
			
			pstmt = dbCon.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				 String dbUsername = rs.getString("username");
				 String dbPassword = rs.getString("password");
				
				 if(dbUsername.equals(username) && dbPassword.equals(password)) {
					status = true;
					
				}
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
}
