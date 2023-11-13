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
	private double montant;
	private int imputableLocataire;
	private Immeuble immeuble;
	private Bien bien;
	private Entreprise entreprise;
	private Locataire locataire;
	private Bien bien_1;
	private Louer louer;

	public Facture(int idFacture, String numero, String dateEmission, String datePaiement, String modePaiement,
			String numeroDevis, String designation, double accompteVerse, double montant, int imputableLocataire,
			Immeuble immeuble, Bien bien, Entreprise entreprise, Locataire locataire, Bien bien_1, Louer louer) {
		super();
		this.idFacture = idFacture;
		this.numero = numero;
		this.dateEmission = dateEmission;
		this.datePaiement = datePaiement;
		this.modePaiement = modePaiement;
		this.numeroDevis = numeroDevis;
		this.designation = designation;
		this.accompteVerse = accompteVerse;
		this.montant = montant;
		this.imputableLocataire = imputableLocataire;
		this.immeuble = immeuble;
		this.bien = bien;
		this.entreprise = entreprise;
		this.locataire = locataire;
		this.bien_1 = bien_1;
		this.louer = louer;
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

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
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

	public Locataire getLocataire() {
		return locataire;
	}

	public void setLocataire(Locataire locataire) {
		this.locataire = locataire;
	}

	public Bien getBien_1() {
		return bien_1;
	}

	public void setBien_1(Bien bien_1) {
		this.bien_1 = bien_1;
	}

	public Louer getLouer() {
		return louer;
	}

	public void setLouer(Louer louer) {
		this.louer = louer;
	}

}
