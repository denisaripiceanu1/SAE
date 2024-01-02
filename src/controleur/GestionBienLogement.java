package controleur;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controleur.outils.Sauvegarde;
import modele.Bien;
import modele.Immeuble;
import modele.dao.CictOracleDataSource;
import modele.dao.DaoBien;
import modele.dao.DaoImmeuble;
import modele.dao.requetes.VerificationOccupation;
import vue.Fenetre_Accueil;

public class GestionBienLogement implements ListSelectionListener {

	private Fenetre_Accueil fenetreAccueil;
	private DaoImmeuble daoImmeuble;
	private DaoBien daoBien;
	private VerificationOccupation verificationOccupation;

	public GestionBienLogement(Fenetre_Accueil fenetreAccueil) {
		this.fenetreAccueil = fenetreAccueil;
		this.daoImmeuble = new DaoImmeuble();
		this.daoBien = new DaoBien();
		this.verificationOccupation = new VerificationOccupation(CictOracleDataSource.getConnectionBD());
		Sauvegarde.initializeSave();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int selectedRow = fenetreAccueil.getTableBiens().getSelectedRow();

			if (selectedRow > -1) {
				JTable tableBiens = fenetreAccueil.getTableBiens();
				Immeuble immeuble = null;
				try {
					// On peut enlever les deux autres paramètres ci-dessous
					immeuble = daoImmeuble.findById(tableBiens.getValueAt(selectedRow, 0).toString(),
							tableBiens.getValueAt(selectedRow, 1).toString(),
							tableBiens.getValueAt(selectedRow, 2).toString());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				if (immeuble != null) {
					// Ajout de l'immeuble qui concerne les logements dans le tableau pour pouvoir
					// en ajouter un
					Sauvegarde.deleteItem("Logement");
					Sauvegarde.deleteItem("Immeuble");
					Sauvegarde.addItem("Immeuble", immeuble);

					List<Bien> biens = null;
					try {
						biens = daoBien.findBiensparImmeuble(immeuble.getImmeuble());
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

					JTable logements = fenetreAccueil.getTableLogementsParBien();
					GestionAccueil.viderTable(logements);

					// Déselectionner la ligne de la table logement quand on change de bien
					logements.clearSelection();

					DefaultTableModel model = (DefaultTableModel) logements.getModel();

					int numColonnes = 6; // Nombre de colonnes
					int numLignesNecessaires = biens.size(); // Nombre de lignes
					int numLigneActuel = model.getRowCount();

					for (int i = 0; i < numLignesNecessaires - numLigneActuel; i++) {
						model.addRow(new Object[numColonnes]);
					}

					// Remplissage du tableau de logements
					for (int i = 0; i < biens.size(); i++) {
						Bien bien = biens.get(i);
						if (bien != null) {
							String nom = bien.getIdBien();
							double surface = bien.getSurfaceHabitable();
							int nbPieces = bien.getNbPieces();
							int etage = bien.getNumEtage();
							// Format date using SimpleDateFormat
					        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
					        String date = dateFormat.format(Date.valueOf(bien.getDateAcquisition()));

							// Utiliser la méthode estLoue pour vérifier si le logement est loué
							boolean estLoue = false;
							try {
								estLoue = verificationOccupation.estLoue(bien.getIdBien());
							} catch (SQLException e1) {
								e1.printStackTrace();
							}

							// Condition pour déterminer la valeur de la variable occupe
							String occupe;
							if (estLoue) {
								occupe = "Oui";
							} else {
								occupe = "Non";
							}

							model.setValueAt(nom, i, 0);
							model.setValueAt(surface, i, 1);
							model.setValueAt(nbPieces, i, 2);
							model.setValueAt(etage, i, 3);
							model.setValueAt(date, i, 4);
							model.setValueAt(occupe, i, 5);
						}
					}
				}
			}
		}
	}
}
