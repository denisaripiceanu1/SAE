package vue.insertion;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controleur.insertion.GestionInsertionQuotite;

public class Fenetre_InsertionQuotite extends JInternalFrame {
    private JTextField textField_Pourcentage;
    private GestionInsertionQuotite gestionClic;
    private JComboBox<String> comboBox_typeDeCompteur;

    public Fenetre_InsertionQuotite() {
        // Initialisation du gestionnaire d'insertion de quotité
        this.gestionClic = new GestionInsertionQuotite(this);

        this.setBounds(100, 100, 762, 541);
        this.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 755, 511);
        this.getContentPane().add(panel);
        panel.setLayout(null);

        // Titre et séparateur
        JSeparator separator_titreInsererQuotite = new JSeparator();
        separator_titreInsererQuotite.setForeground(new Color(0, 102, 204));
        separator_titreInsererQuotite.setBounds(271, 130, 190, 2);
        panel.add(separator_titreInsererQuotite);

        JLabel lbl_InsererUneQuotite = new JLabel("Ajouter une Quotité");
        lbl_InsererUneQuotite.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_InsererUneQuotite.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbl_InsererUneQuotite.setBounds(284, 84, 160, 48);
        panel.add(lbl_InsererUneQuotite);

        // Menu déroulant pour le type de compteur
        this.comboBox_typeDeCompteur = new JComboBox<String>();
        this.comboBox_typeDeCompteur.setModel(new DefaultComboBoxModel<String>(
                new String[] { "Eau", "Gaz", "Électricité", "Ordures ménagères" }));
        this.comboBox_typeDeCompteur.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Type",
                TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
        this.comboBox_typeDeCompteur.setBounds(271, 215, 189, 39);
        panel.add(this.comboBox_typeDeCompteur);

        // Champ de texte pour le pourcentage
        this.textField_Pourcentage = createTextField("Pourcentage (%)", 271, 291, 190, 40, panel);

        // Boutons Ajouter et Annuler
        createButton("Ajouter", 246, 447, 94, 31, Color.WHITE, new Color(0, 102, 204), gestionClic, panel);
        createButton("Annuler", 398, 447, 94, 31, Color.WHITE, new Color(0, 102, 204), gestionClic, panel);
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
            GestionInsertionQuotite listener, JPanel panel) {
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
    public JTextField getTextField_Pourcentage() {
        return this.textField_Pourcentage;
    }

    public JComboBox<String> getComboBox_typeDeCompteur() {
        return this.comboBox_typeDeCompteur;
    }
}
