package modele;

public class Échéance {
	
    private String numeroPolice;
    private String dateEcheance;
    private double montantEcheance;
    private Assurance assurance;
    
	public Échéance(String numeroPolice, String dateEcheance, double montantEcheance, Assurance assurance) {
		this.numeroPolice = numeroPolice;
		this.dateEcheance = dateEcheance;
		this.montantEcheance = montantEcheance;
		this.assurance = assurance;
	}

	public String getNumeroPolice() {
		return numeroPolice;
	}

	public void setNumeroPolice(String numeroPolice) {
		this.numeroPolice = numeroPolice;
	}

	public String getDateEcheance() {
		return dateEcheance;
	}

	public void setDateEcheance(String dateEcheance) {
		this.dateEcheance = dateEcheance;
	}

	public double getMontantEcheance() {
		return montantEcheance;
	}

	public void setMontantEcheance(double montantEcheance) {
		this.montantEcheance = montantEcheance;
	}

	public Assurance getAssurance() {
		return assurance;
	}

	public void setAssurance(Assurance assurance) {
		this.assurance = assurance;
	}
}
