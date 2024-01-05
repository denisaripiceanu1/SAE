package vue.suppression;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controleur.suppression.GestionSuppressionBien;

public class Fenetre_SupprimerBien extends JInternalFrame {
	GestionSuppressionBien gestionSuppressionBien;

	public Fenetre_SupprimerBien() {

		this.gestionSuppressionBien = new GestionSuppressionBien(this);

		this.setBounds(100, 100, 445, 210);
		this.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Êtes-vous sur de vouloir supprimer ce bien ?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(52, 23, 323, 70);
		this.getContentPane().add(lblNewLabel);

		JButton btn_supprimer = new JButton("Supprimer");
		btn_supprimer.addActionListener(this.gestionSuppressionBien);
		btn_supprimer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_supprimer.setBounds(96, 103, 103, 30);
		this.getContentPane().add(btn_supprimer);

		JButton btn_annuler = new JButton("Annuler");
		btn_annuler.addActionListener(this.gestionSuppressionBien);
		btn_annuler.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_annuler.setBounds(233, 103, 95, 30);
		this.getContentPane().add(btn_annuler);

	}
}
