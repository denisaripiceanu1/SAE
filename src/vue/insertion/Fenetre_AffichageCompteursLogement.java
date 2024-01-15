package vue.insertion;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controleur.insertion.GestionAffichageCompteursLogement;
import controleur.insertion.GestionTableAffichageCompteursLogement;

public class Fenetre_AffichageCompteursLogement extends JInternalFrame {

	private GestionAffichageCompteursLogement gestionAffichage;
	private GestionTableAffichageCompteursLogement gestionClic;
	// Table pour afficher les compteurs associés
	private JScrollPane scrollPane_table_compteurs;
	private JTable table_compteurs;

	public Fenetre_AffichageCompteursLogement() {
		// Initialisation du gestionnaire d'affichage
		this.gestionAffichage = new GestionAffichageCompteursLogement(this);
		this.gestionClic = new GestionTableAffichageCompteursLogement(this);

		this.setBounds(100, 100, 762, 541);
		this.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 750, 512);
		this.getContentPane().add(panel);
		panel.setLayout(null);

		// Titre et séparateur
		JSeparator separator_AffichageInfoQuotite = new JSeparator();
		separator_AffichageInfoQuotite.setForeground(new Color(0, 102, 204));
		separator_AffichageInfoQuotite.setBounds(280, 57, 190, 2);
		panel.add(separator_AffichageInfoQuotite);

		JLabel lbl_AffichageCompteursBien = new JLabel("Compteurs du logement");
		lbl_AffichageCompteursBien.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_AffichageCompteursBien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_AffichageCompteursBien.setBounds(259, 10, 225, 48);
		panel.add(lbl_AffichageCompteursBien);

		this.scrollPane_table_compteurs = new JScrollPane();
		this.scrollPane_table_compteurs.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
		this.scrollPane_table_compteurs.setBounds(60, 103, 627, 238);
		panel.add(this.scrollPane_table_compteurs);

		// Table pour afficher les données d'entreprise
		this.table_compteurs = new JTable();
		this.table_compteurs.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, },
				new String[] { "Id_Compteur", "Type Compteur", "Prix abonnement" }));
		this.table_compteurs.getColumnModel().getColumn(1).setPreferredWidth(95);
		this.table_compteurs.getColumnModel().getColumn(2).setPreferredWidth(101);
		this.table_compteurs.setBounds(499, 80, 135, 16);
		this.scrollPane_table_compteurs.setViewportView(this.table_compteurs);
		this.table_compteurs.getSelectionModel().addListSelectionListener(this.gestionClic);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setBackground(new Color(0, 102, 204));
		btnAnnuler.setBounds(149, 369, 94, 31);
		btnAnnuler.addActionListener(this.gestionAffichage);
		panel.add(btnAnnuler);

		JButton btnAjouterReleve = new JButton("Ajouter un relevé");
		btnAjouterReleve.setForeground(Color.WHITE);
		btnAjouterReleve.setBackground(new Color(0, 102, 204));
		btnAjouterReleve.setBounds(491, 369, 166, 31);
		btnAjouterReleve.addActionListener(this.gestionAffichage);
		panel.add(btnAjouterReleve);

		JButton btnAfficherReleve = new JButton("Afficher les relevés");
		btnAfficherReleve.addActionListener(this.gestionAffichage);
		btnAfficherReleve.setForeground(Color.WHITE);
		btnAfficherReleve.setBackground(new Color(0, 102, 204));
		btnAfficherReleve.setBounds(287, 369, 166, 31);
		btnAfficherReleve.addActionListener(this.gestionAffichage);
		panel.add(btnAfficherReleve);
	}

	public GestionAffichageCompteursLogement getGestionAffichage() {
		return this.gestionAffichage;
	}

	public JTable getTable_compteurs() {
		return this.table_compteurs;
	}

}
