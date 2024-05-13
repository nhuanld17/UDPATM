package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import CLIENT.History;

public class AccountDao {

	public double getCurrentBalance(int id) {
	    String query = "SELECT money FROM account WHERE ID = '"+id+"'";
	    try (
	         Statement statement = new DBcon().getCon().createStatement();
	         ResultSet resultSet = statement.executeQuery(query)) {
	        
	        if (resultSet.next()) {
	            return resultSet.getDouble("money");
	        }
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	    return 0.0;
	}


	public void rutTien(int iD, double tienRut) {
		try {
			double currentBalance = getCurrentBalance(iD);
			currentBalance = currentBalance - tienRut;
			
			String query = "UPDATE account SET money = '"+currentBalance+"' WHERE ID = '"+iD+"'";
			new DBcon().updateDB(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void chuyenTien(int idSender, double tienChuyen, int idReceiver) {
		try {
			double SenderBalance = getCurrentBalance(idSender);
			SenderBalance = SenderBalance - tienChuyen;
			String query = "UPDATE account SET money = '"+SenderBalance+"' WHERE ID = '"+idSender+"'";
			new DBcon().updateDB(query);
			
			double ReceiverBalance = getCurrentBalance(idReceiver);
			ReceiverBalance += tienChuyen;
			String query2 = "UPDATE account SET money = '"+ReceiverBalance+"' WHERE ID = '"+idReceiver+"'";
			new DBcon().updateDB(query2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void napTien(int iD, double tienNap) {
		try {
			double currentBalance = getCurrentBalance(iD);
			currentBalance = currentBalance + tienNap;
			String query = "UPDATE account SET money = '"+currentBalance+"' WHERE ID = '"+iD+"'";
			new DBcon().updateDB(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void addAccount(String name, String email, String pass) {
		try {
			String query = "INSERT INTO account(name,gmail,password) VALUES ('"+name+"','"+email+"', '"+pass+"')";
			new DBcon().updateDB(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void saveInHistory(int iD, double tienRUt, String taskName, Timestamp currentTime) {
		try {
			String query = "INSERT INTO atm.history(idSender,idReceiver,sotien,method,time)"
					+ " VALUES('"+iD+"','"+0+"','"+tienRUt+"','"+taskName+"','"+currentTime+"')";
			new DBcon().updateDB(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void chuyenTienHistory(int idSender, int idReceiver, double tienChuyen, String taskName,
			Timestamp currentTime) {
		try {
			String query = "INSERT INTO atm.history(idSender,idReceiver,sotien,method,time)"
					+ " VALUES('"+idSender+"','"+idReceiver+"','"+tienChuyen+"','"+taskName+"','"+currentTime+"')";
			new DBcon().updateDB(query);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}


	public void NapTienToHistory(int iD, double tienNap, String taskName, Timestamp currentTime) {
		try {
			String query = "INSERT INTO atm.history(idSender,idReceiver,sotien,method,time)"
					+ " VALUES('"+iD+"','"+0+"','"+tienNap+"','"+taskName+"','"+currentTime+"')";
			new DBcon().updateDB(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public ArrayList<History> getListHistory(int id) {
		ArrayList<History> histories = new ArrayList<>();
		try {
			String q = "SELECT * FROM atm.history WHERE idSender = '"+id+"'";
			ResultSet resultSet = new DBcon().queryDB(q);
			
			while (resultSet.next()) {
				int idSender = resultSet.getInt("idSender");
				int idReceiver = resultSet.getInt("idReceiver");
				double sotien = resultSet.getDouble("sotien");
				String methos = resultSet.getString("method");
				Timestamp time = resultSet.getTimestamp("time");
				
				History history = new History(idSender, idReceiver, sotien, methos, time);
				histories.add(history);
			}
			return histories;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

}
