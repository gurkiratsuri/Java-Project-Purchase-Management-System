package purchasesystem;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ProjectCopyrights {

	public JFrame frame;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ProjectCopyrights window = new ProjectCopyrights();
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
	public ProjectCopyrights() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame("Project Copyrights");
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.setBounds(0, 0, 1100, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("JAVA PROJECT");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(50, 60, 570, 50);
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("HOME");
		btnNewButton.setBounds(800, 10, 150, 30);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("© Gurkirat Kaur Suri, 2023, All Rights Reserved");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1.setBounds(225, 275, 600, 50);
		frame.getContentPane().add(lblNewLabel_1);
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