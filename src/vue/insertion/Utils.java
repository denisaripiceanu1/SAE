package vue.insertion;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Font;

public class Utils {
    // Méthode pour créer un champ de texte avec une bordure spécifique
    public static JTextField createTextField(String title, int x, int y, int width, int height, JPanel panel, boolean etitable) {
        JTextField textField = new JTextField();
        textField.setColumns(10);
        textField.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), title, TitledBorder.LEADING,
                TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
        textField.setBounds(x, y, width, height);
        textField.setEditable(etitable);
        panel.add(textField);
        return textField;
    }
    
    // Méthode pour créer un bouton avec des caractéristiques spécifiques
    public static JButton creerBouton(String texte, int x, int y, int width, int height) {
        JButton bouton = new JButton(texte);
        bouton.setForeground(Color.WHITE);
        bouton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        bouton.setBackground(new Color(0, 102, 204));
		bouton.setBounds(x, y, width, height);
        return bouton;
    }
}
