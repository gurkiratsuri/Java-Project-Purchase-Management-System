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
//import java.awt.ScrollPane;

public class OrdersSent {

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
					OrdersSent window = new OrdersSent();
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
	public OrdersSent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	public void initialize() {
		frame = new JFrame("Orders Sent");
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(0, 0, 1100, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("ORDERS SENT TO THE SUPPLIERS:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(50, 60, 550, 50);
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("HOME");
		btnNewButton.setBounds(800, 10, 150, 30);
		frame.getContentPane().add(btnNewButton);

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

		}, new String[] { "O_ID", "O_NAME", "QUANTITY", "S_ID", "S_NAME" }) {
			Class[] types = new Class[] { java.lang.String.class, java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.String.class };

			@Override
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		});

		// JScrollPane scrollPane = new JScrollPane(table);
		// table.setFillsViewportHeight(true);
		// JScrollPane jSPane = new JScrollPane();
		// jSPane.setViewportView(table);

		try {
			// step1 load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2 create the connection object
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "Kirat123");

			// step3 create the statement object
			Statement stmt = conn.createStatement();
			String query = "select * from ORDERS_SENT";
			ResultSet rs = stmt.executeQuery(query);

			// step4 execute query
			DefaultTableModel dtm = (DefaultTableModel) table.getModel();
			Object row1[] = { "ORDER ID", "ORDER NAME", "QUANTITY", "SUPPLIER ID", "SUPPLIER NAME" };
			dtm.addRow(row1);
			while (rs.next()) {
				String oId = rs.getString(1);
				String oName = rs.getString(2);
				String quantity = rs.getString(3);
				String sId = rs.getString(4);
				String sName = rs.getString(5);

				Object row[] = { oId, oName, quantity, sId, sName };
				// System.out.println(r+" "+n+" "+c+" "+m);
				dtm.addRow(row);
			}
			// step5 close the connection object
			conn.close();

		} catch (Exception e) {
			System.out.println(e);
		}

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