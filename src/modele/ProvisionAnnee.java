package modele;

public class ProvisionAnnee {
	private String annee;
	private double sommeProvision;

	public ProvisionAnnee(String annee, double sommeProvision) {
		this.annee = annee;
		this.sommeProvision = sommeProvision;
	}

	// Getters
	public String getAnnee() {
		return annee;
	}

	public double getSommeProvision() {
		return sommeProvision;
	}
}
