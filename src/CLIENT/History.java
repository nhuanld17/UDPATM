package CLIENT;

import java.sql.Timestamp;

public class History {
	int idSender;
	int idReceiver;
	double soTien;
	String method;
	Timestamp time;
	
	public History() {
		// TODO Auto-generated constructor stub
	}

	public History(int idSender, int idReceiver, double soTien, String method, Timestamp time) {
		this.idSender = idSender;
		this.idReceiver = idReceiver;
		this.soTien = soTien;
		this.method = method;
		this.time = time;
	}

	public int getIdSender() {
		return idSender;
	}

	public void setIdSender(int idSender) {
		this.idSender = idSender;
	}

	public int getIdReceiver() {
		return idReceiver;
	}

	public void setIdReceiver(int idReceiver) {
		this.idReceiver = idReceiver;
	}

	public double getSoTien() {
		return soTien;
	}

	public void setSoTien(double soTien) {
		this.soTien = soTien;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}
	
	public Object[] toObject() {
		return new Object[] {time,idSender+"" ,method ,idReceiver+"",soTien+""};
	}
	
}
