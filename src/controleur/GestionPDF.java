package controleur;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.outils.PDFImporter;
import vue.insertion.Fenetre_InsertionLocation;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GestionPDF extends JInternalFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;
	private JLabel nomPdf;
	private int id;
	private String nom;
	private Fenetre_InsertionLocation fil;
	private PDFImporter pdf;

	/**
	 * Create the frame.
	 */
	public GestionPDF(Fenetre_InsertionLocation fil) {
		this.fil = fil;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("id");
		lblNewLabel.setBounds(55, 14, 8, 13);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(68, 11, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		nomPdf = new JLabel("");
		nomPdf.setBounds(163, 81, 200, 13); // Ajustez la taille si nécessaire
		contentPane.add(nomPdf);
		
		btnNewButton = new JButton("pdf");
		btnNewButton.setBounds(68, 77, 85, 21);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            // Déclarez id et nom comme variables locales si elles ne sont pas des variables d'instance
		            id = Integer.parseInt(textField.getText()); // Assurez-vous que le champ textField contient un entier
		            nom = textField_1.getText();

		            // Assurez-vous que l'instance pdf est correctement initialisée
		            if (pdf == null) {
		            	 pdf = PDFImporter.getInstance();
		            }
		            pdf.importPDFChemin();
		            
		            if(pdf.getPDFFileName() != null) {
		            	nomPdf.setText(pdf.getPDFFileName());
		            }

		        } catch (NumberFormatException ex) {
		            // Gérer l'exception si l'ID n'est pas un entier
		            ex.printStackTrace();
		        }
		    }
		});

		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setBounds(259, 14, 21, 13);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(285, 11, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		nomPdf = new JLabel("");
		nomPdf.setBounds(163, 81, 200, 13); // Ajustez la taille si nécessaire
		contentPane.add(nomPdf);
		
		JButton btnNewButton_1 = new JButton("Ajoutez");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					pdf.getInstance().importPDFBD(id, nom);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(79, 211, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAnnuler.setBounds(270, 211, 85, 21);
		contentPane.add(btnAnnuler);
	}
}
