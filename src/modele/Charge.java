package modele;

public class Charge {
	
    private int idCharge;
    private String nom;
    private double montantReel;
    private double montantPrevisionnel;
    private boolean deductible;
    private Bien idBien;
    
	public Charge(int idCharge, String nom, double montantReel, double montantPrevisionnel, boolean deductible,
			Bien idBien) {

		this.idCharge = idCharge;
		this.nom = nom;
		this.montantReel = montantReel;
		this.montantPrevisionnel = montantPrevisionnel;
		this.deductible = deductible;
		this.idBien = idBien;
	}

	public int getIdCharge() {
		return idCharge;
	}

	public void setIdCharge(int idCharge) {
		this.idCharge = idCharge;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getMontantReel() {
		return montantReel;
	}

	public void setMontantReel(double montantReel) {
		this.montantReel = montantReel;
	}

	public double getMontantPrevisionnel() {
		return montantPrevisionnel;
	}

	public void setMontantPrevisionnel(double montantPrevisionnel) {
		this.montantPrevisionnel = montantPrevisionnel;
	}

	public boolean isDeductible() {
		return deductible;
	}

	public void setDeductible(boolean deductible) {
		this.deductible = deductible;
	}

	public Bien getIdBien() {
		return idBien;
	}

	public void setIdBien(Bien idBien) {
		this.idBien = idBien;
	}
}    