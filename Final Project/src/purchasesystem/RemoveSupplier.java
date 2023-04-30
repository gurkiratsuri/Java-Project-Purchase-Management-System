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
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RemoveSupplier {

	public JFrame frame;
	private JTextField textField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					RemoveSupplier window = new RemoveSupplier();
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
	public RemoveSupplier() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame("Remove Supplier");
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(0, 0, 1100, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("ENTER THE DETAILS OF THE SUPPLIER YOU WANT TO REMOVE:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(50, 60, 800, 50);
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("HOME");
		btnNewButton.setBounds(800, 10, 150, 30);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("SUPPLIER ID:");
		lblNewLabel_1.setBounds(375, 275, 150, 25);
		frame.getContentPane().add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(575, 275, 150, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnNewButton_1 = new JButton("REMOVE");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String i = textField.getText();
					if (i == null || i.equals("")) {
						JOptionPane.showMessageDialog(btnNewButton,
								"Please enter the details or navigate back to home.");
					} else {
						String id = textField.getText();

						// step1 load the driver class
						Class.forName("oracle.jdbc.driver.OracleDriver");

						// step2 create the connection object
						Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM",
								"Kirat123");

						String query = "delete from SUPPLIER where S_id=?";
						PreparedStatement pstmt = conn.prepareStatement(query);
						pstmt.setString(1, id);

						ResultSet rs = pstmt.executeQuery();
						if (rs.next()) {
							JOptionPane.showMessageDialog(btnNewButton, "Supplier removed successfully.");
						} else {
							JOptionPane.showMessageDialog(btnNewButton, "Record not found");
						}
						conn.close();
					}
				} catch (HeadlessException | ClassNotFoundException | SQLException e15) {
					System.out.println(e15.toString());
					JOptionPane.showMessageDialog(btnNewButton, e15.toString());
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