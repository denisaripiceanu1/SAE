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

    public int getIdCompteur() {
        return idCompteur;
    }

    public void setIdCompteur(int idCompteur) {
        this.idCompteur = idCompteur;
    }

    public long getIndexComp() {
        return indexComp;
    }

    public void setIndexComp(long indexComp) {
        this.indexComp = indexComp;
    }

    public String getTypeComp() {
        return typeComp;
    }

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
