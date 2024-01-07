package vue.suppression;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controleur.suppression.GestionSuppressionLocation;

public class Fenetre_SupprimerLocation extends JInternalFrame {
	GestionSuppressionLocation gestionSuppressionLocation;

	public Fenetre_SupprimerLocation() {

		this.gestionSuppressionLocation = new GestionSuppressionLocation(this);

		this.setBounds(100, 100, 445, 210);
		this.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Êtes-vous sûr de vouloir supprimer cette location ?");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(32, 23, 371, 70);
		this.getContentPane().add(lblNewLabel);

		JButton btn_supprimer = new JButton("Supprimer");
		btn_supprimer.addActionListener(this.gestionSuppressionLocation);
		btn_supprimer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_supprimer.setBounds(96, 103, 103, 30);
		this.getContentPane().add(btn_supprimer);

		JButton btn_annuler = new JButton("Annuler");
		btn_annuler.addActionListener(this.gestionSuppressionLocation);
		btn_annuler.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_annuler.setBounds(233, 103, 95, 30);
		this.getContentPane().add(btn_annuler);

	}
}
