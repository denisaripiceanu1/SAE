package modele;

public class Louer {

	private Locataire locataire;
	private Bien bien;
	private String dateDebut;
	private int nbMois;
	private double loyerTTC;
	private double cautionTTC;
	private String bail;
	private String dateDepart;
	private int loyerPaye;
	private int colocation;
	private String annee;
	private String trimestre;
	private double montantReelPaye;

	public Louer(Locataire locataire, Bien bien, String dateDebut, int nbMois, double loyerTTC, double cautionTTC,
			String bail, String dateDepart, int loyerPaye, int colocation, double montantReelPaye, String annee,
			String trimestre) {
		this.locataire = locataire;
		this.bien = bien;
		this.dateDebut = dateDebut;
		this.nbMois = nbMois;
		this.loyerTTC = loyerTTC;
		this.cautionTTC = cautionTTC;
		this.bail = bail;
		this.dateDepart = dateDepart;
		this.loyerPaye = loyerPaye;
		this.colocation = colocation;
		this.annee = annee;
		this.trimestre = trimestre;
		this.montantReelPaye = montantReelPaye;
	}

	public Locataire getIdLocataire() {
		return locataire;
	}

	public void setIdLocataire(Locataire idLocataire) {
		this.locataire = idLocataire;
	}

	public Bien getIdBien() {
		return bien;
	}

	public void setIdBien(Bien idBien) {
		this.bien = idBien;
	}

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public int getNbMois() {
		return nbMois;
	}

	public void setNbMois(int nbMois) {
		this.nbMois = nbMois;
	}

	public double getLoyerTTC() {
		return loyerTTC;
	}

	public void setLoyerTTC(double loyerTTC) {
		this.loyerTTC = loyerTTC;
	}

	public double getCautionTTC() {
		return cautionTTC;
	}

	public void setCautionTTC(double cautionTTC) {
		this.cautionTTC = cautionTTC;
	}

	public String getBail() {
		return bail;
	}

	public void setBail(String bail) {
		this.bail = bail;
	}

	public String getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(String dateDepart) {
		this.dateDepart = dateDepart;
	}

	public int getLoyerPaye() {
		return loyerPaye;
	}

	public void setLoyerPaye(int loyerPaye) {
		this.loyerPaye = loyerPaye;
	}

	public int getColocation() {
		return colocation;
	}

	public void setColocation(int colocation) {
		this.colocation = colocation;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public String getTrimestre() {
		return trimestre;
	}

	public void setTrimestre(String trimestre) {
		this.trimestre = trimestre;
	}

	public double getMontantReelPaye() {
		return montantReelPaye;
	}

	public void setMontantReelPaye(double montantReelPaye) {
		this.montantReelPaye = montantReelPaye;
	}

}
