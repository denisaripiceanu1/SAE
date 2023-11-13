package modele;

import java.util.Date;

public class Locataire {

    private String idLocataire;
    private String nom;
    private String prenom;
    private String telephone;
    private String mail;
    private Date dateNaissance;

    
    public Locataire(String idLocataire, String nom, String prenom, String telephone, String mail, Date dateNaissance) {
        this.idLocataire = idLocataire;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.mail = mail;
        this.dateNaissance = dateNaissance;
    }

    
}