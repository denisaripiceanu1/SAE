package modele;

public class Quotter {

	private Bien bien;
	private Quotite typeQuotite;
	private double pourcentage;

	public Quotter(Bien bien, Quotite typeQuotite, double pourcentage) {
		this.bien = bien;
		this.typeQuotite = typeQuotite;
		this.pourcentage = pourcentage;
	}

	public Bien getBien() {
		return bien;
	}

	public void setBien(Bien bien) {
		this.bien = bien;
	}

	public Quotite getTypeQuotite() {
		return typeQuotite;
	}

	public void setTypeQuotite(Quotite typeQuotite) {
		this.typeQuotite = typeQuotite;
	}

	public double getPourcentage() {
		return pourcentage;
	}

	public void setPourcentage(double pourcentage) {
		this.pourcentage = pourcentage;
	}

}
