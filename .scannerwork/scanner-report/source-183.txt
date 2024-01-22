package modele.dao.requetes.delete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Quotter;
import modele.dao.requetes.Requete;

//Bien = Immeuble dans la BD
/**
 * Requête permettant de supprimer une association de Quotter pour un bien spécifique
 * identifié par l'ID_Bien et un type de quotité spécifique.
 */
public class RequeteDeleteQuotter implements Requete<Quotter> {

    /**
     * Retourne la requête SQL pour supprimer une association de Quotter pour un bien spécifique
     * identifié par l'ID_Bien et un type de quotité spécifique.
     *
     * @return Requête SQL sous forme de chaîne de caractères.
     */
    @Override
    public String requete() {
        return "DELETE FROM QUOTTER WHERE Id_Bien = ? AND type_quotite = ?";
    }

    /**
     * Paramètre la PreparedStatement avec l'identifiant du bien (ID_Bien) et le type de quotité
     * pour effectuer la suppression de l'association Quotter.
     *
     * @param prSt  PreparedStatement à paramétrer.
     * @param id    Identifiants du bien (ID_Bien) et du type de quotité.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, String... id) throws SQLException {
        prSt.setString(1, id[0]); // ID_Bien
        prSt.setString(2, id[1]); // type_quotite
    }

    /**
     * Paramètre la PreparedStatement avec l'objet Quotter contenant le bien et le type de quotité
     * pour effectuer la suppression de l'association Quotter.
     *
     * @param prSt  PreparedStatement à paramétrer.
     * @param donnee Objet Quotter contenant le bien et le type de quotité à supprimer.
     * @throws SQLException Si une erreur SQL survient lors du paramétrage de la requête.
     */
    @Override
    public void parametres(PreparedStatement prSt, Quotter donnee) throws SQLException {
        prSt.setString(1, donnee.getBien().getIdBien());
        prSt.setString(2, donnee.getTypeQuotite().getType_quotite());
    }
}
