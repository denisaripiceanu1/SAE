package modele.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.Quotite;
import modele.dao.requetes.select.RequeteSelectQuotite;
import modele.dao.requetes.select.RequeteSelectQuotiteById;
import modele.dao.requetes.sousProgramme.SousProgramme;
import modele.dao.requetes.sousProgramme.SousProgrammeInsertQuotite;

/**
 * DAO (Data Access Object) pour l'entité Quotite.
 * Gère l'accès aux données relatives à l'entité Quotite dans la base de données.
 */
public class DaoQuotite extends DaoModele<Quotite> implements Dao<Quotite> {

    /**
     * Crée une nouvelle instance de Quotite dans la base de données.
     *
     * @param donnees Données de la Quotite à créer.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    @Override
    public void create(Quotite donnees) throws SQLException {
        SousProgramme<Quotite> sp = new SousProgrammeInsertQuotite();
        CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
        sp.parametres(st, donnees);
        st.execute();
        st.close();
    }

    /**
     * Met à jour les informations d'une Quotite dans la base de données.
     *
     * @param donnees Données de la Quotite à mettre à jour.
     */
    @Override
    public void update(Quotite donnees) {
        // TODO: Implémenter la mise à jour des Quotites dans la base de données.
    }

    /**
     * Supprime une Quotite de la base de données.
     *
     * @param donnees Données de la Quotite à supprimer.
     */
    @Override
    public void delete(Quotite donnees) {
        this.delete(donnees); // TODO: Implémenter la suppression des Quotites dans la base de données.
    }

    /**
     * Recherche une Quotite dans la base de données par son identifiant.
     *
     * @param id Identifiant de la Quotite à rechercher.
     * @return L'instance de Quotite correspondante à l'identifiant, ou null si non trouvée.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    @Override
    public Quotite findById(String... id) throws SQLException {
        List<Quotite> quotites = this.find(new RequeteSelectQuotiteById(), id);
        if (quotites.isEmpty()) {
            return null;
        }
        return quotites.get(0);
    }

    /**
     * Récupère toutes les instances de Quotite présentes dans la base de données.
     *
     * @return Liste des instances de Quotite.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    @Override
    public List<Quotite> findAll() throws SQLException {
        return this.find(new RequeteSelectQuotite());
    }

    /**
     * Crée une instance de Quotite à partir du curseur SQL.
     *
     * @param curseur Résultat de la requête SQL.
     * @return Une instance de Quotite.
     * @throws SQLException Si une erreur SQL survient lors de la création de l'instance.
     */
    @Override
    protected Quotite creerInstance(ResultSet curseur) throws SQLException {
        Quotite quotite = null;
        try {
            quotite = new Quotite(curseur.getString("type_quotite"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return quotite;
    }
}

