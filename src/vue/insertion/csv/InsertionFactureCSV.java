package vue.insertion.csv;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;

import controleur.outils.ImportChemin;
import controleur.outils.LireCSV;

public class InsertionFactureCSV extends JInternalFrame {
	private ImportChemin chemin;
	private LireCSV lire;

	public InsertionFactureCSV() throws FileNotFoundException, IOException {
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
				}
			}
		});
		btnNewButton.setBounds(235, 176, 252, 97);
		getContentPane().add(btnNewButton);
	}
}
