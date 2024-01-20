package vue.archiver;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controleur.archiver.GestionArchiverFacture;

public class Fenetre_ArchiverFacture extends JInternalFrame {

    // Instance de la classe GestionArchiverFacture utilisée pour gérer l'archivage de la facture
    private GestionArchiverFacture gestionSuppressionCharge;

    // Constructeur de la fenêtre
    public Fenetre_ArchiverFacture() {

        // Initialisation de la gestion de l'archivage de la facture avec une référence à la fenêtre actuelle
        this.gestionSuppressionCharge = new GestionArchiverFacture(this);

        // Configuration des dimensions et de la disposition de la fenêtre
        this.setBounds(100, 100, 445, 210);
        this.getContentPane().setLayout(null);

        // Ajout d'une étiquette pour demander la confirmation de l'archivage de la facture
        JLabel lblNewLabel = new JLabel("Êtes-vous sûr de vouloir archiver cette facture ?");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(31, 23, 371, 70);
        this.getContentPane().add(lblNewLabel);

        // Ajout d'un bouton "Archiver" avec un gestionnaire d'événements associé
        JButton btn_supprimer = new JButton("Archiver");
        btn_supprimer.addActionListener(this.gestionSuppressionCharge);
        btn_supprimer.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_supprimer.setBounds(96, 103, 103, 30);
        this.getContentPane().add(btn_supprimer);

        // Ajout d'un bouton "Annuler" avec un gestionnaire d'événements associé
        JButton btn_annuler = new JButton("Annuler");
        btn_annuler.addActionListener(this.gestionSuppressionCharge);
        btn_annuler.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_annuler.setBounds(233, 103, 95, 30);
        this.getContentPane().add(btn_annuler);
    }
}
