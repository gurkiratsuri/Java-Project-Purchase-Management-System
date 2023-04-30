package purchasesystem;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class NewLogin {

	public JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					NewLogin window = new NewLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NewLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame("Create New Login");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(0, 0, 1100, 700);
		/*
		 * Setting the Icon of the Window Image img = Toolkit.getDefaultToolkit().
		 * getImage("D:\\GKS PERSONAL\\Downloaded images\\0022.jpg");
		 * frame.setIconImage(img); ImageIcon img = new
		 * ImageIcon("D:\\GKS PERSONAL\\Downloaded images\\0022.jpg"); JLabel
		 * background; background = new JLabel(img); background.setBounds(0, 0, 100,
		 * 50); frame.getContentPane().add(background);
		 */
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("USER ID:");
		lblNewLabel.setBounds(320, 200, 150, 25);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("PASSWORD:");
		lblNewLabel_1.setBounds(320, 285, 150, 25);
		frame.getContentPane().add(lblNewLabel_1);

		textField = new JTextField();
		lblNewLabel.setLabelFor(textField);
		textField.setBounds(500, 200, 200, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("SIGN UP");
		btnNewButton.setBounds(320, 370, 180, 40);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("HOME");
		btnNewButton_1.setBounds(520, 370, 180, 40);
		frame.getContentPane().add(btnNewButton_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(500, 285, 200, 25);
		frame.getContentPane().add(passwordField);

		btnNewButton_1.addActionListener(new ActionListener() {
			/* @Override */
			@Override

			public void actionPerformed(ActionEvent e) {
				Home HomeObj = new Home();
				frame.setVisible(false);
				HomeObj.initialize();
				HomeObj.frame.setVisible(true);
			}
		});
		// frame.setVisible(true);

		btnNewButton.addActionListener(new ActionListener() {

			/* @Override */
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String i = textField.getText();
					if (i == null || i.equals("")) {
						JOptionPane.showMessageDialog(btnNewButton,
								"Please enter the details or navigate back to home.");
					} else {
					String id = textField.getText();
					String pwd = passwordField.getText();

					// step1 load the driver class
					Class.forName("oracle.jdbc.driver.OracleDriver");

					// step2 create the connection object
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM",
							"Kirat123");

					String query = "insert into USERS values(?,?)";
					PreparedStatement pstmt = conn.prepareStatement(query);
					pstmt.setString(1, id);
					pstmt.setString(2, pwd);

					pstmt.execute();
					conn.close();
					JOptionPane.showMessageDialog(btnNewButton, "Sign up Successful");
					Home HomeObj = new Home();
					frame.setVisible(false);
					HomeObj.initialize();
					HomeObj.frame.setVisible(true);
					}
				} catch (HeadlessException | ClassNotFoundException | NumberFormatException | SQLException e13) {
					System.out.println(e13.toString());
					JOptionPane.showMessageDialog(btnNewButton, e13.toString());
				}
			}
		});

	}
}
