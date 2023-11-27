package modele;

public class Diagnostic {
    private int idDiagnostic;
    private String dateValidite;
    private String typeDiagnostic;
    private Bien bien;
    
	public Diagnostic(int idDiagnostic, String dateValidite, String typeDiagnostic, Bien bien) {
		this.idDiagnostic = idDiagnostic;
		this.dateValidite = dateValidite;
		this.typeDiagnostic = typeDiagnostic;
		this.bien = bien;
	}

	public int getIdDiagnostic() {
		return idDiagnostic;
	}

	public void setIdDiagnostic(int idDiagnostic) {
		this.idDiagnostic = idDiagnostic;
	}

	public String getDateValidite() {
		return dateValidite;
	}

	public void setDateValidite(String dateValidite) {
		this.dateValidite = dateValidite;
	}

	public String getTypeDiagnostic() {
		return typeDiagnostic;
	}

	public void setTypeDiagnostic(String typeDiagnostic) {
		this.typeDiagnostic = typeDiagnostic;
	}

	public Bien getBien() {
		return bien;
	}

	public void setBien(Bien bien) {
		this.bien = bien;
	}

}
