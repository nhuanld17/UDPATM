package SERVER;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.sql.Timestamp;

import DAO.AccountDao;

public class Server {
	public static void main(String[] args) {
		try {
			DatagramSocket socket = new DatagramSocket(9090);
			while (true) {
				byte[] bufferTask = new byte[1024];
				DatagramPacket packetTask  = new DatagramPacket(bufferTask, bufferTask.length);
				socket.receive(packetTask);
				String message = new String(bufferTask, 0, packetTask.getLength());
				
				if (message.startsWith("Rút")) {
					System.out.println(message);
					String[] component = message.split("-");
					String taskName = component[0];
					int id = Integer.valueOf(component[1]);
					double money = Double.valueOf(component[2]);
					System.out.println(taskName+":"+id+":"+money);
					
					new AccountDao().rutTien(id, money);
					Timestamp currentTime = new Timestamp(System.currentTimeMillis());
					new AccountDao().saveInHistory(id,money, taskName, currentTime);
				}
				
				if (message.startsWith("Chuyển")) {
					System.out.println(message);
					String[] component = message.split("-");
					String taskName = component[0];
					int idSender = Integer.valueOf(component[1]);
					double money = Double.valueOf(component[2]);
					int idRecever = Integer.valueOf(component[3]);
					
					Timestamp currentTime = new Timestamp(System.currentTimeMillis());
					
					new AccountDao().chuyenTien(idSender, money, idRecever);
					new AccountDao().chuyenTienHistory(idSender, idRecever, money,taskName,currentTime);
				}
				
				if (message.startsWith("Nạp")) {
					System.out.println(message);
					String[] component = message.split("-");
					String taskName = component[0];
					int id = Integer.valueOf(component[1]);
					double money = Double.valueOf(component[2]);
					
					Timestamp currentTime = new Timestamp(System.currentTimeMillis());
					new AccountDao().napTien(id, money);
					new AccountDao().NapTienToHistory(id, money, taskName, currentTime);
				}
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
