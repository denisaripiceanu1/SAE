package modele;

public class MoyenneMediane {
	private double moyenne;
	private double mediane;

	public MoyenneMediane(double moyenne, double mediane) {
		super();
		this.moyenne = moyenne;
		this.mediane = mediane;
	}

	public double getMoyenne() {
		return moyenne;
	}

	public void setMoyenne(double moyenne) {
		this.moyenne = moyenne;
	}

	public double getMediane() {
		return mediane;
	}

	public void setMediane(double mediane) {
		this.mediane = mediane;
	}

}
