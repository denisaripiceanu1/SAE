package modele.dao.requetes.sousProgramme;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Bien;
import modele.Locataire;
import modele.Louer;

/**
 * Classe représentant un sous-programme SQL pour supprimer une location.
 *
 * @param locataire Locataire associé à la location.
 * @param bien      Bien associé à la location.
 * @param dateDebut Date de début de la location.
 */
public class SousProgrammeDeleteLocation implements SousProgramme<Louer> {

    private Locataire locataire;
    private Bien bien;
    private String dateDebut;

    /**
     * Constructeur prenant en paramètre le locataire, le bien et la date de début de la location.
     *
     * @param locataire Locataire associé à la location.
     * @param bien      Bien associé à la location.
     * @param dateDebut Date de début de la location.
     */
    public SousProgrammeDeleteLocation(Locataire locataire, Bien bien, String dateDebut) {
        this.locataire = locataire;
        this.bien = bien;
        this.dateDebut = dateDebut;
    }

    /**
     * Retourne l'appel du sous-programme SQL sous forme de chaîne de caractères.
     *
     * @return Appel du sous-programme SQL.
     */
    @Override
    public String appelSousProgramme() {
        return "{call DETRUIREBien(?, ?, ?, ?)}";
    }

    /**
     * Paramètre la PreparedStatement avec les valeurs fournies dans le tableau de chaînes de caractères.
     *
     * @param prSt      PreparedStatement à paramétrer.
     * @param parametres Tableau de chaînes de caractères contenant les valeurs à paramétrer.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, String... parametres) throws SQLException {
        prSt.setString(1, locataire.toString());
        prSt.setString(2, bien.toString());

        java.sql.Date dateDebut = ((CallableStatement) prSt).getDate("date_debut");
        prSt.setDate(3, dateDebut);
    }

    /**
     * Paramètre la PreparedStatement avec les valeurs de l'entité donnée.
     *
     * @param prSt   PreparedStatement à paramétrer.
     * @param donnee Objet représentant l'entité pour laquelle les paramètres doivent être définis.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, Louer donnee) throws SQLException {
        // TODO Auto-generated method stub
    }

    /**
     * Paramètre la PreparedStatement avec les valeurs de l'entité donnée pour les requêtes sur les séquences.
     *
     * @param prSt   CallableStatement à paramétrer.
     * @param donnee Objet représentant l'entité pour laquelle les paramètres de séquence doivent être définis.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametresSequence(CallableStatement prSt, Louer donnee) throws SQLException {
        // TODO Auto-generated method stub
    }

    /**
     * Paramètre la PreparedStatement avec les valeurs de l'entité donnée pour les calculs spécifiques.
     *
     * @param st     CallableStatement à paramétrer.
     * @param donnees Objet représentant l'entité pour laquelle les paramètres de calcul doivent être définis.
     */
    @Override
    public void parametresCalcul(CallableStatement st, Louer donnees) {
        // TODO Auto-generated method stub
    }
}

