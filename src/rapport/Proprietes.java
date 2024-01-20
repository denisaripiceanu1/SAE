package rapport;

public class Proprietes {
    private String propertyName;
    private String propertyType;
    private String periodeConstruction;
    private String adresse;
    private int nombreLocaux;
    private int sommeLoyers;

    public Proprietes(String propertyName, String propertyType, String periodeConstruction, String adresse, int nombreLocaux, int sommeLoyers) {
        this.propertyName = propertyName;
        this.propertyType = propertyType;
        this.periodeConstruction = periodeConstruction;
        this.adresse = adresse;
        this.nombreLocaux = nombreLocaux;
        this.sommeLoyers = sommeLoyers;
    }

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getPeriodeConstruction() {
		return periodeConstruction;
	}

	public void setPeriodeConstruction(String periodeConstruction) {
		this.periodeConstruction = periodeConstruction;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getNombreLocaux() {
		return nombreLocaux;
	}

	public void setNombreLocaux(int nombreLocaux) {
		this.nombreLocaux = nombreLocaux;
	}

	public int getSommeLoyers() {
		return sommeLoyers;
	}

	public void setSommeLoyers(int sommeLoyers) {
		this.sommeLoyers = sommeLoyers;
	}
    
    
}