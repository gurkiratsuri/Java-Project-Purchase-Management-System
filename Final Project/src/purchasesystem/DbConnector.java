package purchasesystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class DbConnector {
	public static void main(String args[]) {
		try {
//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");

//step2 create  the connection object  
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "Kirat123");

//step3 create the statement object  
			Statement stmt = conn.createStatement();

//step4 execute query  
			ResultSet rs = stmt.executeQuery("select * from emp");
			while (rs.next()) {
				System.out.println(
						rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4));
			}

//step5 close the connection object  
			conn.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}