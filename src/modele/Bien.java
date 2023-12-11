package modele;

public class Bien {
	private String idBien;
	private double surfaceHabitable;
	private int nbPieces;
	private int numEtage;
	private String dateAcquisition;
	private String type_bien;
	private Immeuble immeuble;

	public Bien(String idBien, double surfaceHabitable, int nbPieces, int numEtage, String dateAcquisition,
			String type_bien, Immeuble immeuble) {
		this.idBien = idBien;
		this.surfaceHabitable = surfaceHabitable;
		this.nbPieces = nbPieces;
		this.numEtage = numEtage;
		this.dateAcquisition = dateAcquisition;
		this.type_bien = type_bien;
		this.immeuble = immeuble;
	}

	public String getIdBien() {
		return this.idBien;
	}

	public void setIdBien(String idBien) {
		this.idBien = idBien;
	}

	public double getSurfaceHabitable() {
		return this.surfaceHabitable;
	}

	public void setSurfaceHabitable(double surfaceHabitable) {
		this.surfaceHabitable = surfaceHabitable;
	}

	public int getNbPieces() {
		return this.nbPieces;
	}

	public void setNbPieces(int nbPieces) {
		this.nbPieces = nbPieces;
	}

	public int getNumEtage() {
		return this.numEtage;
	}

	public void setNumEtage(int numEtage) {
		this.numEtage = numEtage;
	}

	public String getDateAcquisition() {
		return this.dateAcquisition;
	}

	public void setDateAcquisition(String dateAcquisition) {
		this.dateAcquisition = dateAcquisition;
	}

	public String getType_bien() {
		return this.type_bien;
	}

	public void setType_bien(String type_bien) {
		this.type_bien = type_bien;
	}

	public Immeuble getImmeuble() {
		return this.immeuble;
	}

	public void setImmeuble(Immeuble immeuble) {
		this.immeuble = immeuble;
	}

}
