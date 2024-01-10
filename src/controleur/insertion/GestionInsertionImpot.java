package controleur.insertion;

import modele.dao.DaoAssurance;
import modele.dao.DaoBien;
import modele.dao.DaoEcheance;
import modele.dao.DaoEntreprise;
import vue.insertion.Fenetre_InsertionAssurance;

public class GestionInsertionImpot {

	private Fenetre_InsertionAssurance modificationAssurance;
	private DaoBien daoBien;
	private DaoImpot daoImpot;

	public GestionInsertionAssurance(Fenetre_InsertionAssurance fia) {
		this.modificationAssurance = fia;
		this.daoAssurance = new DaoAssurance();
		this.daoBien = new DaoBien();
		this.daoEntreprise = new DaoEntreprise();
		this.daoEcheance = new DaoEcheance();
	}

}
