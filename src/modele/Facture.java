package modele;

public class Facture {

	private int idFacture;
	private String numero;
	private String dateEmission;
	private String datePaiement;
	private String modePaiement;
	private String numeroDevis;
	private String designation;
	private double accompteVerse;
	private int imputableLocataire;
	private Immeuble immeuble;
	private Bien bien;
	private Entreprise entreprise;


	public Facture(int idFacture, String numero, String dateEmission, String datePaiement, String modePaiement,
			String numeroDevis, String designation, double accompteVerse,int imputableLocataire,
			Immeuble immeuble, Bien bien, Entreprise entreprise) {
		this.idFacture = idFacture;
		this.numero = numero;
		this.dateEmission = dateEmission;
		this.datePaiement = datePaiement;
		this.modePaiement = modePaiement;
		this.numeroDevis = numeroDevis;
		this.designation = designation;
		this.accompteVerse = accompteVerse;
		this.imputableLocataire = imputableLocataire;
		this.immeuble = immeuble;
		this.bien = bien;
		this.entreprise = entreprise;
	}

	public int getIdFacture() {
		return idFacture;
	}

	public void setIdFacture(int idFacture) {
		this.idFacture = idFacture;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDateEmission() {
		return dateEmission;
	}

	public void setDateEmission(String dateEmission) {
		this.dateEmission = dateEmission;
	}

	public String getDatePaiement() {
		return datePaiement;
	}

	public void setDatePaiement(String datePaiement) {
		this.datePaiement = datePaiement;
	}

	public String getModePaiement() {
		return modePaiement;
	}

	public void setModePaiement(String modePaiement) {
		this.modePaiement = modePaiement;
	}

	public String getNumeroDevis() {
		return numeroDevis;
	}

	public void setNumeroDevis(String numeroDevis) {
		this.numeroDevis = numeroDevis;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getAccompteVerse() {
		return accompteVerse;
	}

	public void setAccompteVerse(double accompteVerse) {
		this.accompteVerse = accompteVerse;
	}

	public int getImputableLocataire() {
		return imputableLocataire;
	}

	public void setImputableLocataire(int imputableLocataire) {
		this.imputableLocataire = imputableLocataire;
	}

	public Immeuble getImmeuble() {
		return immeuble;
	}

	public void setImmeuble(Immeuble immeuble) {
		this.immeuble = immeuble;
	}

	public Bien getBien() {
		return bien;
	}

	public void setBien(Bien bien) {
		this.bien = bien;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
}
