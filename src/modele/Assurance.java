package modele;

public class Assurance {

	private String numéroPolice;
	private float montant;
	private Bien bien;
	private Entreprise entreprise;

	public Assurance(String numéroPolice, float montantInit, Bien bien, Entreprise entreprise) {
		this.numéroPolice = numéroPolice;
		this.montant = montantInit;
		this.bien = bien;
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

	public Bien getImmeuble() {
		return this.bien;
	}

	public void setImmeuble(Bien bien) {
		this.bien = bien;
	}
}
