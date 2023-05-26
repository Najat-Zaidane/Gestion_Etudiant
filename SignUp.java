package projetFinModule;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.Toolkit;
import java.awt.SystemColor;


public class SignUp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cne1;
	private JTextField nom1;
	private JTextField prenom1;
	private JTextField date_naissance1;
	private JTextField nationalite1;
	private JPasswordField pwd;

	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 */
	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		//apply Look'n Feel
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
				    frame.setLocationRelativeTo(null);
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
	
	public SignUp() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SignUp.class.getResource("/images/fs.jpg")));
		setTitle("SIGN UP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 648);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 346, 609);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 346, 603);
		lblNewLabel_2.setIcon(new ImageIcon(SignUp.class.getResource("/images/classroom-g0abfb0b38_1280.jpg")));
		panel.add(lblNewLabel_2);
		//boutton d'inscription
		JButton btnNewButton = new JButton("S'inscrire");
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnNewButton.setForeground(new Color(255, 0, 0));
		//add action listner
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkEmptyFields())
					
					JOptionPane.showMessageDialog(null,"Veuillez remplir tout le formulaire","Missing data",JOptionPane.ERROR_MESSAGE);
				else {	
					String nom=nom1.getText();
				
					String prenom=prenom1.getText();
					
					String nationalite=nationalite1.getText();
					
					String date_naissance=date_naissance1.getText();
					
					String cne=cne1.getText();
					
					String mot_de_passe=String.valueOf(pwd.getPassword());
					
					PreparedStatement ps;
					String query="INSERT INTO gestion_etudiant.etudiant(id_etudiant,nom,prenom,nationalite,date_naissance,cne,mot_de_passe) VALUES(null,?,?,?,?,?,?)";
					try {
						ps=connexion.getConnection().prepareStatement(query);
						ps.setString(1,nom);
						ps.setString(2,prenom);
						ps.setString(3,nationalite);
						ps.setString(4,date_naissance);
						ps.setString(5,cne);
						ps.setString(6,mot_de_passe);
						if(ps.executeUpdate()!=0) {
							JOptionPane.showMessageDialog(null, "votre compte est crée avec succes, veuillez utiliser le CNE et le mote de passe que vous avez choisi pour se connecter","Bienvenue",JOptionPane.PLAIN_MESSAGE);
							LogIn frame=new LogIn();
							frame.setVisible(true);
							frame.setLocationRelativeTo(null);
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "Erreur de création","Oups!",JOptionPane.ERROR_MESSAGE);
						}
					
				}catch(Exception ex)
					{
					//JOptionPane.showMessageDialog(null, "la connexion avec la base n'a pas été établie","erreur",JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
					}
				}
			}

			private boolean checkEmptyFields() {
				// TODO Auto-generated method stub
				return false;
			}

			
				
		});
		
		
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		btnNewButton.setBounds(565, 528, 187, 45);
		contentPane.add(btnNewButton);
		
		cne1 = new JTextField();
		cne1.setHorizontalAlignment(SwingConstants.CENTER);
		cne1.setBounds(372, 80, 356, 45);
		contentPane.add(cne1);
		cne1.setColumns(10);
		
		nom1 = new JTextField();
		nom1.setHorizontalAlignment(SwingConstants.CENTER);
		nom1.setColumns(10);
		nom1.setBounds(372, 149, 356, 45);
		contentPane.add(nom1);
		
		prenom1 = new JTextField();
		prenom1.setHorizontalAlignment(SwingConstants.CENTER);
		prenom1.setColumns(10);
		prenom1.setBounds(372, 222, 356, 45);
		contentPane.add(prenom1);
		
		date_naissance1 = new JTextField();
		date_naissance1.setHorizontalAlignment(SwingConstants.CENTER);
		date_naissance1.setColumns(10);
		date_naissance1.setBounds(372, 291, 356, 45);
		contentPane.add(date_naissance1);
		
		nationalite1 = new JTextField();
		nationalite1.setHorizontalAlignment(SwingConstants.CENTER);
		nationalite1.setColumns(10);
		nationalite1.setBounds(372, 372, 356, 45);
		contentPane.add(nationalite1);
		
		JLabel lblNewLabel = new JLabel("Veuillez remplir le formulaire");
		lblNewLabel.setBackground(SystemColor.activeCaption);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(358, 6, 381, 45);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CNE");
		lblNewLabel_1.setBounds(372, 63, 122, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nom");
		lblNewLabel_1_1.setBounds(372, 133, 122, 16);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Prénom");
		lblNewLabel_1_2.setBounds(372, 204, 122, 16);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Date de naissance");
		lblNewLabel_1_3.setBounds(372, 276, 122, 16);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Nationalité");
		lblNewLabel_1_4.setBounds(372, 358, 122, 16);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Mot de passe");
		lblNewLabel_1_3_1.setBounds(372, 436, 122, 16);
		contentPane.add(lblNewLabel_1_3_1);
		
		pwd = new JPasswordField();
		pwd.setHorizontalAlignment(SwingConstants.CENTER);
		pwd.setBounds(372, 453, 356, 45);
		contentPane.add(pwd);
		//boutton pour revenir ver logIn
		JButton btnPrcdent = new JButton("Précédent ");
		btnPrcdent.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnPrcdent.setForeground(new Color(255, 0, 0));
		// ajout d'un action listener pour revenir vers le login
		btnPrcdent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LogIn frame=new LogIn();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});
		
		btnPrcdent.setBackground(SystemColor.inactiveCaption);
		btnPrcdent.setBounds(366, 528, 187, 45);
		contentPane.add(btnPrcdent);
	}

}
