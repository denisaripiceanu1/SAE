package modele;
public class Assurance {

	private String numéroPolice;
	private int montantInit;
	private Immeuble immeuble;
	
	public Assurance(String numéroPolice, int montantInit, Immeuble immeuble) {
		this.numéroPolice = numéroPolice;
		this.montantInit = montantInit;
		this.immeuble = immeuble;
	}

	public String getNuméroPolice() {
		return numéroPolice;
	}

	public void setNuméroPolice(String numéroPolice) {
		this.numéroPolice = numéroPolice;
	}

	public int getMontantInit() {
		return montantInit;
	}

	public void setMontantInit(int montantInit) {
		this.montantInit = montantInit;
	}

	public Immeuble getImmeuble() {
		return immeuble;
	}

	public void setImmeuble(Immeuble immeuble) {
		this.immeuble = immeuble;
	}
}
