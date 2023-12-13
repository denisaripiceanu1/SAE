package modele;

public class Charge {

	// private int idCharge;
	private String nom;
	private double montantReel;
	private double montantPrevisionnel;
	private int deductible;
	private Bien idBien;

	public Charge(String nom, double montantReel, double montantPrevisionnel, int deductible, Bien idBien) {

		// this.idCharge = idCharge;
		this.nom = nom;
		this.montantReel = montantReel;
		this.montantPrevisionnel = montantPrevisionnel;
		this.deductible = deductible;
		this.idBien = idBien;
	}

	/*
	 * public int getIdCharge() { return this.idCharge; }
	 * 
	 * public void setIdCharge(int idCharge) { this.idCharge = idCharge; }
	 */

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getMontantReel() {
		return this.montantReel;
	}

	public void setMontantReel(double montantReel) {
		this.montantReel = montantReel;
	}

	public double getMontantPrevisionnel() {
		return this.montantPrevisionnel;
	}

	public void setMontantPrevisionnel(double montantPrevisionnel) {
		this.montantPrevisionnel = montantPrevisionnel;
	}

	public int isDeductible() {
		return this.deductible;
	}

	public void setDeductible(int deductible) {
		this.deductible = deductible;
	}

	public Bien getBien() {
		return this.idBien;
	}

	public void setBien(Bien idBien) {
		this.idBien = idBien;
	}
}