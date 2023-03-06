package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateAccService {
	
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
	
	public boolean verify(String username, String mail) {
		Statement stmt = null;
		ResultSet rs = null;
		boolean status = true;
		
		String query = "select username, mail from login_info";
		
		try {
			stmt = dbCon.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				String dbUser = rs.getString(1);
				String dbMail = rs.getString(2);
				
				if(username.equals(dbUser) || mail.equals(dbMail)) {
					status = false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
	public int createAcc(String username,String password, String mail) {
		PreparedStatement pstmt = null;
		
		CreateAccService c1 = new CreateAccService();
		boolean status = c1.verify(username, mail);
		int count = 0;
		if(status==true) {
			
			String query = "insert into login_info (username, password, mail) values (?,?,?)";
			try {
				pstmt = dbCon.prepareStatement(query);
				pstmt.setString(1, username);
				pstmt.setString(2, password);
				pstmt.setString(3, mail);
				
				count = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return count;
	}
}
