package vue.insertion;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

public class Fenetre_AffichageInfoLocataire extends JInternalFrame {
	private JTextField textField_Nom;
	private JTextField textField_Prenom;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Fenetre_AffichageInfoLocataire frame = new Fenetre_AffichageInfoLocataire();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Fenetre_AffichageInfoLocataire() {
        this.setBounds(100, 100, 762, 541);
        this.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 755, 511);
        this.getContentPane().add(panel);
        panel.setLayout(null);

        JSeparator separator_AffichageInfoQuotite = new JSeparator();
        separator_AffichageInfoQuotite.setForeground(new Color(0, 102, 204));
        separator_AffichageInfoQuotite.setBounds(280, 57, 190, 2);
        panel.add(separator_AffichageInfoQuotite);

        JLabel lbl_AffichageInfoLocataire = new JLabel("Mon Locataire");
        lbl_AffichageInfoLocataire.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_AffichageInfoLocataire.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbl_AffichageInfoLocataire.setBounds(293, 11, 160, 48);
        panel.add(lbl_AffichageInfoLocataire);

        JLabel lblNewLabel = new JLabel("Détail locataire");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel.setBounds(21, 85, 137, 14);
        panel.add(lblNewLabel);

        JButton btnRegularisationCharges = new JButton("Régularisation des charges");
        btnRegularisationCharges.setBounds(519, 434, 200, 25);
        // Ajoutez le code associé à l'action du bouton ici
        panel.add(btnRegularisationCharges);
        
        textField_Nom = new JTextField();
        textField_Nom.setColumns(10);
        textField_Nom.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Nom", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
        textField_Nom.setBounds(21, 115, 190, 40);
        panel.add(textField_Nom);
        
        textField_Prenom = new JTextField();
        textField_Prenom.setColumns(10);
        textField_Prenom.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Prenom", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
        textField_Prenom.setBounds(221, 115, 190, 40);
        panel.add(textField_Prenom);
    }
}
