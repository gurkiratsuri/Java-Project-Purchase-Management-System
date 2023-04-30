package purchasesystem;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.JTextField;

public class AddSupplier {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					AddSupplier window = new AddSupplier();
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
	public AddSupplier() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame("Add A New Supplier");
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(0, 0, 1100, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("ENTER THE DETAILS OF THE NEW SUPPLIER:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(50, 60, 570, 50);
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("HOME");
		btnNewButton.setBounds(800, 10, 150, 30);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("SUPPLIER ID:");
		lblNewLabel_1.setBounds(50, 120, 150, 25);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("SUPPLIER NAME:");
		lblNewLabel_2.setBounds(50, 180, 150, 25);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("CONTACT NUMBER:");
		lblNewLabel_3.setBounds(50, 240, 150, 25);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("ADDRESS:");
		lblNewLabel_4.setBounds(50, 300, 150, 25);
		frame.getContentPane().add(lblNewLabel_4);

		textField = new JTextField();
		textField.setBounds(250, 120, 150, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(250, 180, 150, 25);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(250, 240, 150, 25);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(250, 300, 150, 25);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		JButton btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String i = textField.getText();
					if (i == null || i.equals("")) {
						JOptionPane.showMessageDialog(btnNewButton,
								"Please enter the details or navigate back to home.");
					} else {
						String sId = textField.getText();
						String sName = textField_1.getText();
						double contactNo = Double.parseDouble(textField_2.getText());
						String address = textField_3.getText();

						// step1 load the driver class
						Class.forName("oracle.jdbc.driver.OracleDriver");

						// step2 create the connection object
						Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM",
								"Kirat123");

						String query = "insert into SUPPLIER values(?,?,?,?)";
						PreparedStatement pstmt = conn.prepareStatement(query);
						pstmt.setString(1, sId);
						pstmt.setString(2, sName);
						pstmt.setDouble(3, contactNo);
						pstmt.setString(4, address);

						pstmt.execute();
						conn.close();
						JOptionPane.showMessageDialog(btnNewButton, "Supplier added successfully.");
					}
				} catch (HeadlessException | ClassNotFoundException | NumberFormatException | SQLException e14) {
					System.out.println(e14.toString());
					JOptionPane.showMessageDialog(btnNewButton, e14.toString());
				}
			}
		});
		btnNewButton_1.setBounds(475, 450, 150, 25);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton.addActionListener(new ActionListener() {
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
	}
}