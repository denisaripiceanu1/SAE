package vue.insertion;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controleur.insertion.GestionInsertionICC;

public class Fenetre_InsertionICC extends JInternalFrame {
    private JTextField textField_Annee;
    private GestionInsertionICC gestionClic;
    private JTextField textField_Trimestre;
    private JTextField textField_indice;

    public Fenetre_InsertionICC() {
        // Initialisation du gestionnaire d'insertion ICC
        this.gestionClic = new GestionInsertionICC(this);

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

        JLabel lbl_InsererUnICC = new JLabel("Ajouter un ICC");
        lbl_InsererUnICC.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_InsererUnICC.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbl_InsererUnICC.setBounds(284, 84, 160, 48);
        panel.add(lbl_InsererUnICC);

        // Champ de texte pour l'année
        this.textField_Annee = createTextField("Année", 271, 189, 190, 40, panel);

        // Boutons Ajouter et Annuler
        createButton("Ajouter", 246, 447, 94, 31, Color.WHITE, new Color(0, 102, 204), gestionClic, panel);
        createButton("Annuler", 398, 447, 94, 31, Color.WHITE, new Color(0, 102, 204), gestionClic, panel);

        // Champ de texte pour le trimestre
        this.textField_Trimestre = createTextField("Trimestre", 271, 263, 190, 40, panel);

        // Champ de texte pour l'indice
        this.textField_indice = createTextField("Indice", 271, 341, 190, 40, panel);
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
            GestionInsertionICC listener, JPanel panel) {
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
    public JTextField getTextField_Annee() {
        return textField_Annee;
    }

    public JTextField getTextField_Trimestre() {
        return textField_Trimestre;
    }

    public JTextField getTextField_indice() {
        return textField_indice;
    }

    public GestionInsertionICC getGestionClic() {
        return gestionClic;
    }
}
