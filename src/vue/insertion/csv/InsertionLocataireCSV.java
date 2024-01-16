package vue.insertion.csv;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;

import controleur.outils.ImportChemin;
import controleur.outils.LireCSV;

public class InsertionLocataireCSV extends JInternalFrame {
	private ImportChemin chemin;
	private LireCSV lire;

	public InsertionLocataireCSV() {
		getContentPane().setLayout(null);
		chemin = new ImportChemin();
		lire = new LireCSV();
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chemin.choisirChemin();
				try {
					lire.lireCSV(chemin.getSelectedFilePath());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // ma bite je le fais
			}
		});
		btnNewButton.setBounds(235, 176, 252, 97);
		getContentPane().add(btnNewButton);
	}
}
