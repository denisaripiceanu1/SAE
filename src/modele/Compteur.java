package modele;

public class Compteur {
	private String idCompteur;
	private String typeComp;
	private int prix_abonnement; //fixé par défaut ?
	private Bien bien;
	private Immeuble immeuble;

	public Compteur(String idCompteur, String typeComp,int prix_abonnement,Bien bien, Immeuble immeuble) {
		this.idCompteur = idCompteur;
		this.typeComp = typeComp;
		this.prix_abonnement = prix_abonnement;
		this.bien = bien;
		this.immeuble = immeuble;
	}

	public String getIdCompteur() {
		return idCompteur;
	}

	public void setIdCompteur(String idCompteur) {
		this.idCompteur = idCompteur;
	}

	public String getTypeComp() {
		return typeComp;
	}

	public void setTypeComp(String typeComp) {
		this.typeComp = typeComp;
	}

	public int getPrix_abonnement() {
		return prix_abonnement;
	}

	public void setPrix_abonnement(int prix_abonnement) {
		this.prix_abonnement = prix_abonnement;
	}

	public Bien getBien() {
		return bien;
	}

	public void setBien(Bien bien) {
		this.bien = bien;
	}

	public Immeuble getImmeuble() {
		return immeuble;
	}

	public void setImmeuble(Immeuble immeuble) {
		this.immeuble = immeuble;
	}

}
