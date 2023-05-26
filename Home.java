package projetFinModule;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Home extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel panelMenu = new JPanel();
	private final JLabel faculte = new JLabel("Faculté des sciences - El Jadida ");
	private final JPanel desk = new JPanel();
	private final JButton btnAcc = new JButton("Acceuil");
	private final JButton btnReinsc = new JButton("Pré-Inscription");
	private final JButton btnEdt = new JButton("EDT");
	private final JButton btnExamens = new JButton("Examens");
	private final JButton btnNotes = new JButton("Notes");
	private final JButton btnInscriptionExamen = new JButton("Inscription Examen");
	private final JButton btnDemandeDocuments = new JButton("Demande documents");
	private final JButton btnDeconnexion = new JButton("Deconnexion");
	private final JLabel lblNewLabel_1 = new JLabel("et événements importants à venir.");

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
					Home frame3 = new Home();
					frame3.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/images/fs.jpg")));
		setTitle("HOME-ACCEUIL");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,764,655);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		panelMenu.setBounds(0, 0, 245, 622);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(Home.class.getResource("/images/fs-removebg-preview.png")));
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setBounds(0, 0, 239, 197);
		panelMenu.add(logo);
		faculte.setFont(new Font("SansSerif", Font.BOLD, 13));
		faculte.setForeground(new Color(0, 0, 0));
		faculte.setHorizontalAlignment(SwingConstants.CENTER);
		faculte.setBounds(0, 181, 233, 29);
		
		panelMenu.add(faculte);
		btnAcc.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnAcc.setForeground(Color.RED);
		btnAcc.setBounds(25, 222, 187, 33);
		
		panelMenu.add(btnAcc);
		btnReinsc.setForeground(new Color(0, 128, 0));
		btnReinsc.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnReinsc.setBounds(25, 267, 187, 33);
		
		panelMenu.add(btnReinsc);
		btnEdt.setForeground(new Color(0, 0, 0));
		btnEdt.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnEdt.setBounds(25, 312, 187, 33);
		
		panelMenu.add(btnEdt);
		btnExamens.setForeground(Color.RED);
		btnExamens.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnExamens.setBounds(25, 357, 187, 33);
		
		panelMenu.add(btnExamens);
		btnNotes.setForeground(new Color(0, 128, 0));
		btnNotes.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnNotes.setBounds(25, 402, 187, 33);
		
		panelMenu.add(btnNotes);
		btnInscriptionExamen.setForeground(Color.BLACK);
		btnInscriptionExamen.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnInscriptionExamen.setBounds(25, 447, 187, 33);
		
		panelMenu.add(btnInscriptionExamen);
		btnDemandeDocuments.setForeground(Color.RED);
		btnDemandeDocuments.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnDemandeDocuments.setBounds(25, 492, 187, 33);
		
		panelMenu.add(btnDemandeDocuments);
		
		// ajout d'un action listener pour revenir vers le login
				btnDeconnexion.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						LogIn frame=new LogIn();
						frame.setVisible(true);
						frame.setLocationRelativeTo(null);
						dispose();
					}
				});
		btnDeconnexion.setForeground(new Color(0, 0, 128));
		btnDeconnexion.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnDeconnexion.setBounds(25, 561, 187, 33);
		panelMenu.add(btnDeconnexion);
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
		//bouton de preinscription
		btnReinsc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PreInscription3 frame = new PreInscription3();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});
		
		
		desk.setBackground(SystemColor.inactiveCaption);
		desk.setBounds(238, 0, 504, 627);
		
		contentPane.add(desk);
		desk.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenue sur votre espace");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Century", Font.PLAIN, 17));
		lblNewLabel.setBounds(102, 260, 308, 74);
		desk.add(lblNewLabel);
		
		JLabel lblRestezInformDes = new JLabel("Restez informé des dernières mises à jour  ");
		lblRestezInformDes.setFont(new Font("Century", Font.PLAIN, 17));
		lblRestezInformDes.setHorizontalAlignment(SwingConstants.CENTER);
		lblRestezInformDes.setBounds(31, 288, 467, 89);
		desk.add(lblRestezInformDes);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Century", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(115, 311, 295, 105);
		
		desk.add(lblNewLabel_1);
	}
}
