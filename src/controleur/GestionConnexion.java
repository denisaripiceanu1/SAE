package controleur;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import modele.dao.CictOracleDataSource;
import vue.Fenetre_Accueil;
import vue.Fenetre_Connexion;

public class GestionConnexion implements ActionListener{
	
	private Fenetre_Connexion fc;
	
	public GestionConnexion(Fenetre_Connexion fc) {
		this.fc = fc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton text = (JButton) e.getSource();

		switch (text.getText()) {
		case "Se connecter":
			String login = fc.getNomUtilisateur();
			String mdp = fc.getMdp();
			try {
				CictOracleDataSource.creerAcces(login, mdp);
				Fenetre_Accueil fa = new Fenetre_Accueil();
				fa.setVisible(true);
				this.fc.dispose();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(fc, "Login ou mot de passe incorrect", "Erreur",
						JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
			break;
		case "Annuler":
			this.fc.dispose();
		}
	}
	
}
