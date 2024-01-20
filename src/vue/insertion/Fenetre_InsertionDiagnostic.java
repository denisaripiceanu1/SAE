package vue.insertion;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controleur.insertion.GestionInsertionDiagnostic;

public class Fenetre_InsertionDiagnostic extends JInternalFrame {
    // Champs de saisie
    private JTextField textField_Date_Validite;
    private JTextField textField_Type;
    
    // Gestionnaire d'actions
    private GestionInsertionDiagnostic gestionClic;

    public Fenetre_InsertionDiagnostic() {
        // Initialisation du gestionnaire d'insertion de diagnostic
        this.gestionClic = new GestionInsertionDiagnostic(this);

        // Configuration de la fenêtre interne
        this.setBounds(100, 100, 762, 541);
        this.getContentPane().setLayout(null);

        // Panneau principal
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 755, 511);
        this.getContentPane().add(panel);
        panel.setLayout(null);

        // Titre et séparateur
		Utils.createLabel("Ajouter un Diagnostic", 275, 53, 163, 48, 16, panel);

        JSeparator separator_titreInsererBien = new JSeparator();
        separator_titreInsererBien.setForeground(new Color(0, 102, 204));
        separator_titreInsererBien.setBounds(263, 99, 190, 31);
        panel.add(separator_titreInsererBien);

        // Champ de texte pour la date de validité
        this.textField_Date_Validite = Utils.createTextField("Date validité", 263, 232, 190, 40, panel);
        this.textField_Type = Utils.createTextField("Type", 263, 161, 190, 40, panel);

        // Boutons Ajouter et Annuler
		JButton btnAnnuler = Utils.creerBouton(panel, "Annuler", 396, 395, 94, 31);
		btnAnnuler.addActionListener(this.gestionClic);

		JButton btnAnjouter = Utils.creerBouton(panel, "Ajouter", 244, 395, 94, 31);
		btnAnjouter.addActionListener(this.gestionClic);
    }

    // Getters pour récupérer les valeurs des champs
    public JTextField getTextField_Date_Validite() {
        return this.textField_Date_Validite;
    }

    public JTextField getTextField_Type() {
        return this.textField_Type;
    }
}
