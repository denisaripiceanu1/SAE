package modele;

public class Compteur {
    private String idCompteur;
    private String typeComp;
    private float prix_abonnement;

    
    public Compteur(String idCompteur, String typeComp, float prix_abonnement) {
        this.idCompteur = idCompteur;
        this.typeComp = typeComp;
        this.prix_abonnement = prix_abonnement;
    }

    public String getIdCompteur() {
        return idCompteur;
    }

    public void setIdCompteur(String idCompteur) {
        this.idCompteur = idCompteur;
    }

    public float getIndexComp() {
        return prix_abonnement;
    }

    public void setIndexComp(float prix_abonnement) {
        this.prix_abonnement = prix_abonnement;
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
                ", indexComp=" + prix_abonnement +
                ", typeComp='" + typeComp + '\'' +
                '}';
    }
}
