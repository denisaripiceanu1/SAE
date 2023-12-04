package vue.insertion;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;


public class Fenetre_InsertionLogement extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre_InsertionLogement frame = new Fenetre_InsertionLogement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Fenetre_InsertionLogement() {
		this.setBounds(100, 100, 762, 541);
		this.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 755, 511);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		JSeparator separator_titreInsererLogement = new JSeparator();
		separator_titreInsererLogement.setForeground(new Color(0, 102, 204));
		separator_titreInsererLogement.setBounds(271, 72, 190, 2);
		panel.add(separator_titreInsererLogement);
		
		JLabel lbl_InsererUnLogement = new JLabel("Insérer un logement");
		lbl_InsererUnLogement.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_InsererUnLogement.setBounds(290, 25, 171, 48);
		panel.add(lbl_InsererUnLogement);

	}

}
