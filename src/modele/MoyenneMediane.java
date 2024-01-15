package modele;

import java.text.DecimalFormat;

public class MoyenneMediane {
	private double moyenne;
	private double mediane;

	public MoyenneMediane(double moyenne, double mediane) {
		super();
		this.moyenne = moyenne;
		this.mediane = mediane;
	}

	public String getMoyenne() {
		return arrondir(moyenne);
	}

	public void setMoyenne(double moyenne) {
		this.moyenne = moyenne;
	}

	public String getMediane() {
		return arrondir(mediane);
	}

	public void setMediane(double mediane) {
		this.mediane = mediane;
	}

	public String arrondir(double res) {
		DecimalFormat df = new DecimalFormat("#.##");
		return df.format(res);
	}
}
