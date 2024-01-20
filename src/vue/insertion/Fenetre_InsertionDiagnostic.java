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
        JSeparator separator_titreInsererBien = new JSeparator();
        separator_titreInsererBien.setForeground(new Color(0, 102, 204));
        separator_titreInsererBien.setBounds(263, 99, 190, 31);
        panel.add(separator_titreInsererBien);

        JLabel lbl_InsererUnDiagnostic = new JLabel("Ajouter un Diagnostic");
        lbl_InsererUnDiagnostic.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbl_InsererUnDiagnostic.setBounds(275, 53, 163, 48);
        panel.add(lbl_InsererUnDiagnostic);

        // Champ de texte pour la date de validité
        this.textField_Date_Validite = createTextField("Date validité", 263, 232, 190, 40, panel);

        // Boutons Ajouter et Annuler
        createButton("Ajouter", 244, 395, 94, 31, Color.WHITE, new Color(0, 102, 204), gestionClic, panel);
        createButton("Annuler", 396, 395, 94, 31, Color.WHITE, new Color(0, 102, 204), gestionClic, panel);

        // Champ de texte pour le type de diagnostic
        this.textField_Type = createTextField("Type", 263, 161, 190, 40, panel);
    }

    // Méthode pour créer un champ de texte avec une bordure spécifique
    private JTextField createTextField(String title, int x, int y, int width, int height, JPanel panel) {
        JTextField textField = new JTextField();
        textField.setColumns(10);
        textField.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), title, TitledBorder.LEADING,
                TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
        textField.setBounds(x, y, width, height);
        panel.add(textField);
        return textField;
    }

    // Méthode pour créer un bouton avec une couleur de texte, de fond et un gestionnaire d'événements spécifiques
    private JButton createButton(String label, int x, int y, int width, int height, Color textColor, Color bgColor,
            GestionInsertionDiagnostic listener, JPanel panel) {
        JButton button = new JButton(label);
        button.setFont(new Font("Tahoma", Font.PLAIN, 12));
        button.setBounds(x, y, width, height);
        button.setForeground(textColor);
        button.setBackground(bgColor);
        button.addActionListener(listener);
        panel.add(button);
        return button;
    }

    // Getters pour récupérer les valeurs des champs
    public JTextField getTextField_Date_Validite() {
        return this.textField_Date_Validite;
    }

    public JTextField getTextField_Type() {
        return this.textField_Type;
    }
}
