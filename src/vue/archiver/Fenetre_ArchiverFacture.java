package vue.archiver;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controleur.archiver.GestionArchiverFacture;

public class Fenetre_ArchiverFacture extends JInternalFrame {
	GestionArchiverFacture gestionSuppressionCharge;

	public Fenetre_ArchiverFacture() {

		this.gestionSuppressionCharge = new GestionArchiverFacture(this);

		this.setBounds(100, 100, 445, 210);
		this.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Êtes-vous sûr de vouloir archiver cette facture ?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(31, 23, 371, 70);
		this.getContentPane().add(lblNewLabel);

		JButton btn_supprimer = new JButton("Archiver");
		btn_supprimer.addActionListener(this.gestionSuppressionCharge);
		btn_supprimer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_supprimer.setBounds(96, 103, 103, 30);
		this.getContentPane().add(btn_supprimer);

		JButton btn_annuler = new JButton("Annuler");
		btn_annuler.addActionListener(this.gestionSuppressionCharge);
		btn_annuler.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_annuler.setBounds(233, 103, 95, 30);
		this.getContentPane().add(btn_annuler);

	}
}
