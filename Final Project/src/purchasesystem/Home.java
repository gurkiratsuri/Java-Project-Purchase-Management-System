package purchasesystem;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

public class Home {

	public JFrame frame;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Home window = new Home();
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
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame("Purchase Management System");
		frame.getContentPane().setBackground(Color.PINK);
		frame.setBounds(0, 0, 1100, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("LOG OUT");
		btnNewButton.setBounds(940, 599, 136, 43);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			/* @Override */
			@Override

			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnNewButton, "Logout Successful");
				Welcome WelcomeObj = new Welcome();
				frame.setVisible(false);
				WelcomeObj.initialize();
				WelcomeObj.frame.setVisible(true);
			}
		});

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(20, 20, 353, 31);
		frame.getContentPane().add(menuBar);

		JMenu mnNewMenu = new JMenu("ACCOUNT");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Login");
		mnNewMenu.add(mntmNewMenuItem);

		mntmNewMenuItem.addActionListener(new ActionListener() {
			/* @Override */
			@Override

			public void actionPerformed(ActionEvent e) {
				Welcome WelcomeObj = new Welcome();
				frame.setVisible(false);
				WelcomeObj.initialize();
				WelcomeObj.frame.setVisible(true);
			}
		});

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Change password");
		mnNewMenu.add(mntmNewMenuItem_1);

		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			/* @Override */
			@Override

			public void actionPerformed(ActionEvent e) {
				Password PasswordObj = new Password();
				frame.setVisible(false);
				PasswordObj.initialize();
				PasswordObj.frame.setVisible(true);
			}
		});

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Logout\r\n");
		mnNewMenu.add(mntmNewMenuItem_2);

		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			/* @Override */
			@Override

			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnNewButton, "Logout Successful");
				Welcome WelcomeObj = new Welcome();
				frame.setVisible(false);
				WelcomeObj.initialize();
				WelcomeObj.frame.setVisible(true);
			}
		});

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Create new login");
		mnNewMenu.add(mntmNewMenuItem_3);

		mntmNewMenuItem_3.addActionListener(new ActionListener() {

			/* @Override */
			@Override
			public void actionPerformed(ActionEvent e) {
				NewLogin NewLoginObj = new NewLogin();
				frame.setVisible(false);
				NewLoginObj.initialize();
				NewLoginObj.frame.setVisible(true);
			}
		});

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Exit");
		mnNewMenu.add(mntmNewMenuItem_4);

		mntmNewMenuItem_4.addActionListener(new ActionListener() {

			/* @Override */
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		JMenu mnNewMenu_1 = new JMenu("SUPPLIERS");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Add new supplier");
		mnNewMenu_1.add(mntmNewMenuItem_5);

		mntmNewMenuItem_5.addActionListener(new ActionListener() {

			/* @Override */
			@Override
			public void actionPerformed(ActionEvent e) {
				AddSupplier AddSupplierObj = new AddSupplier();
				frame.setVisible(false);
				AddSupplierObj.initialize();
				AddSupplierObj.frame.setVisible(true);
			}
		});

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Remove supplier");
		mnNewMenu_1.add(mntmNewMenuItem_6);

		mntmNewMenuItem_6.addActionListener(new ActionListener() {

			/* @Override */
			@Override
			public void actionPerformed(ActionEvent e) {
				RemoveSupplier RemoveSupplierObj = new RemoveSupplier();
				frame.setVisible(false);
				RemoveSupplierObj.initialize();
				RemoveSupplierObj.frame.setVisible(true);
			}
		});

		// JMenuItem mntmNewMenuItem_7 = new JMenuItem("Search supplier");
		// mnNewMenu_1.add(mntmNewMenuItem_7);

		// mntmNewMenuItem_7.addActionListener(new ActionListener() {

			/* @Override */
		/*
		 * @Override public void actionPerformed(ActionEvent e) { SearchSupplier
		 * SearchSupplierObj = new SearchSupplier(); frame.setVisible(false);
		 * SearchSupplierObj.initialize(); SearchSupplierObj.frame.setVisible(true); }
		 * });
		 */

		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Show all suppliers");
		mnNewMenu_1.add(mntmNewMenuItem_8);

		mntmNewMenuItem_8.addActionListener(new ActionListener() {

			/* @Override */

			@Override
			public void actionPerformed(ActionEvent e) {
				ShowAllSuppliers ShowAllSuppliersObj = new ShowAllSuppliers();
				frame.setVisible(false);
				ShowAllSuppliersObj.initialize();
				ShowAllSuppliersObj.frame.setVisible(true);
			}
		});

		JMenu mnNewMenu_2 = new JMenu("ORDERS");
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_9 = new JMenuItem("New Order");
		mnNewMenu_2.add(mntmNewMenuItem_9);

		mntmNewMenuItem_9.addActionListener(new ActionListener() {

			/* @Override */
			@Override
			public void actionPerformed(ActionEvent e) {
				NewOrder NewOrderObj = new NewOrder();
				frame.setVisible(false);
				NewOrderObj.initialize();
				NewOrderObj.frame.setVisible(true);
			}
		});

		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Orders sent");
		mnNewMenu_2.add(mntmNewMenuItem_10);

		mntmNewMenuItem_10.addActionListener(new ActionListener() {

			/* @Override */
			@Override
			public void actionPerformed(ActionEvent e) {
				OrdersSent OrdersSentObj = new OrdersSent();
				frame.setVisible(false);
				OrdersSentObj.initialize();
				OrdersSentObj.frame.setVisible(true);
			}
		});

		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Cancel Order");
		mnNewMenu_2.add(mntmNewMenuItem_11);

		mntmNewMenuItem_11.addActionListener(new ActionListener() {

			/* @Override */
			@Override
			public void actionPerformed(ActionEvent e) {
				CancelOrder CancelOrderObj = new CancelOrder();
				frame.setVisible(false);
				CancelOrderObj.initialize();
				CancelOrderObj.frame.setVisible(true);
			}
		});

		JMenu mnNewMenu_3 = new JMenu("REPORT");
		menuBar.add(mnNewMenu_3);

		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Goods recieved report");
		mnNewMenu_3.add(mntmNewMenuItem_12);

		mntmNewMenuItem_12.addActionListener(new ActionListener() {

			/* @Override */
			@Override
			public void actionPerformed(ActionEvent e) {
				GoodsReport GoodsReportObj = new GoodsReport();
				frame.setVisible(false);
				GoodsReportObj.initialize();
				GoodsReportObj.frame.setVisible(true);
			}
		});

		JMenuItem mntmNewMenuItem_13 = new JMenuItem("Payments report");
		mnNewMenu_3.add(mntmNewMenuItem_13);

		mntmNewMenuItem_13.addActionListener(new ActionListener() {

			/* @Override */
			@Override
			public void actionPerformed(ActionEvent e) {
				PaymentsReport PaymentsReportObj = new PaymentsReport();
				frame.setVisible(false);
				PaymentsReportObj.initialize();
				PaymentsReportObj.frame.setVisible(true);
			}
		});

		JMenu mnNewMenu_4 = new JMenu("ABOUT US");
		menuBar.add(mnNewMenu_4);

		JMenuItem mntmNewMenuItem_14 = new JMenuItem("Team info");
		mnNewMenu_4.add(mntmNewMenuItem_14);

		mntmNewMenuItem_14.addActionListener(new ActionListener() {

			/* @Override */
			@Override
			public void actionPerformed(ActionEvent e) {
				TeamInfo TeamInfoObj = new TeamInfo();
				frame.setVisible(false);
				TeamInfoObj.initialize();
				TeamInfoObj.frame.setVisible(true);
			}
		});

		JMenuItem mntmNewMenuItem_15 = new JMenuItem("Project copyrights");
		mnNewMenu_4.add(mntmNewMenuItem_15);

		mntmNewMenuItem_15.addActionListener(new ActionListener() {

			/* @Override */
			@Override
			public void actionPerformed(ActionEvent e) {
				ProjectCopyrights ProjectCopyrightsObj = new ProjectCopyrights();
				frame.setVisible(false);
				ProjectCopyrightsObj.initialize();
				ProjectCopyrightsObj.frame.setVisible(true);
			}
		});

		JLabel lblNewLabel = new JLabel("PURCHASE MANAGEMENT SYSTEM");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 55));
		lblNewLabel.setBounds(67, 183, 1009, 226);
		frame.getContentPane().add(lblNewLabel);

		// frame.setVisible(true);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
