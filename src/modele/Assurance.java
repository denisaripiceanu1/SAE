package modele;

public class Assurance {

	private String numéroPolice;
	private float montant;
	private Bien bien;
	private Entreprise entreprise;

	public Assurance(String numéroPolice, float montant, Bien bien, Entreprise entreprise) {
		this.numéroPolice = numéroPolice;
		this.montant = montant;
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

	public float getMontant() {
		return this.montant;
	}

	public void setMontant(float montantInit) {
		this.montant = montantInit;
	}

	public Bien getBien() {
		return this.bien;
	}

	public void setBien(Bien bien) {
		this.bien = bien;
	}
}
