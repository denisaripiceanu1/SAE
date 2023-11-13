package modele;

public class Quotite {

	private Bien bien;
    private String typeQuotite;
    private double pourcentage;
	public Quotite(Bien bien, String typeQuotite, double pourcentage) {
		this.bien = bien;
		this.typeQuotite = typeQuotite;
		this.pourcentage = pourcentage;
	}
	public Bien getIdBien() {
		return bien;
	}
	public void setIdBien(Bien idBien) {
		this.bien = idBien;
	}
	public String getTypeQuotite() {
		return typeQuotite;
	}
	public void setTypeQuotite(String typeQuotite) {
		this.typeQuotite = typeQuotite;
	}
	public double getPourcentage() {
		return pourcentage;
	}
	public void setPourcentage(double pourcentage) {
		this.pourcentage = pourcentage;
	}

    
}
