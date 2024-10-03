package vue.archiver;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controleur.archiver.GestionArchiverLocataire;

public class Fenetre_ArchiverLocataire extends JInternalFrame {

    // Instance de la classe GestionArchiverLocataire utilisée pour gérer l'archivage du locataire
    private GestionArchiverLocataire gestionArchiverLocataire;

    // Constructeur de la fenêtre
    public Fenetre_ArchiverLocataire() {

        // Initialisation de la gestion de l'archivage du locataire avec une référence à la fenêtre actuelle
        this.gestionArchiverLocataire = new GestionArchiverLocataire(this);

        // Configuration des dimensions et de la disposition de la fenêtre
        this.setBounds(100, 100, 445, 210);
        this.getContentPane().setLayout(null);

        // Ajout d'une étiquette pour demander la confirmation de l'archivage du locataire
        JLabel lblNewLabel = new JLabel("Êtes-vous sûr de vouloir archiver ce locataire ?");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(32, 23, 371, 70);
        this.getContentPane().add(lblNewLabel);

        // Ajout d'un bouton "Archiver" avec un gestionnaire d'événements associé
        JButton btn_supprimer = new JButton("Archiver");
        btn_supprimer.addActionListener(this.gestionArchiverLocataire);
        btn_supprimer.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_supprimer.setBounds(96, 103, 103, 30);
        this.getContentPane().add(btn_supprimer);

        // Ajout d'un bouton "Annuler" avec un gestionnaire d'événements associé
        JButton btn_annuler = new JButton("Annuler");
        btn_annuler.addActionListener(this.gestionArchiverLocataire);
        btn_annuler.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_annuler.setBounds(233, 103, 95, 30);
        this.getContentPane().add(btn_annuler);
    }
}
