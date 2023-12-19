package vue.insertion.csv;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
				lire.lireCSV(chemin.getSelectedFilePath());
			}
		});
		btnNewButton.setBounds(235, 176, 252, 97);
		getContentPane().add(btnNewButton);
	}
}
