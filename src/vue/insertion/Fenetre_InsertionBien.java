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

public class Fenetre_InsertionBien extends JInternalFrame {
	private JTextField textField_IdImmeuble;
	private JTextField textField_adresse;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Fenetre_InsertionBien frame = new Fenetre_InsertionBien();
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
	public Fenetre_InsertionBien() {
		this.setBounds(100, 100, 762, 541);
		this.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 755, 511);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		JSeparator separator_titreInsererBien = new JSeparator();
		separator_titreInsererBien.setForeground(new Color(0, 102, 204));
		separator_titreInsererBien.setBounds(72, 72, 190, 2);
		panel.add(separator_titreInsererBien);
		
		JLabel lbl_InsererUnBien = new JLabel("Ajouter un Bien");
		lbl_InsererUnBien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_InsererUnBien.setBounds(105, 24, 117, 48);
		panel.add(lbl_InsererUnBien);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(369, 26, 100, 461);
		panel.add(separator);
		
		textField_IdImmeuble = new JTextField();
		textField_IdImmeuble.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Id Bien", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		textField_IdImmeuble.setBounds(72, 100, 190, 40);
		panel.add(textField_IdImmeuble);
		textField_IdImmeuble.setColumns(10);
		
		textField_adresse = new JTextField();
		textField_adresse.setColumns(10);
		textField_adresse.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Adresse", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_adresse.setBounds(72, 150, 190, 40);
		panel.add(textField_adresse);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Adresse", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField.setBounds(72, 200, 190, 40);
		panel.add(textField);

	}
}
