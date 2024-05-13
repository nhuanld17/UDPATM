package DAO;

import java.sql.ResultSet;

public class LoginDao {

	public boolean isValidAccount(int iD, String password) {
		try {
			String query = "SELECT password FROM account WHERE ID = '"+iD+"'";
			ResultSet resultSet = new DBcon().queryDB(query);
			String pass = null;
			if (resultSet.next()) {
				pass = resultSet.getString("password");
			}else {
				return false;
			}
			
			if (pass.isEmpty()) {
				return false;
			}
			
			if (password.equals(pass)) {
				return true;
			}
			return false;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return false;
	}
	
}
