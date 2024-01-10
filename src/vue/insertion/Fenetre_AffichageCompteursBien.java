package vue.insertion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controleur.insertion.GestionAffichageCompteurs;
import controleur.insertion.GestionAffichageInfoLocataire;
import controleur.insertion.GestionTableAffichageCompteurs;
import controleur.modification.GestionModificationLocataire;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Fenetre_AffichageCompteursBien extends JInternalFrame {
	
    private GestionAffichageCompteurs gestionAffichage;
	private GestionTableAffichageCompteurs gestionClic;
	// Table pour afficher les compteurs associés
    private JScrollPane scrollPane_table_compteurs;
	private JTable table_compteurs;

    public Fenetre_AffichageCompteursBien() {
        // Initialisation du gestionnaire d'affichage 
        this.gestionAffichage = new GestionAffichageCompteurs(this); 
        this.gestionClic = new GestionTableAffichageCompteurs(this);
   
        this.setBounds(100, 100, 762, 541);
        this.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(6, 6, 755, 511);
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
        
        this.scrollPane_table_compteurs = new JScrollPane();
		this.scrollPane_table_compteurs.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
		this.scrollPane_table_compteurs.setBounds(55, 103, 627, 297);
		panel.add(this.scrollPane_table_compteurs);

		// Table pour afficher les données d'entreprise
		this.table_compteurs = new JTable();
		this.table_compteurs.setSelectionBackground(new Color(0, 102, 204));
		this.table_compteurs
				.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Id_Compteur", "Type Compteur", "Prix abonnement"
			}
		));
		table_compteurs.getColumnModel().getColumn(1).setPreferredWidth(95);
		table_compteurs.getColumnModel().getColumn(2).setPreferredWidth(101);
		this.table_compteurs.setBounds(499, 80, 135, 16);
		scrollPane_table_compteurs.setViewportView(this.table_compteurs);
		this.table_compteurs.getSelectionModel().addListSelectionListener(this.gestionClic);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setBackground(new Color(0, 102, 204));
		btnAnnuler.setBounds(248, 437, 94, 31);
		btnAnnuler.addActionListener(gestionAffichage);
		panel.add(btnAnnuler);

		JButton btnAjouterReleve = new JButton("Ajouter un relevé");
		btnAjouterReleve.setForeground(Color.WHITE);
		btnAjouterReleve.setBackground(new Color(0, 102, 204));
		btnAjouterReleve.setBounds(389, 437, 130, 31);
		btnAjouterReleve.addActionListener(gestionAffichage);
		panel.add(btnAjouterReleve);
    }
    
    public GestionAffichageCompteurs getGestionAffichage() {
		return gestionAffichage;
	}

 
}
