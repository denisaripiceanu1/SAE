package vue.insertion;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import controleur.insertion.GestionAffichageCompteursLogement;
import controleur.insertion.GestionTableAffichageCompteursLogement;

public class Fenetre_AffichageCompteursLogement extends JInternalFrame {

	// Déclaration des gestionnaires
	private GestionAffichageCompteursLogement gestionAffichage;
	private GestionTableAffichageCompteursLogement gestionClic;

	// Déclaration des composants Swing
	private JScrollPane scrollPane_table_compteurs;
	private JTable table_compteurs;

	public Fenetre_AffichageCompteursLogement() {
		// Initialisation des gestionnaires
		this.gestionAffichage = new GestionAffichageCompteursLogement(this);
		this.gestionClic = new GestionTableAffichageCompteursLogement(this);

		// Configuration de la fenêtre interne
		this.setBounds(100, 100, 762, 541);
		this.getContentPane().setLayout(null);

		// Configuration du panel principal
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

		// Libellé du titre
		JLabel lbl_AffichageCompteursBien = new JLabel("Compteurs du logement");
		lbl_AffichageCompteursBien.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_AffichageCompteursBien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_AffichageCompteursBien.setBounds(259, 10, 225, 48);
		panel.add(lbl_AffichageCompteursBien);

		// Configuration du JScrollPane pour afficher la table des compteurs
		this.scrollPane_table_compteurs = new JScrollPane();
		this.scrollPane_table_compteurs.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
		this.scrollPane_table_compteurs.setBounds(60, 103, 627, 238);
		panel.add(this.scrollPane_table_compteurs);

		// Configuration de la table pour afficher les données des compteurs
		this.table_compteurs = new JTable();
		this.table_compteurs.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, },
				new String[] { "Id_Compteur", "Type Compteur", "Prix abonnement" }));
		this.table_compteurs.getColumnModel().getColumn(1).setPreferredWidth(95);
		this.table_compteurs.getColumnModel().getColumn(2).setPreferredWidth(101);
		this.table_compteurs.setBounds(499, 80, 135, 16);
		this.scrollPane_table_compteurs.setViewportView(this.table_compteurs);
		this.table_compteurs.getSelectionModel().addListSelectionListener(this.gestionClic);

		// Configuration des boutons
		JButton btnAnnuler = Utils.creerBouton("Annuler", 149, 369, 94, 31);
		btnAnnuler.addActionListener(this.gestionAffichage);

		JButton btnAjoutReleve = Utils.creerBouton("Ajouter un relevé", 491, 369, 166, 31);
		btnAjoutReleve.addActionListener(this.gestionAffichage);

		JButton btnAfficherReleve = Utils.creerBouton("Afficher les relevés", 287, 369, 166, 31);
		btnAfficherReleve.addActionListener(this.gestionAffichage);
	}

	// Méthode pour obtenir la table des compteurs
	public JTable getTable_compteurs() {
		return this.table_compteurs;
	}

	public GestionAffichageCompteursLogement getGestionAffichage() {
		return gestionAffichage;
	}

}
