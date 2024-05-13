package CLIENT;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import DAO.AccountDao;
import DAO.LoginDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldID;
	private JPasswordField textfield_passowrd;
	private JTextField textFieldNam;
	private JTextField textField_mail;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, -22, 435, 370);
		contentPane.add(tabbedPane);
		
		JPanel panel_login = new JPanel();
		panel_login.setBackground(new Color(244, 245, 249));
		tabbedPane.addTab("New tab", null, panel_login, null);
		panel_login.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel.setBackground(SystemColor.desktop);
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 11, 430, 51);
		panel_login.add(lblNewLabel);
		
		textFieldID = new JTextField();
		textFieldID.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldID.setForeground(SystemColor.desktop);
		textFieldID.setBounds(79, 104, 272, 37);
		panel_login.add(textFieldID);
		textFieldID.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblId.setForeground(SystemColor.desktop);
		lblId.setBounds(79, 79, 89, 22);
		panel_login.add(lblId);
		
		textfield_passowrd = new JPasswordField();
		textfield_passowrd.setForeground(SystemColor.desktop);
		textfield_passowrd.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textfield_passowrd.setBounds(79, 167, 272, 37);
		panel_login.add(textfield_passowrd);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1_1.setForeground(SystemColor.desktop);
		lblNewLabel_1_1.setBounds(79, 144, 89, 22);
		panel_login.add(lblNewLabel_1_1);
		
		JButton btn_login = new JButton("Login");
		btn_login.setBackground(new Color(244, 245, 249));
		btn_login.setBorder(new LineBorder(new Color(17,24,39),2));
		btn_login.setFocusable(false);
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ID = Integer.valueOf(textFieldID.getText());
				String password = textfield_passowrd.getText();
				
				if (textFieldID.getText().isBlank() || textfield_passowrd.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin đăng nhập");
					return;
				}
				
				if(new LoginDao().isValidAccount(ID, password)) {
//					new ClientGUI(ID).setVisible(true);
					new ClientGUI(ID).setVisible(true);
					setVisible(false);
				}
			}
		});
		btn_login.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btn_login.setForeground(SystemColor.desktop);
		btn_login.setBounds(79, 220, 272, 37);
		panel_login.add(btn_login);
		
		JButton btn_login_1 = new JButton("Sign Up");
		btn_login_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		btn_login_1.setForeground(SystemColor.desktop);
		btn_login_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btn_login_1.setFocusable(false);
		btn_login_1.setBorder(new LineBorder(new Color(17,24,39),2));
		btn_login_1.setBackground(new Color(244, 245, 249));
		btn_login_1.setBounds(79, 268, 272, 37);
		panel_login.add(btn_login_1);
		
		JPanel panel_signup = new JPanel();
		panel_signup.setBackground(new Color(244, 245, 249));
		tabbedPane.addTab("New tab", null, panel_signup, null);
		panel_signup.setLayout(null);
		
		JLabel lblSignUp = new JLabel("SIGN UP");
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setForeground(SystemColor.desktop);
		lblSignUp.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblSignUp.setBackground(SystemColor.desktop);
		lblSignUp.setBounds(0, 0, 430, 51);
		panel_signup.add(lblSignUp);
		
		JLabel lbname = new JLabel("Name");
		lbname.setForeground(SystemColor.desktop);
		lbname.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lbname.setBounds(74, 44, 89, 22);
		panel_signup.add(lbname);
		
		textFieldNam = new JTextField();
		textFieldNam.setForeground(SystemColor.desktop);
		textFieldNam.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldNam.setColumns(10);
		textFieldNam.setBounds(74, 69, 272, 37);
		panel_signup.add(textFieldNam);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(SystemColor.desktop);
		lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblEmail.setBounds(74, 117, 89, 22);
		panel_signup.add(lblEmail);
		
		textField_mail = new JTextField();
		textField_mail.setForeground(SystemColor.desktop);
		textField_mail.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textField_mail.setColumns(10);
		textField_mail.setBounds(74, 142, 272, 37);
		panel_signup.add(textField_mail);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(SystemColor.desktop);
		passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		passwordField.setBounds(74, 213, 272, 37);
		panel_signup.add(passwordField);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Password");
		lblNewLabel_1_1_1.setForeground(SystemColor.desktop);
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(74, 190, 89, 22);
		panel_signup.add(lblNewLabel_1_1_1);
		
		JButton btn_login_1_1 = new JButton("Sign Up");
		btn_login_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textFieldNam.getText();
				String email = textField_mail.getText();
				String pass = passwordField.getText();
				
				new AccountDao().addAccount(name, email, pass);
			}
		});
		btn_login_1_1.setForeground(SystemColor.desktop);
		btn_login_1_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btn_login_1_1.setFocusable(false);
		btn_login_1_1.setBorder(new LineBorder(new Color(17,24,39),2));
		btn_login_1_1.setBackground(new Color(244, 245, 249));
		btn_login_1_1.setBounds(74, 255, 272, 37);
		panel_signup.add(btn_login_1_1);
		
		JButton btn_login_2 = new JButton("Login");
		btn_login_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btn_login_2.setForeground(SystemColor.desktop);
		btn_login_2.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btn_login_2.setFocusable(false);
		btn_login_2.setBorder(new LineBorder(new Color(17,24,39),2));
		btn_login_2.setBackground(new Color(244, 245, 249));
		btn_login_2.setBounds(74, 296, 272, 37);
		panel_signup.add(btn_login_2);
	}
}
