package modele;

public class Echeance {

	private Assurance numeroPolice; //anciennement String : DOIT ETRE DE TYPE ASSURANCE !!!!!!!!!
	private String dateEcheance;

	public Echeance(Assurance numeroPolice, String dateEcheance) {
		this.numeroPolice = numeroPolice;
		this.dateEcheance = dateEcheance;
	}

	public Assurance getAssurance() {
		return numeroPolice;
	}

	public void setAssurance(Assurance numeroPolice) {
		this.numeroPolice = numeroPolice;
	}

	public String getDateEcheance() {
		return dateEcheance;
	}

	public void setDateEcheance(String dateEcheance) {
		this.dateEcheance = dateEcheance;
	}
}
