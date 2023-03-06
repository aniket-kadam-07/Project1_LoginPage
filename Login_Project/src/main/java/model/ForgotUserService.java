package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ForgotUserService {
	
	static Connection dbCon = null;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql123");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean verifyMail(String mail) {
		Statement stmt = null;
		ResultSet rs = null;
		boolean status = false;
		
		String query = "select mail from login_info";
		
		try {
			stmt = dbCon.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				String dbMail = rs.getString(1);
				if(dbMail.equals(mail)) {
					status = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	public int forgotUser(String username, String mail) {
		
		PreparedStatement pstmt = null;
		int count =0;
		
		ForgotPasswordService f1 = new ForgotPasswordService();
		boolean status = f1.verifyMail(mail);
		if(status==true) {
			
			String query = "update login_info set username = ? where mail= ?";
			
			try {
				pstmt = dbCon.prepareStatement(query);
				pstmt.setString(1, username);
				pstmt.setString(2, mail);
				
				count = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}
}
