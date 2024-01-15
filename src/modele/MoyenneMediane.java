package modele;

public class MoyenneMediane {
	private double moyenne;
	private double mediane;

	public MoyenneMediane(double moyenne, double mediane) {
		super();
		this.moyenne = moyenne;
		this.mediane = mediane;
	}

	public String getMoyenne() {
		return String.valueOf(moyenne);
	}

	public void setMoyenne(double moyenne) {
		this.moyenne = moyenne;
	}

	public String getMediane() {
		return String.valueOf(mediane);
	}

	public void setMediane(double mediane) {
		this.mediane = mediane;
	}

}
