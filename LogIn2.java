package projetFinModule;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

public class LogIn2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cnelog;
	private JPasswordField pwdlog;

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
					LogIn2 frame = new LogIn2();
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
	public LogIn2() {
		setTitle("LOG IN");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LogIn2.class.getResource("/images/fs.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,774,648);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(0, 0, 760, 609);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(SystemColor.activeCaption);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(LogIn2.class.getResource("/images/fslogo.png")));
		lblNewLabel.setBounds(6, 0, 760, 157);
		panel.add(lblNewLabel);
		
		cnelog = new JTextField();
		cnelog.setHorizontalAlignment(SwingConstants.CENTER);
		cnelog.setBackground(SystemColor.textHighlightText);
		cnelog.setColumns(10);
		cnelog.setBounds(246, 211, 289, 54);
		panel.add(cnelog);
		
		pwdlog = new JPasswordField();
		pwdlog.setHorizontalAlignment(SwingConstants.CENTER);
		pwdlog.setBackground(SystemColor.textHighlightText);
		pwdlog.setBounds(246, 297, 289, 54);
		panel.add(pwdlog);
		
		JLabel lblNewLabel_1 = new JLabel("CNE");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(119, 216, 89, 43);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mot de passe");
		lblNewLabel_1_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(80, 297, 128, 43);
		panel.add(lblNewLabel_1_1);
		//boutton d'inscription 
		JButton btnSinscrire = new JButton("S'inscrire");
		btnSinscrire.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

								SignUp frame=new SignUp();
								frame.setVisible(true);
								frame.setLocationRelativeTo(null);
								dispose();
							
			}		
		});
		
		btnSinscrire.setForeground(Color.RED);
		btnSinscrire.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnSinscrire.setBounds(289, 485, 203, 54);
		panel.add(btnSinscrire);
		//boutton se connecter
		JButton btnNewButton_1_1 = new JButton("Se connecter");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 if(checkEmptyFields())
						
						JOptionPane.showMessageDialog(null,"Veuillez remplir les deux champs","Missing data",JOptionPane.ERROR_MESSAGE);
					else {	
						
						String cne=cnelog.getText();
						String mot_de_passe=String.valueOf(pwdlog.getPassword());
						
						PreparedStatement ps;
						String query="SELECT * FROM gestion_etudiant.etudiant WHERE cne=? AND mot_de_passe=?";
						try {
							ps=connexion.getConnection().prepareStatement(query);
							ps.setString(1,cne);
							ps.setString(2,mot_de_passe);
							ResultSet rs = ps.executeQuery();
							if(rs.next()) {
								Student std = new Student();
								std.setId(rs.getInt("id_etudiant"));
								std.setNom(rs.getString("nom"));
								std.setPrenom(rs.getString("prenom"));
								std.setNationalite(rs.getString("nationalite"));
								std.setCne(rs.getString("cne"));
								std.setDate_de_naissance(rs.getString("date_naissance"));
								std.setMot_de_passe(rs.getString("mot_de_passe"));
								SharedData.std = std;
								Home frame3=new Home();
								frame3.setVisible(true);
								frame3.setLocationRelativeTo(null);
								dispose();
							}
							else {
								JOptionPane.showMessageDialog(null, "Aucun utilisateur avec ce cne ou mot de passe","incorrect data",JOptionPane.ERROR_MESSAGE);
							}
						
					}catch(Exception ex)
						{
						ex.printStackTrace();
						}
					}
				
				
			}

			private boolean checkEmptyFields() {
				// TODO Auto-generated method stub
				return false;
			}
		});
		
		
		btnNewButton_1_1.setForeground(Color.RED);
		btnNewButton_1_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnNewButton_1_1.setBounds(289, 405, 203, 54);
		panel.add(btnNewButton_1_1);
	}
}
