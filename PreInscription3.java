package projetFinModule;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class PreInscription3 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JCheckBox CHEK1;
	private JCheckBox CHEK2;
	private JCheckBox CHEK3;
	private JCheckBox CHEK4;
	private JCheckBox CHEK5;
	private JCheckBox CHEK6;
	private JCheckBox[] checkboxes = new JCheckBox[6];
	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 */
	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		//apply look and feel
		UIManager.setLookAndFeel(new NimbusLookAndFeel())	;	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PreInscription3 frame = new PreInscription3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PreInscription3() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PreInscription3.class.getResource("/images/fs.jpg")));
		setTitle("Pré-Inscription");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,764,655);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 245, 642);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PreInscription3.class.getResource("/images/fs-removebg-preview.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 6, 239, 197);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Faculté des sciences - El Jadida ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblNewLabel_1.setBounds(6, 188, 233, 29);
		panel.add(lblNewLabel_1);
		
		JButton btnAcc = new JButton("Acceuil");
		btnAcc.setForeground(Color.RED);
		btnAcc.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnAcc.setBounds(28, 229, 187, 33);
		//boutton d'acceuil
				btnAcc.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Home frame3 = new Home();
						frame3.setVisible(true);
						frame3.setLocationRelativeTo(null);
				        dispose();
					}
				});
		panel.add(btnAcc);
		
		JLabel lblNewLabel_2 = new JLabel("-Pré-Inscription-");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(257, 6, 485, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Filière :");
		lblNewLabel_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_3.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(286, 110, 165, 33);
		contentPane.add(lblNewLabel_3);
		
		//String[] filieres = { "Choisir", "SMI-BD", "SMI-Réseau"};
		JComboBox comboBox = new JComboBox(/*filieres*/);
		comboBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 String selectedModule = (String) comboBox.getSelectedItem();
                 try {
					updateCheckBoxVisibility(selectedModule);
				} catch (Throwable e1) {
					
					e1.printStackTrace();
				}
        	}
        });
		
        comboBox.setFont(new Font("SansSerif", Font.PLAIN, 15));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Choisir","Developement", "Reseaux"}));
	    comboBox.setBounds(467, 103, 214, 44);
		contentPane.add(comboBox);
        
        CHEK1 = new JCheckBox("New check box");
        checkboxes[0] = CHEK1;
        CHEK1.setFont(new Font("SansSerif", Font.PLAIN, 18));
        CHEK1.setBounds(257, 298, 424, 34);
        contentPane.add(CHEK1);
        
         CHEK2 = new JCheckBox("New check box");
         checkboxes[1] = CHEK2;
        CHEK2.setFont(new Font("SansSerif", Font.PLAIN, 18));
        CHEK2.setBounds(257, 344, 424, 34);
        contentPane.add(CHEK2);
        
        CHEK3 = new JCheckBox("New check box");
        checkboxes[2] = CHEK3;
        CHEK3.setFont(new Font("SansSerif", Font.PLAIN, 18));
        CHEK3.setBounds(257, 252, 485, 34);
        contentPane.add(CHEK3);
        
         CHEK4 = new JCheckBox("New check box");
         checkboxes[3] = CHEK4;
        CHEK4.setFont(new Font("SansSerif", Font.PLAIN, 18));
        CHEK4.setBounds(257, 390, 424, 34);
        contentPane.add(CHEK4);
        
         CHEK5 = new JCheckBox("New check box");
         checkboxes[4] = CHEK5;
        CHEK5.setFont(new Font("SansSerif", Font.PLAIN, 18));
        CHEK5.setBounds(257, 436, 424, 34);
        contentPane.add(CHEK5);
        
        CHEK6 = new JCheckBox("New check box");
        checkboxes[5] = CHEK6;
        CHEK6.setFont(new Font("SansSerif", Font.PLAIN, 18));
        CHEK6.setBounds(257, 482, 424, 34);
        contentPane.add(CHEK6);
        
        JButton btnValider = new JButton("Valider");
        btnValider.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		
        		 if(isAtLeastOneCheckboxSelected())
			      {	  
        			 
        			 			String filiere=(String) comboBox.getSelectedItem();
        			 			//System.out.println(filiere);
        			 			ArrayList<String> arr = new ArrayList<>();
        			 			for(JCheckBox k : checkboxes) {
        			 				if(k.isSelected()) {
        			 					arr.add(k.getText());
        			 				}
        			 			}
        			 			Object[] modules = arr.toArray();
						       Recu1 frame = new Recu1(filiere,modules);
								frame.setVisible(true);
								frame.setLocationRelativeTo(null);
								dispose();
							}	
        		 else {
        			 JOptionPane.showMessageDialog(null, "Veuillez cocher au moins une case", "Erreur", JOptionPane.ERROR_MESSAGE);
        		 }
			}
        	private boolean isAtLeastOneCheckboxSelected() {
        	    return CHEK1.isSelected() || CHEK2.isSelected() || CHEK3.isSelected() || CHEK4.isSelected() || CHEK5.isSelected() || CHEK6.isSelected();
        	}
        });
        btnValider.setForeground(Color.RED);
        btnValider.setFont(new Font("SansSerif", Font.BOLD, 13));
        btnValider.setBounds(577, 566, 165, 44);
        contentPane.add(btnValider);

        
    
               CHEK1.setVisible(false);
       	 	   CHEK2.setVisible(false);
       	 	   CHEK3.setVisible(false);
       	 	   CHEK4.setVisible(false);
       	 	   CHEK5.setVisible(false);
       	 	   CHEK6.setVisible(false);
		
       	 	   
	
	}
       	       
       	
//la methode 
private void updateCheckBoxVisibility(String selectedModule) throws Throwable {
	
	   CHEK1.setVisible(true);
	   CHEK2.setVisible(true);
	   CHEK3.setVisible(true);
	   CHEK4.setVisible(true);
	   CHEK5.setVisible(true);
	   CHEK6.setVisible(true);
	   String driver = "com.mysql.cj.jdbc.Driver";
	   Class.forName(driver);
		Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_etudiant", "root", "");
		Statement st = cnx.createStatement();
		 if (selectedModule.equals("Developement")) {
			   try {
		            String query = "SELECT * FROM filiere WHERE id_filiere =1";
		            PreparedStatement statement = cnx.prepareStatement(query);
		            ResultSet resultSet = statement.executeQuery();
		            if (resultSet.next()) {
		                String module1= resultSet.getString("module1");    
		                String module2= resultSet.getString("module2");
		                String module3= resultSet.getString("module3");
		                String module4= resultSet.getString("module4");
		                String module5= resultSet.getString("module5");
		                String module6= resultSet.getString("module6");
		                CHEK1.setText(module1);
		                CHEK2.setText(module2);
		                CHEK3.setText(module3);
		                CHEK4.setText(module4);
		                CHEK5.setText(module5);
		                CHEK6.setText(module6);
		              
		            }
			   } catch (SQLException e) {
		            e.printStackTrace();
		        }	}
		 if (selectedModule.equals("Reseaux")) {
			    try {
			        String query = "SELECT * FROM filiere WHERE id_filiere =3 ";
			        PreparedStatement statement = cnx.prepareStatement(query);
			        ResultSet resultSet = statement.executeQuery();
			        if (resultSet.next()) {
			        	 String module1= resultSet.getString("module1");    
			             String module2= resultSet.getString("module2");
			             String module3= resultSet.getString("module3");
			             String module4= resultSet.getString("module4");
			             String module5= resultSet.getString("module5");
			             String module6= resultSet.getString("module6");
			             CHEK1.setText(module1);
			              CHEK2.setText(module2);
			              CHEK3.setText(module3);
			              CHEK4.setText(module4);
			              CHEK5.setText(module5);
			              CHEK6.setText(module6);
			           
			        }
			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
			}
		
	}
}
