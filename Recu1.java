package projetFinModule;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;



public class Recu1 extends JFrame {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelRecu;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private static String filiere;
	private static Object[] modules;
	//private static String[] selectedModule;

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
					Recu1 frame = new Recu1(filiere,modules);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param filiere 
	 * @param modules2 
	 * @param selectedModule2 
	 */
	public Recu1(String filiere, Object[] modules2) {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Recu1.class.getResource("/images/fs.jpg")));
		setTitle("Pré-inscription | Reçu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 648);
	   // setBounds(100,100,690,750);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//JPanel panelRecu = new JPanel();
		panelRecu = new JPanel();
		panelRecu.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelRecu.setBounds(78, 11, 514, 592);
		contentPane.add(panelRecu);
		panelRecu.setLayout(null);
		
		JLabel lblRuDinscription = new JLabel("Reçu d'inscription:");
		lblRuDinscription.setHorizontalAlignment(SwingConstants.CENTER);
		lblRuDinscription.setForeground(Color.RED);
		lblRuDinscription.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRuDinscription.setBounds(89, 11, 344, 34);
		panelRecu.add(lblRuDinscription);
		
		//label de cne
		JLabel lblNewLabel_1 = new JLabel("CNE :\r\n");
		lblNewLabel_1.setForeground(Color.BLUE);
		//textfield de cne
		textField = new JTextField(SharedData.std.getCne());
		//design de Jlabel cne
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(25, 67, 123, 34);
		//design de textfield cne
		textField.setBounds(158, 86, 218, 34);	
		textField.setColumns(10);
		//ajout au panel
		panelRecu.add(lblNewLabel_1);
		panelRecu.add(textField);
		
		//jlabel de nom
		JLabel lblNewLabel_1_1 = new JLabel("NOM :");
		lblNewLabel_1_1.setForeground(Color.BLUE);
		//text de nom
		textField_1 = new JTextField(SharedData.std.getNom());
		//design de label
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(25, 131, 123, 34);
		//design de text
		textField_1.setColumns(10);
		textField_1.setBounds(158, 146, 218, 34);
		//ajout
		panelRecu.add(lblNewLabel_1_1);
		panelRecu.add(textField_1);
		
		//label prenom
		JLabel lblNewLabel_1_2 = new JLabel("Prenom :");
		lblNewLabel_1_2.setForeground(Color.BLUE);
		//text prenom
		textField_2 = new JTextField(SharedData.std.getPrenom());
		//design label
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(25, 191, 123, 34);
		//design text
		textField_2.setColumns(10);
		textField_2.setBounds(158, 210, 218, 34);
		//ajout
		panelRecu.add(lblNewLabel_1_2);
		panelRecu.add(textField_2);
		
		//label filiere
		JLabel lblNewLabel_1_2_1 = new JLabel("FILIERE :");
		lblNewLabel_1_2_1.setForeground(Color.BLUE);
		//text filiere
		textField_3 = new JTextField(filiere);
        //design label
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1.setBounds(25, 257, 123, 34);
		//design text 
		textField_3.setColumns(10);
		textField_3.setBounds(158, 266, 218, 34);
		//ajout
		panelRecu.add(lblNewLabel_1_2_1);
		panelRecu.add(textField_3);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("MODULES CHOISIS :");
		lblNewLabel_1_2_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_1.setBounds(25, 317, 181, 34);
		panelRecu.add(lblNewLabel_1_2_1_1);
		
		JPanel panelModule = new JPanel(new GridLayout(6,1));
		for(Object module : modules2) {
			JLabel lab = new JLabel((String)module,JLabel.LEFT);
			panelModule.add(lab);
		}
		panelModule.setBounds(53, 349, 420, 212);
		panelRecu.add(panelModule);
		
		JButton btnEditerReu = new JButton("Editer Reçu");
		
		btnEditerReu.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnEditerReu.setForeground(new Color(0, 0, 0));
		btnEditerReu.setBounds(604, 563, 151, 40);
		
		btnEditerReu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				  // Appeler la méthode pour générer le fichier PDF
                genererPDF();
                dispose();
				
			}
		});
		
		contentPane.add(btnEditerReu);
	}
	  private void genererPDF() {
	        try {
	            String file_name = "recu.pdf";
	            Document document = new Document();
	            PdfWriter.getInstance(document, new FileOutputStream(file_name));
	            document.open();

	            // Ajouter le contenu du panelRecu au fichier PDF
	            addComponentToPDF(document, panelRecu);

	            document.close();
	           // System.out.println("Le fichier PDF a été généré avec succès.");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	  private void addComponentToPDF(Document document, JPanel panel) {
	       try {
	            for (int i = 0; i < panel.getComponentCount(); i++) {
	                Component component = panel.getComponent(i);

	                if (component instanceof JLabel) {
	                    JLabel label = (JLabel) component;
	                    com.itextpdf.text.Font font = FontFactory.getFont(FontFactory.HELVETICA, 13, Font.BOLD);
	                    Paragraph paragraph = new Paragraph(label.getText());
	                    paragraph.setAlignment(Element.ALIGN_LEFT);
	                    document.add(paragraph);
	                } else if (component instanceof JTextField) {
	                    JTextField textField = (JTextField) component;
	                    com.itextpdf.text.Font font = FontFactory.getFont(FontFactory.HELVETICA, 13, Font.PLAIN);
	                    Paragraph paragraph = new Paragraph(textField.getText());
	                    paragraph.setAlignment(Element.ALIGN_RIGHT);
	                    document.add(paragraph);
	                } 
	                else if (component instanceof JPanel) {
	                    JPanel subPanel = (JPanel) component;
	                    addComponentToPDF(document, subPanel);
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}

	  
	    



