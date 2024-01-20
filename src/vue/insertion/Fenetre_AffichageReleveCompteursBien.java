package vue.insertion;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controleur.insertion.GestionAffichageReleveCompteurBien;
import javax.swing.JScrollPane;

public class Fenetre_AffichageReleveCompteursBien extends JInternalFrame {
	// Déclaration des gestionnaires
	private GestionAffichageReleveCompteurBien gestionAffichage;

	// Table pour afficher les compteurs associés et son scrollPane
	private JScrollPane scrollPane_table_compteurs;
	private JTable table_releve_compteur_bien;

	public Fenetre_AffichageReleveCompteursBien() {
		// Initialisation du gestionnaire d'affichage
		this.gestionAffichage = new GestionAffichageReleveCompteurBien(this);

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
		Utils.createLabel("Compteurs du bien", 293, 11, 160, 48, 16, panel);

		// Configuration du JScrollPane pour afficher la table des relevés de compteurs
		this.scrollPane_table_compteurs = new JScrollPane();
		this.scrollPane_table_compteurs.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
		this.scrollPane_table_compteurs.setBounds(60, 103, 627, 238);
		panel.add(this.scrollPane_table_compteurs);

		// Configuration de la table pour afficher les relevés de compteurs
		this.table_releve_compteur_bien = new JTable();
		this.table_releve_compteur_bien.setModel(new DefaultTableModel(new Object[][] { { null, null }, },
				new String[] { "Date de relev\u00E9", "Index relev\u00E9" }));
		this.table_releve_compteur_bien.getColumnModel().getColumn(0).setPreferredWidth(95);
		this.table_releve_compteur_bien.getColumnModel().getColumn(1).setPreferredWidth(101);
		this.table_releve_compteur_bien.setBounds(499, 80, 135, 16);
		this.scrollPane_table_compteurs.setViewportView(this.table_releve_compteur_bien);

		// Configuration du bouton "Annuler"
		JButton btnAnnuler = Utils.creerBouton(panel, "Annuler", 330, 376, 94, 31);
		btnAnnuler.addActionListener(this.gestionAffichage);

	}

	// Getter pour le gestionnaire d'affichage
	public GestionAffichageReleveCompteurBien getGestionAffichage() {
		return this.gestionAffichage;
	}

	// Getter pour la table des relevés de compteurs
	public JTable getTable_releve_compteur_bien() {
		return this.table_releve_compteur_bien;
	}
}
