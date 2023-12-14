package modele;

public class Assurance {

	private String numéroPolice;
	private float montant;
	private Immeuble immeuble;
	private Entreprise entreprise;

	public Assurance(String numéroPolice, float montantInit, Immeuble immeuble, Entreprise entreprise) {
		this.numéroPolice = numéroPolice;
		this.montant = montantInit;
		this.immeuble = immeuble;
		this.entreprise = entreprise;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public String getNuméroPolice() {
		return this.numéroPolice;
	}

	public void setNuméroPolice(String numéroPolice) {
		this.numéroPolice = numéroPolice;
	}

	public float getMontantInit() {
		return this.montant;
	}

	public void setMontantInit(float montantInit) {
		this.montant = montantInit;
	}

	public Immeuble getImmeuble() {
		return this.immeuble;
	}

	public void setImmeuble(Immeuble immeuble) {
		this.immeuble = immeuble;
	}
}
