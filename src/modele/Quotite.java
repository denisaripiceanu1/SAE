package modele;

public class Quotite {

	private String type_quotite;
	private Quotter pourcentage;

	public Quotite(String type_quotite, Quotter pourcentage) {
		this.type_quotite = type_quotite;
		this.pourcentage = pourcentage;

	}

	public Quotter getPourcentage() {
		return this.pourcentage;
	}

	public void setPourcentage(Quotter pourcentage) {
		this.pourcentage = pourcentage;
	}

	public String getType_quotite() {
		return this.type_quotite;
	}

	public void setType_quotite(String type_quotite) {
		this.type_quotite = type_quotite;
	}

}
