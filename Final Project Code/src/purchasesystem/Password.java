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

public class Password {

	public JFrame frame;
	private JPasswordField passwordField_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Password window = new Password();
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
	public Password() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame("Change Password");
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

		JLabel lblNewLabel_1 = new JLabel("NEW PASSWORD:");
		lblNewLabel_1.setBounds(320, 285, 150, 25);
		frame.getContentPane().add(lblNewLabel_1);


		JButton btnNewButton_1 = new JButton("HOME");
		btnNewButton_1.setBounds(520, 370, 180, 40);
		frame.getContentPane().add(btnNewButton_1);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(500, 285, 200, 25);
		frame.getContentPane().add(passwordField_1);

		textField = new JTextField();
		textField.setBounds(500, 200, 200, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

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

		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.setBounds(320, 370, 180, 40);
		frame.getContentPane().add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String i = textField.getText();
					if (i == null || i.equals("")) {
						JOptionPane.showMessageDialog(btnNewButton,
								"Please enter the details or navigate back to home.");
					} else {
					String id = textField.getText();
					String pwd;
					pwd = passwordField_1.getText();

					try {
						// step1 load the driver class
						Class.forName("oracle.jdbc.driver.OracleDriver");

						// step2 create the connection object
						Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM",
								"Kirat123");
						String query = "update USERS set Password=? where User_id = ?";
						PreparedStatement stmt = conn.prepareStatement(query);
						stmt.setString(1, pwd);
						stmt.setString(2, id);

						stmt.execute();
					} finally {

						JOptionPane.showMessageDialog(btnNewButton, "Record successfully updated");

					}
					}
				} catch (HeadlessException | ClassNotFoundException | SQLException e12) {
				}

			}
		});
	}

}