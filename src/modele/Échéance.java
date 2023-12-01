package modele;

public class Échéance {
	
    private String numeroPolice;
    private String dateEcheance;
    private double montantEcheance;
    
	public Échéance(String numeroPolice, String dateEcheance, double montantEcheance) {
		this.numeroPolice = numeroPolice;
		this.dateEcheance = dateEcheance;
		this.montantEcheance = montantEcheance;
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
}
