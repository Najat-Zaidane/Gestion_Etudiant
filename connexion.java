package projetFinModule;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class connexion {
	Connection conn = null;
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/gestion_etudiant","root","");
			return conn;
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;	
		}
	}
}
