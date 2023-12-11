package modele;

public class Quotite {

	private String type_quotite;

	public Quotite(String type_quotite, Quotter pourcentage) {
		this.type_quotite = type_quotite;
	}

	public String getType_quotite() {
		return this.type_quotite;
	}

	public void setType_quotite(String type_quotite) {
		this.type_quotite = type_quotite;
	}

}
