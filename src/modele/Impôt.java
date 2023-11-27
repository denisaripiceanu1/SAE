package modele;

public class Impôt {

	private int idImpot;
	private String nom;
	private double montant;
	private Bien bien;

	public Impôt(int idImpot, String nom, double montant, Bien bien) {
		this.idImpot = idImpot;
		this.nom = nom;
		this.montant = montant;
		this.bien = bien;
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

	public Bien getIdBien() {
		return bien;
	}

	public void setIdBien(Bien bien) {
		this.bien = bien;
	}

}
