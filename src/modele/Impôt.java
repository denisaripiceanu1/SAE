package modele;

public class Impôt {

	private int idImpot; // AUTO INCREMENT
	private String nom;
	private double montant;
	private String annee;

	public Impôt(int idImpot, String nom, double montant, String annee) {
		this.idImpot = idImpot;
		this.nom = nom;
		this.montant = montant;
		this.annee = annee;
	}

	public int getIdImpot() {
		return idImpot;
	}

	public void setIdImpot(int idImpot) {
		this.idImpot = idImpot;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

}
