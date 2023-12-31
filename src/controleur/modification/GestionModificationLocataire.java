package controleur.modification;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import controleur.outils.Sauvegarde;
import modele.Locataire;
import modele.dao.DaoLocataire;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_AffichageInfoLocataire;

public class GestionModificationLocataire implements ActionListener {

    private Fenetre_AffichageInfoLocataire modificationLocataire;
    private DaoLocataire daoLocataire;

    public GestionModificationLocataire(Fenetre_AffichageInfoLocataire modificationLocataire) {
        this.modificationLocataire = modificationLocataire;
        this.daoLocataire = new DaoLocataire();
        Sauvegarde.initializeSave();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();

        switch (btn.getText()) {
            case "Modifier":
                modifierLocataire();
                break;
            case "Retour":
                this.modificationLocataire.dispose();
                break;
        }
    }

    private void modifierLocataire() {
        Locataire locataire = creerLocataireAPartirDesChamps();
        try {
            this.daoLocataire.update(locataire);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.modificationLocataire.dispose();
    }

    private Locataire creerLocataireAPartirDesChamps() {
        Locataire locataire = new Locataire(
                this.modificationLocataire.getTextField_Id().getText(),
                this.modificationLocataire.getTextField_Nom().getText(),
                this.modificationLocataire.getTextField_Prenom().getText(),
                this.modificationLocataire.getTextField_Telephone().getText(),
                this.modificationLocataire.getTextField_Mail().getText(),
                this.modificationLocataire.getTextField_DateN().getText());
        return locataire;
    }
}
