package purchasesystem;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

public class PaymentsReport {

	public JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(ShowAllSuppliers.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ShowAllSuppliers.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ShowAllSuppliers.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ShowAllSuppliers.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					PaymentsReport window = new PaymentsReport();
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
	public PaymentsReport() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame("Payment Report");
		frame.getContentPane().setBackground(Color.PINK);
		frame.setBounds(0, 0, 1100, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("GENERATE PAYMENTS REPORT:\r\n");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(50, 60, 500, 50);
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("HOME");
		btnNewButton.setBounds(800, 10, 150, 30);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("GENERATE PAYMENTS REPORT");
		btnNewButton_1.setBounds(50, 120, 330, 40);
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

		table = new JTable() {
			@Override
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setBounds(50, 175, 1000, 450);
		frame.getContentPane().add(table);

		table.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "O_ID", "O_NAME", "QUANTITY", "PRICE", "S_ID", "S_NAME" }) {
			Class[] types = new Class[] { java.lang.String.class, java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.String.class, java.lang.String.class };

			@Override
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		});

		btnNewButton_1.addActionListener(new ActionListener() {
			/* @Override */
			@Override

			public void actionPerformed(ActionEvent e) {

				try {
					// step1 load the driver class
					Class.forName("oracle.jdbc.driver.OracleDriver");

					// step2 create the connection object
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM",
							"Kirat123");

					// step3 create the statement object
					Statement stmt = conn.createStatement();
					String query = "select O_ID, O_NAME, QUANTITY, PRICE, S_ID, S_NAME from ORDERS_RECEIVED";
					ResultSet rs = stmt.executeQuery(query);

					// step4 execute query
					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
					Object row1[] = { "ORDER ID", "ORDER NAME", "QUANTITY", "PAYMENT", "SUPPLIER ID", "SUPPLIER NAME" };
					dtm.addRow(row1);
					while (rs.next()) {
						String oId = rs.getString(1);
						String oName = rs.getString(2);
						String quantity = rs.getString(3);
						String payment = rs.getString(4);
						String sId = rs.getString(5);
						String sName = rs.getString(6);

						Object row[] = { oId, oName, quantity, payment, sId, sName };
						// System.out.println(r+" "+n+" "+c+" "+m);
						dtm.addRow(row);
					}
					// step5 close the connection object
					conn.close();

				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});

		// frame.setVisible(true);
	}
}
