package modele;

public class MoyenneLoyer {

	private String locataire;
	private int loyer;

	public MoyenneLoyer(String locataire, int loyer) {
		super();
		this.locataire = locataire;
		this.loyer = loyer;
	}

	public String getLocataire() {
		return locataire;
	}

	public int getLoyer() {
		return loyer;
	}

}
