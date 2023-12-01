package modele;

public class Immeuble {

	private String idImmeuble;
	private String adresse;
	private String cp;
	private String ville;
	private String periodeConstruction;
	private int nbLogement;
	private String dateAcquisition;

	public Immeuble(String idImmeuble, String adresse, String cp, String ville, String periodeConstruction,
			int nbLogement, String dateAcquisition) {
		this.idImmeuble = idImmeuble;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		this.periodeConstruction = periodeConstruction;
		this.nbLogement = nbLogement;
		this.dateAcquisition = dateAcquisition;
	}

	public String getImmeuble() {
		return idImmeuble;
	}

	public void setImmeuble(String immeuble) {
		this.idImmeuble = immeuble;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPeriodeConstruction() {
		return periodeConstruction;
	}

	public void setPeriodeConstruction(String periodeConstruction) {
		this.periodeConstruction = periodeConstruction;
	}

	public int getNbLogement() {
		return nbLogement;
	}

	public void setNbLogement(int nbLogement) {
		this.nbLogement = nbLogement;
	}

	public String getDateAcquisition() {
		return dateAcquisition;
	}

	public void setDateAcquisition(String dateAcquisition) {
		this.dateAcquisition = dateAcquisition;
	}

}
