package modele;

public class Echeance {

	private Assurance numeroPolice;
	private String dateEcheance;

	public Echeance(Assurance numeroPolice, String dateEcheance) {
		this.numeroPolice = numeroPolice;
		this.dateEcheance = dateEcheance;
	}

	public Assurance getAssurance() {
		return numeroPolice;
	}

	public String getDateEcheance() {
		return dateEcheance;
	}

	public void setNumeroPolice(Assurance numeroPolice) {
		this.numeroPolice = numeroPolice;
	}

	public void setDateEcheance(String dateEcheance) {
		this.dateEcheance = dateEcheance;
	}

}
