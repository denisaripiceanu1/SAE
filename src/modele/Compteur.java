package modele;

public class Compteur {
    private int idCompteur;
    private long indexComp;
    private String typeComp;

    
    public Compteur(int idCompteur, long indexComp, String typeComp) {
        this.idCompteur = idCompteur;
        this.indexComp = indexComp;
        this.typeComp = typeComp;
    }

    // Getter pour Id_Compteur
    public int getIdCompteur() {
        return idCompteur;
    }

    // Setter pour Id_Compteur
    public void setIdCompteur(int idCompteur) {
        this.idCompteur = idCompteur;
    }

    // Getter pour indexComp
    public long getIndexComp() {
        return indexComp;
    }

    // Setter pour indexComp
    public void setIndexComp(long indexComp) {
        this.indexComp = indexComp;
    }

    // Getter pour typeComp
    public String getTypeComp() {
        return typeComp;
    }

    // Setter pour typeComp
    public void setTypeComp(String typeComp) {
        this.typeComp = typeComp;
    }

    @Override
    public String toString() {
        return "Compteur{" +
                "idCompteur=" + idCompteur +
                ", indexComp=" + indexComp +
                ", typeComp='" + typeComp + '\'' +
                '}';
    }
}
