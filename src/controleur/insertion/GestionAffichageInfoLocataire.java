package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;

import modele.Locataire;
import modele.dao.CictOracleDataSource;
import modele.dao.requetes.update.RequeteUpdateLocataire;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_AffichageInfoLocataire;

public class GestionAffichageInfoLocataire implements ActionListener {

	private Fenetre_AffichageInfoLocataire fail;

	public GestionAffichageInfoLocataire(Fenetre_AffichageInfoLocataire fail) {
		this.fail = fail;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.fail.getTopLevelAncestor(); 
		
		switch (btn.getText()) {
		case "Modifier":
			Locataire locataire = creationLocataire();
			try {
				updateLocataireBD(locataire);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			break;

		case "Retour":
			this.fail.dispose();
			break;
		}
	}
	
	private Locataire creationLocataire() {
		// on cree un locataire juste pour pouvoir update dans la BD car on a seuelemenet la methode avec le parametre Locataire 
		// On recupere les infos des libellé pour les mettre dans notre locataire
        Locataire locataire = new Locataire(null,null,null,null,null,null);
        locataire.setIdLocataire(this.fail.getTextField_Adresse().getText());
        locataire.setNom(this.fail.getTextField_Nom().getText());
        locataire.setPrenom(this.fail.getTextField_Prenom().getText());
        locataire.setTelephone(this.fail.getTextField_Telephone().getText());
        locataire.setMail(this.fail.getTextField_Mail().getText());
        locataire.setDateNaissance(this.fail.getTextField_DateN().getText());
        locataire.setIdLocataire(this.fail.getTextField_Id().getText());

        return locataire;
	}
	
	private void updateLocataireBD(Locataire locataire) throws SQLException{
		
		RequeteUpdateLocataire updateLocataire = new RequeteUpdateLocataire();
		
		Connection cn = CictOracleDataSource.creerAcces("bnl4835a", "a");
		PreparedStatement prSt = cn.prepareStatement(updateLocataire.requete());
		updateLocataire.parametres(prSt, locataire);
		prSt.executeUpdate();
		prSt.close();
		CictOracleDataSource.deconnecter();
		cn.close();
	}

}
