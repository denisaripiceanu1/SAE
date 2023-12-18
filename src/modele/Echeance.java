package modele;

public class Echeance {

	private String numeroPolice;
	private String dateEcheance;

	public Echeance(String numeroPolice, String dateEcheance) {
		this.numeroPolice = numeroPolice;
		this.dateEcheance = dateEcheance;
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
}
