package modele;

public class Bien {
	private String idBien;
	private double surfaceHabitable;
	private int nbPieces;
	private int numEtage;
	private String dateAcquisition;
	private Immeuble immeuble;

	public Bien(String idBien, double surfaceHabitable, int nbPieces, int numEtage, String dateAcquisition,
			Immeuble immeuble) {
		this.idBien = idBien;
		this.surfaceHabitable = surfaceHabitable;
		this.nbPieces = nbPieces;
		this.numEtage = numEtage;
		this.dateAcquisition = dateAcquisition;
		this.immeuble = immeuble;
	}

	public String getIdBien() {
		return idBien;
	}

	public void setIdBien(String idBien) {
		this.idBien = idBien;
	}

	public double getSurfaceHabitable() {
		return surfaceHabitable;
	}

	public void setSurfaceHabitable(double surfaceHabitable) {
		this.surfaceHabitable = surfaceHabitable;
	}

	public int getNbPieces() {
		return nbPieces;
	}

	public void setNbPieces(int nbPieces) {
		this.nbPieces = nbPieces;
	}

	public int getNumEtage() {
		return numEtage;
	}

	public void setNumEtage(int numEtage) {
		this.numEtage = numEtage;
	}

	public String getDateAcquisition() {
		return dateAcquisition;
	}

	public void setDateAcquisition(String dateAcquisition) {
		this.dateAcquisition = dateAcquisition;
	}

	public Immeuble getImmeuble() {
		return immeuble;
	}

	public void setImmeuble(Immeuble immeuble) {
		this.immeuble = immeuble;
	}

}
