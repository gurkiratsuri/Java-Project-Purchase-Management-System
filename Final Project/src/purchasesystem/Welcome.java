package purchasesystem;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Welcome {

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
					Welcome window = new Welcome();
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
	public Welcome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame("Login into Purchase Management System");
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
		lblNewLabel.setBounds(320, 200, 200, 25);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("PASSWORD:");
		lblNewLabel_1.setBounds(320, 285, 200, 25);
		frame.getContentPane().add(lblNewLabel_1);

		textField = new JTextField();
		lblNewLabel.setLabelFor(textField);
		textField.setBounds(500, 200, 200, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		lblNewLabel_1.setLabelFor(passwordField);
		passwordField.setBounds(500, 285, 200, 25);
		frame.getContentPane().add(passwordField);
		passwordField.setColumns(10);

		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBounds(320, 370, 180, 40);
		frame.getContentPane().add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {

			/*@Override*/
			@Override
			public void actionPerformed(ActionEvent e) {
				try 
		        {
		            String i=textField.getText();
		            if(i==null || i.equals(""))
		            {
		                JOptionPane.showMessageDialog(btnNewButton, "Please enter the login username");
		            }
		            else
		            {
		             String userid = textField.getText();
						String pwd = passwordField.getText();
		             
		             try 
		             {
							// step1 load the driver class
							Class.forName("oracle.jdbc.driver.OracleDriver");

							// step2 create the connection object
							Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
									"SYSTEM", "Kirat123");

		                 String query = "select * from USERS where User_id=? and Password = ?";
							PreparedStatement stmt = conn.prepareStatement(query);
							stmt.setString(1, userid);
							stmt.setString(2, pwd);
							ResultSet rs = stmt.executeQuery();
		                 if(rs.next())
		                 {
		                     JOptionPane.showMessageDialog(btnNewButton, "Login successful");
		                     Home HomeObj = new Home();
		     				frame.setVisible(false);
		     				HomeObj.initialize();
		     				HomeObj.frame.setVisible(true);
		                     
		                 }
		                 else
		                 {
								JOptionPane.showMessageDialog(btnNewButton, "Incorrect Username or Password!");
		                 }
		             } 
						catch (HeadlessException | ClassNotFoundException | SQLException e11)
		             {
							System.out.println(e11.toString());
							JOptionPane.showMessageDialog(btnNewButton, e11.toString());
		             }
		     }
		    }
				finally {

				}
		}
	});

		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.setBounds(420, 455, 180, 40);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("SIGN UP\r\n");
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				NewLogin NewLoginObj = new NewLogin();
				frame.setVisible(false);
				NewLoginObj.initialize();
				NewLoginObj.frame.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(520, 370, 180, 40);
		frame.getContentPane().add(btnNewButton_2);

		btnNewButton_1.addActionListener(new ActionListener() {

			/* @Override */
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		// frame.setVisible(true);
	}
}