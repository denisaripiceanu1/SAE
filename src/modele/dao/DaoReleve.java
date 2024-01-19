package modele.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.Compteur;
import modele.Releve;
import modele.dao.requetes.delete.RequeteDeleteReleve;
import modele.dao.requetes.select.RequeteSelectReleve;
import modele.dao.requetes.select.RequeteSelectReleveByCompteur;
import modele.dao.requetes.select.RequeteSelectReleveById;
import modele.dao.requetes.sousProgramme.SousProgramme;
import modele.dao.requetes.sousProgramme.SousProgrammeInsertReleve;

/**
 * DAO (Data Access Object) pour l'entité Releve.
 * Gère l'accès aux données relatives à l'entité Releve dans la base de données.
 */
public class DaoReleve extends DaoModele<Releve> implements Dao<Releve> {

    /**
     * Crée une nouvelle instance de Releve dans la base de données.
     *
     * @param donnees Données du Releve à créer.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    @Override
    public void create(Releve donnees) throws SQLException {
        SousProgramme<Releve> sp = new SousProgrammeInsertReleve();
        CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
        sp.parametres(st, donnees);
        st.execute();
        st.close();
    }

    /**
     * Met à jour les informations d'un Releve dans la base de données.
     *
     * @param donnees Données du Releve à mettre à jour.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    @Override
    public void update(Releve donnees) throws SQLException {
        // TODO: Implémenter la mise à jour des Releves dans la base de données.
    }

    /**
     * Supprime un Releve de la base de données.
     *
     * @param donnees Données du Releve à supprimer.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    @Override
    public void delete(Releve donnees) throws SQLException {
        this.miseAJour(new RequeteDeleteReleve(), donnees);
    }

    /**
     * Crée une instance de Releve à partir du curseur SQL.
     *
     * @param curseur Résultat de la requête SQL.
     * @return Une instance de Releve.
     * @throws SQLException Si une erreur SQL survient lors de la création de l'instance.
     */
    @Override
    protected Releve creerInstance(ResultSet curseur) throws SQLException {
        Releve releve = null;
        try {
            String idCompteur = curseur.getString("Id_Compteur");
            DaoCompteur daoCompteur = new DaoCompteur();
            Compteur compteur = daoCompteur.findById(idCompteur);

            releve = new Releve(compteur, curseur.getString("date_relevé"), curseur.getDouble("indexComp"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return releve;
    }

    /**
     * Recherche un Releve dans la base de données par son identifiant.
     *
     * @param id Identifiant du Releve à rechercher.
     * @return L'instance de Releve correspondante à l'identifiant, ou null si non trouvée.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    @Override
    public Releve findById(String... id) throws SQLException {
        List<Releve> releve = this.find(new RequeteSelectReleveById(), id);
        if (releve.isEmpty()) {
            return null;
        }
        return releve.get(0);
    }

    /**
     * Récupère toutes les instances de Releve présentes dans la base de données.
     *
     * @return Liste des instances de Releve.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    @Override
    public List<Releve> findAll() throws SQLException {
        return this.find(new RequeteSelectReleve());
    }

    /**
     * Récupère toutes les instances de Releve associées à un Compteur spécifique.
     *
     * @param id Identifiant du Compteur.
     * @return Liste des instances de Releve associées au Compteur spécifié.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public List<Releve> findReleveByCompteur(String id) throws SQLException {
        return this.find(new RequeteSelectReleveByCompteur(), id);
    }
}
