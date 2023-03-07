import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class PurchaseSystem {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Purchase System");
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel topPanel = new JPanel();
		JPanel centerPanel = new JPanel();

		frame.add(topPanel, BorderLayout.NORTH);
		frame.add(centerPanel, BorderLayout.CENTER);

		topPanel.setLayout(new BorderLayout());

		JLabel titleLabel = new JLabel("Purchase System");
		topPanel.add(titleLabel, BorderLayout.CENTER);

		JPanel supplierPanel = new JPanel();
		JTextField supplierNameField = new JTextField(20);
		JButton addSupplierButton = new JButton("Add Supplier");
		supplierPanel.add(new JLabel("Supplier Name: "));
		supplierPanel.add(supplierNameField);
		supplierPanel.add(addSupplierButton);
		topPanel.add(supplierPanel, BorderLayout.SOUTH);

		String[] columnNames = { "Supplier Name", "Product Name", "Quantity", "Price" };
		Object[][] data = { { "ABC Supplier", "Product 1", 10, 100.00 }, { "XYZ Supplier", "Product 2", 20, 200.00 } };

		JTable orderTable = new JTable(data, columnNames);
		JScrollPane scrollPane = new JScrollPane(orderTable);
		centerPanel.add(scrollPane);

		frame.setVisible(true);
	}
}