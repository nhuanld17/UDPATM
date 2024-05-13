package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBcon {
	private String status;
	private String url = "jdbc:mysql://localhost:3306/atm";
	private String user = "root";
	private String pwd = "nhuan.142857";
	Connection con;
	
	public DBcon() {
	    try {
	        con = DriverManager.getConnection(url,user,pwd);

	    } catch (Exception e) {
	        status = "KO";
	        System.out.println(status); // In ra trạng thái kết nối
	        e.printStackTrace();
	    }
	}

	
	public Connection getCon() {
		return con;
	}
	
	public ResultSet queryDB(String query) throws Exception {
		Statement statement = this.getCon().createStatement();
		return statement.executeQuery(query);
	}
	
	public int updateDB(String query) throws Exception {
		Statement statement = this.getCon().createStatement();
		return statement.executeUpdate(query);
	}

	
	public static void main(String[] args) {
		new DBcon();
	}
}
