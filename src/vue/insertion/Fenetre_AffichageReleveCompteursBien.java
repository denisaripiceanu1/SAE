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
import controleur.insertion.GestionAffichageReleveCompteurBien;
import javax.swing.JScrollPane;

public class Fenetre_AffichageReleveCompteursBien extends JInternalFrame {

	private GestionAffichageReleveCompteurBien gestionAffichage;

	// Table pour afficher les compteurs associés
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

		JLabel lbl_AffichageCompteursBien = new JLabel("Compteurs du bien");
		lbl_AffichageCompteursBien.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_AffichageCompteursBien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_AffichageCompteursBien.setBounds(293, 11, 160, 48);
		panel.add(lbl_AffichageCompteursBien);

		// ScrollPane pour la table qui affiche les données d'entreprise
		this.scrollPane_table_compteurs = new JScrollPane();
		this.scrollPane_table_compteurs.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
		this.scrollPane_table_compteurs.setBounds(60, 103, 627, 238);
		panel.add(this.scrollPane_table_compteurs);

		// Table pour afficher les données d'entreprise
		this.table_releve_compteur_bien = new JTable();
		this.table_releve_compteur_bien.setModel(new DefaultTableModel(new Object[][] { { null, null }, },
				new String[] { "Date de relev\u00E9", "Index relev\u00E9" }));
		table_releve_compteur_bien.getColumnModel().getColumn(0).setPreferredWidth(95);
		table_releve_compteur_bien.getColumnModel().getColumn(1).setPreferredWidth(101);
		this.table_releve_compteur_bien.setBounds(499, 80, 135, 16);
		scrollPane_table_compteurs.setViewportView(this.table_releve_compteur_bien);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setBackground(new Color(0, 102, 204));
		btnAnnuler.setBounds(330, 376, 94, 31);
		btnAnnuler.addActionListener(this.gestionAffichage);
		panel.add(btnAnnuler);

	}

	public JTable getTable_releve_compteur_bien() {
		return this.table_releve_compteur_bien;
	}
}
