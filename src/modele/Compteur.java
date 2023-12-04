package modele;

public class Compteur {
	private String idCompteur;
	private String typeComp;
	private Bien bien;
	private Immeuble immeuble;

	public Compteur(String idCompteur, String typeComp, Bien bien, Immeuble immeuble) {
		this.idCompteur = idCompteur;
		this.typeComp = typeComp;
		this.bien = bien;
		this.immeuble = immeuble;
	}

	public String getIdCompteur() {
		return idCompteur;
	}

	public String getTypeComp() {
		return typeComp;
	}

	public Bien getBien() {
		return bien;
	}

	public Immeuble getImmeuble() {
		return immeuble;
	}

	public void setIdCompteur(String idCompteur) {
		this.idCompteur = idCompteur;
	}

	public void setTypeComp(String typeComp) {
		this.typeComp = typeComp;
	}

	public void setBien(Bien bien) {
		this.bien = bien;
	}

	public void setImmeuble(Immeuble immeuble) {
		this.immeuble = immeuble;
	}

}
