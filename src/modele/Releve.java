package modele;

public class Releve {
	
	private Compteur compteur;
	private String date_releve;
	private double indexComp;
	
	public Releve(Compteur compteur, String date_releve, double indexComp) {
		super();
		this.compteur = compteur;
		this.date_releve = date_releve;
		this.indexComp = indexComp;
	}

	public Compteur getCompteur() {
		return compteur;
	}

	public void setCompteur(Compteur compteur) {
		this.compteur = compteur;
	}

	public String getDate_releve() {
		return date_releve;
	}

	public void setDate_releve(String date_releve) {
		this.date_releve = date_releve;
	}

	public double getIndexComp() {
		return indexComp;
	}

	public void setIndexComp(double indexComp) {
		this.indexComp = indexComp;
	}
	
	
	
}
