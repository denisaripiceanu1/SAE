package modele.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.Bien;
import modele.Immeuble;
import modele.Quotite;
import modele.Quotter;
import modele.dao.requetes.delete.RequeteDeleteQuotter;
import modele.dao.requetes.delete.RequeteDeleteQuotterByImmeuble;
import modele.dao.requetes.select.RequeteSelectBienparImmeuble;
import modele.dao.requetes.select.RequeteSelectQuotter;
import modele.dao.requetes.select.RequeteSelectQuotterByBien;
import modele.dao.requetes.select.RequeteSelectQuotterById;
import modele.dao.requetes.sousProgramme.SousProgramme;
import modele.dao.requetes.sousProgramme.SousProgrammeInsertQuotter;

/**
 * DAO (Data Access Object) pour l'entité Quotter.
 * Gère l'accès aux données relatives à l'entité Quotter dans la base de données.
 */
public class DaoQuotter extends DaoModele<Quotter> implements Dao<Quotter> {

    /**
     * Crée une nouvelle instance de Quotter dans la base de données.
     *
     * @param donnees Données de la Quotter à créer.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    @Override
    public void create(Quotter donnees) throws SQLException {
        SousProgramme<Quotter> sp = new SousProgrammeInsertQuotter();
        CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sp.appelSousProgramme());
        sp.parametres(st, donnees);
        st.execute();
        st.close();
    }

    /**
     * Met à jour les informations d'une Quotter dans la base de données.
     *
     * @param donnees Données de la Quotter à mettre à jour.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    @Override
    public void update(Quotter donnees) throws SQLException {
        // TODO: Implémenter la mise à jour des Quotters dans la base de données.
    }

    /**
     * Supprime une Quotter de la base de données.
     *
     * @param donnees Données de la Quotter à supprimer.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    @Override
    public void delete(Quotter donnees) throws SQLException {
        this.miseAJour(new RequeteDeleteQuotter(), donnees);
    }

    /**
     * Crée une instance de Quotter à partir du curseur SQL.
     *
     * @param curseur Résultat de la requête SQL.
     * @return Une instance de Quotter.
     * @throws SQLException Si une erreur SQL survient lors de la création de l'instance.
     */
    @Override
    protected Quotter creerInstance(ResultSet curseur) throws SQLException {
        Quotter quotter = null;
        try {
            String idBien = curseur.getString("Id_Bien");
            DaoBien daoBien = new DaoBien();
            Bien bien = daoBien.findById(idBien);

            String typeQ = curseur.getString("Type_quotite");
            DaoQuotite daoQuotite = new DaoQuotite();
            Quotite quotite = daoQuotite.findById(typeQ);

            quotter = new Quotter(bien, quotite, curseur.getDouble("pourcentage"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return quotter;
    }

    /**
     * Recherche une Quotter dans la base de données par son identifiant.
     *
     * @param id Identifiant de la Quotter à rechercher.
     * @return L'instance de Quotter correspondante à l'identifiant, ou null si non trouvée.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    @Override
    public Quotter findById(String... id) throws SQLException {
        List<Quotter> quotter = this.find(new RequeteSelectQuotterById(), id);
        if (quotter.isEmpty()) {
            return null;
        }
        return quotter.get(0);
    }

    /**
     * Récupère toutes les instances de Quotter présentes dans la base de données.
     *
     * @return Liste des instances de Quotter.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    @Override
    public List<Quotter> findAll() throws SQLException {
        return this.find(new RequeteSelectQuotter());
    }

    /**
     * Récupère toutes les instances de Quotter associées à un Bien spécifique.
     *
     * @param id Identifiant du Bien.
     * @return Liste des instances de Quotter associées au Bien spécifié.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public List<Quotter> findQuotterByBien(String id) throws SQLException {
        return this.find(new RequeteSelectQuotterByBien(), id);
    }

    /**
     * Supprime toutes les instances de Quotter associées à un Immeuble de la base de données.
     *
     * @param immeuble Immeuble pour lequel supprimer les Quotters.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public void deleteByBien(Immeuble immeuble) throws SQLException {
        RequeteDeleteQuotterByImmeuble requete = new RequeteDeleteQuotterByImmeuble();

        try (PreparedStatement st = CictOracleDataSource.getConnectionBD()
                .prepareStatement(new RequeteSelectBienparImmeuble().requete())) {

            requete.parametres(st, immeuble.getImmeuble());
            st.executeUpdate();

        }

    }
}
