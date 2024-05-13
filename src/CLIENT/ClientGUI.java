package CLIENT;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import DAO.AccountDao;

public class ClientGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PrintWriter writer;
	private JTextField textField_TienNap;
	private JButton btnNap;
	private int id;
	private BufferedReader reader;
	private JTextField textField_TienRut;
	private double currentBalance;
	private JTextField textField_IDReceiver;
	private JTextField textField_tienChuyernKhoan;
	private JLabel lblNewLabel;
	private JLabel label_ID;
	private JLabel label_Balance;
	private JTable table;
	private InetAddress address;
	private DatagramSocket datagramSocket;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public ClientGUI(int ID) {
		try {
			address = InetAddress.getLocalHost();
			datagramSocket = new DatagramSocket();
		} catch (UnknownHostException | SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		id = ID;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(17, 24, 39));
		panel.setBounds(0, 0, 143, 326);
		contentPane.add(panel);
		panel.setLayout(null);
		
		currentBalance = new AccountDao().getCurrentBalance(id);

		
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(143, -23, 518, 349);
		contentPane.add(tabbedPane);
		
		
		
		JButton btnTab1 = new JButton("Rút tiền");
		btnTab1.setFocusable(false);
		btnTab1.setBorderPainted(false);
		btnTab1.setBackground(new Color(17, 24, 39));
		btnTab1.setForeground(new Color(244, 245, 249));
		btnTab1.setHorizontalAlignment(SwingConstants.LEFT);
		btnTab1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnTab1.setBounds(0, 126, 143, 28);
		panel.add(btnTab1);
		
		JButton btnTab2 = new JButton("Chuyển tiền");
		btnTab2.setFocusable(false);
		btnTab2.setBorderPainted(false);
		btnTab2.setBackground(new Color(17, 24, 39));
		btnTab2.setForeground(new Color(244, 245, 249));
		btnTab2.setHorizontalAlignment(SwingConstants.LEFT);
		btnTab2.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnTab2.setBounds(0, 165, 143, 28);
		panel.add(btnTab2);
		
		JButton btnTab3 = new JButton("Nạp tiền");
		btnTab3.setBorderPainted(false);
		btnTab3.setFocusable(false);
		btnTab3.setBackground(new Color(17, 24, 39));
		btnTab3.setForeground(new Color(244, 245, 249));
		btnTab3.setHorizontalAlignment(SwingConstants.LEFT);
		btnTab3.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnTab3.setBounds(0, 204, 143, 28);
		panel.add(btnTab3);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1.setForeground(new Color(244, 245, 249));
		lblNewLabel_1.setBounds(0, 11, 56, 14);
		panel.add(lblNewLabel_1);
		
		label_ID = new JLabel("New label");
		label_ID.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label_ID.setForeground(new Color(244, 245, 249));
		label_ID.setText(id+"");
		label_ID.setBounds(0, 26, 143, 23);
		panel.add(label_ID);
		
		JLabel lblB = new JLabel("Balance");
		lblB.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblB.setForeground(new Color(244, 245, 249));
		lblB.setBounds(0, 47, 86, 14);
		panel.add(lblB);
		
		label_Balance = new JLabel("New label");
		label_Balance.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label_Balance.setForeground(new Color(244, 245, 249));
		label_Balance.setText(currentBalance+"");
		label_Balance.setBounds(0, 62, 143, 23);
		panel.add(label_Balance);
		
		JButton btnTab4 = new JButton("Lịch sử");
		btnTab4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		btnTab4.setHorizontalAlignment(SwingConstants.LEFT);
		btnTab4.setForeground(new Color(244, 245, 249));
		btnTab4.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnTab4.setFocusable(false);
		btnTab4.setBorderPainted(false);
		btnTab4.setBackground(new Color(17, 24, 39));
		btnTab4.setBounds(0, 243, 143, 28);
		panel.add(btnTab4);
		

		
		JPanel tab_RutTien = new JPanel();
		tab_RutTien.setBackground(new Color(244, 245, 249));
		tabbedPane.addTab("New tab", null, tab_RutTien, null);
		tab_RutTien.setLayout(null);
		


		JLabel lblNewLabel_2_1 = new JLabel("Số tiền rút:");
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_2_1.setForeground(new Color(17, 24, 39));
		lblNewLabel_2_1.setBounds(10, 101, 83, 27);
		tab_RutTien.add(lblNewLabel_2_1);
		
		textField_TienRut = new JTextField();
		textField_TienRut.setForeground(SystemColor.desktop);
		textField_TienRut.setBounds(103, 100, 220, 33);
		tab_RutTien.add(textField_TienRut);
		textField_TienRut.setColumns(10);
		
		JButton btn_RUT = new JButton("Rút");
		btn_RUT.setBackground(new Color(244, 245, 249));
		btn_RUT.setBorder(new LineBorder(new Color(17,24,39),2));
		btn_RUT.setFocusable(false);
		btn_RUT.setForeground(new Color(17, 24, 39));
		btn_RUT.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btn_RUT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String taskName = btn_RUT.getText();
				double tienRut = Double.valueOf(textField_TienRut.getText());
				
				if (tienRut > currentBalance || tienRut < 0) {
					JOptionPane.showMessageDialog(null, "Số dư hiện tại không đủ");
					return;
				}
				String message = "Rút-"+id+"-"+tienRut;
				byte[] byteMessage = message.getBytes();
			
				DatagramPacket taskPacket = new DatagramPacket(byteMessage, byteMessage.length, address, 9090);
				try {
					datagramSocket.send(taskPacket);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				currentBalance = new AccountDao().getCurrentBalance(id);
				label_Balance.setText(currentBalance+"");
				updateTableHistory();
			}
		});
		btn_RUT.setBounds(102, 147, 89, 27);
		tab_RutTien.add(btn_RUT);
		
		JPanel tab_ChuyenTien = new JPanel();
		tabbedPane.addTab("New tab", null, tab_ChuyenTien, null);
		tab_ChuyenTien.setLayout(null);
		
		textField_IDReceiver = new JTextField();
		textField_IDReceiver.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_IDReceiver.setForeground(SystemColor.desktop);
		textField_IDReceiver.setBounds(130, 117, 190, 27);
		tab_ChuyenTien.add(textField_IDReceiver);
		textField_IDReceiver.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Số tiền");
		lblNewLabel_3_1.setForeground(new Color(17, 24, 39));
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(10, 153, 85, 27);
		tab_ChuyenTien.add(lblNewLabel_3_1);
		
		textField_tienChuyernKhoan = new JTextField();
		textField_tienChuyernKhoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_tienChuyernKhoan.setForeground(SystemColor.desktop);
		textField_tienChuyernKhoan.setColumns(10);
		textField_tienChuyernKhoan.setBounds(130, 155, 190, 27);
		tab_ChuyenTien.add(textField_tienChuyernKhoan);
		
		JLabel lblNewLabel_3 = new JLabel("ID người nhận");
		lblNewLabel_3.setForeground(new Color(17, 24, 39));
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 115, 110, 27);
		tab_ChuyenTien.add(lblNewLabel_3);
		
		JButton btn_CHUYEN = new JButton("Chuyển");
		btn_CHUYEN.setForeground(new Color(17, 24, 39));
		btn_CHUYEN.setBackground(new Color(244, 245, 249));
		btn_CHUYEN.setBorder(new LineBorder(new Color(17,24,39),2));
		btn_CHUYEN.setFocusable(false);
		btn_CHUYEN.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btn_CHUYEN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String taskName = btn_CHUYEN.getText();
				int iDReceiver = Integer.valueOf(textField_IDReceiver.getText());
				double money = Double.valueOf(textField_tienChuyernKhoan.getText());
				currentBalance = new AccountDao().getCurrentBalance(ID);
				if (iDReceiver == id) {
					JOptionPane.showMessageDialog(null, "Bạn không thể chuyển tiền cho chính bạn");
					return;
				}
				
				if (money > currentBalance || money < 0 ) {
					JOptionPane.showMessageDialog(null, "Số dư hiện tại không đủ");
					return;
				}

				String message = "Chuyển-"+ClientGUI.this.id+"-"+money+"-"+iDReceiver;
				byte[] byteMessage = message.getBytes();
			
				DatagramPacket taskPacket = new DatagramPacket(byteMessage, byteMessage.length, address, 9090);
				try {
					datagramSocket.send(taskPacket);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				currentBalance = new AccountDao().getCurrentBalance(ID);
				label_Balance.setText(currentBalance+"");
				updateTableHistory();
			}
		});
		btn_CHUYEN.setBounds(130, 193, 106, 27);
		tab_ChuyenTien.add(btn_CHUYEN);
		
		JPanel tab_NapTien = new JPanel();
		tabbedPane.addTab("New tab", null, tab_NapTien, null);
		tab_NapTien.setLayout(null);
		
		lblNewLabel = new JLabel("Nhập số tiền nạp");
		lblNewLabel.setForeground(new Color(17, 24, 39));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 104, 129, 30);
		tab_NapTien.add(lblNewLabel);
		
		textField_TienNap = new JTextField();
		textField_TienNap.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textField_TienNap.setBounds(130, 104, 259, 30);
		tab_NapTien.add(textField_TienNap);
		textField_TienNap.setColumns(10);
		
		btnNap = new JButton("Nạp");
		btnNap.setForeground(new Color(17, 24, 39));
		btnNap.setBackground(new Color(244, 245, 249));
		btnNap.setBorder(new LineBorder(new Color(17,24,39),2));
		btnNap.setFocusable(false);
		btnNap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String taskName = btnNap.getText();
				double money = Double.valueOf(textField_TienNap.getText());
				
				if (money < 0) {
					JOptionPane.showMessageDialog(null, "Số tiền nạp không hợp lệ");
					return;
				}
			
				String message = "Nạp-"+id+"-"+money;
				byte[] byteMessage = message.getBytes();
			
				DatagramPacket taskPacket = new DatagramPacket(byteMessage, byteMessage.length, address, 9090);
				try {
					datagramSocket.send(taskPacket);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				currentBalance = new AccountDao().getCurrentBalance(ID);
				label_Balance.setText(currentBalance+"");
				updateTableHistory();
			}
		});
		btnNap.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNap.setBounds(130, 162, 89, 30);
		tab_NapTien.add(btnNap);
		

		
		JPanel tab_History = new JPanel();
		tabbedPane.addTab("New tab", null, tab_History, null);
		tab_History.setLayout(null);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setRowHeight(25);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Time", "ID Sender" , "Method", "ID Receiver", "Amount"
			}
		));
		table.setBounds(10, 59, 421, 170);
		updateTableHistory();
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 59, 493, 251);
		tab_History.add(scrollPane);
		
		
		// Xử lí button chuyển tab
		btnTab1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		
		btnTab2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		
		btnTab3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		
//		Thread thread = new Thread(new Runnable() {
//		    public void run() {
//		        while (true) {
//		            try {
//		                double newBalance = new AccountDao().getCurrentBalance(id);
//		                SwingUtilities.invokeLater(new Runnable() {
//		                    public void run() {
//		                        label_currentBalance.setText(newBalance+"");
//		                        label_currentBalance_1.setText(newBalance+"");
//		                    }
//		                });
//		                Thread.sleep(1000); // Giả sử cập nhật mỗi giây
//		            } catch (InterruptedException e) {
//		                e.printStackTrace();
//		            }
//		        }
//		    }
//		});
//		thread.start();
	}


	private void updateTableHistory() {
		clearTable();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		ArrayList<History> histories = new AccountDao().getListHistory(id);
		
		for (History history : histories) {
			model.addRow(history.toObject());
		}
	}


	private void clearTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int rowCount = model.getRowCount();
		
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}
	}
}
