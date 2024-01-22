package vue.archiver;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controleur.archiver.GestionArchiverLocation;

public class Fenetre_ArchiverLocation extends JInternalFrame {

    // Instance de la classe GestionArchiverLocation utilisée pour gérer l'archivage de la location
    private GestionArchiverLocation gestionArchiverLocation;

    // Constructeur de la fenêtre
    public Fenetre_ArchiverLocation() {

        // Initialisation de la gestion de l'archivage de la location avec une référence à la fenêtre actuelle
        this.gestionArchiverLocation = new GestionArchiverLocation(this);

        // Configuration des dimensions et de la disposition de la fenêtre
        this.setBounds(100, 100, 445, 210);
        this.getContentPane().setLayout(null);

        // Ajout d'une étiquette pour demander la confirmation de l'archivage de la location
        JLabel lblNewLabel = new JLabel("Êtes-vous sûr de vouloir archiver cette location ?");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(32, 23, 371, 70);
        this.getContentPane().add(lblNewLabel);

        // Ajout d'un bouton "Archiver" avec un gestionnaire d'événements associé
        JButton btn_supprimer = new JButton("Archiver");
        btn_supprimer.addActionListener(this.gestionArchiverLocation);
        btn_supprimer.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_supprimer.setBounds(96, 103, 103, 30);
        this.getContentPane().add(btn_supprimer);

        // Ajout d'un bouton "Annuler" avec un gestionnaire d'événements associé
        JButton btn_annuler = new JButton("Annuler");
        btn_annuler.addActionListener(this.gestionArchiverLocation);
        btn_annuler.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_annuler.setBounds(233, 103, 95, 30);
        this.getContentPane().add(btn_annuler);
    }
}
