package modele.dao;

import modele.dao.requetes.Requete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe abstraite générique servant de modèle pour les objets d'accès aux données (DAO).
 *
 * @param <T> Type d'objet métier associé au DAO.
 */
public abstract class DaoModele<T> implements Dao<T> {

    // Connexion à la base de données
    protected Connection connection;

    /**
     * Méthode abstraite permettant de créer une instance d'objet métier à partir du curseur SQL.
     *
     * @param curseur Résultat de la requête SQL.
     * @return Une instance de l'objet métier.
     * @throws SQLException Si une erreur SQL survient lors de la création de l'instance.
     */
    protected abstract T creerInstance(ResultSet curseur) throws SQLException;

    /**
     * Méthode protégée permettant d'exécuter une requête de sélection.
     *
     * @param prSt PreparedStatement contenant la requête SQL.
     * @return Liste d'instances de l'objet métier résultantes de la requête.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    protected List<T> select(PreparedStatement prSt) throws SQLException {
        ResultSet res = prSt.executeQuery();
        boolean existe = res.next();
        List<T> liste = new ArrayList<>();
        while (existe) {
            liste.add(creerInstance(res));
            existe = res.next();
        }
        res.close();
        return liste;
    }

    /**
     * Méthode protégée permettant d'exécuter une requête de mise à jour.
     *
     * @param requete Requête de mise à jour à exécuter.
     * @param donnee  Instance de l'objet métier contenant les données à mettre à jour.
     * @return Le nombre de lignes mises à jour dans la base de données.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    protected int miseAJour(Requete<T> requete, T donnee) throws SQLException {
        PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(requete.requete());
        requete.parametres(st, donnee);
        int nbLignes = st.executeUpdate();
        st.close();
        return nbLignes; // Nombre de lignes mise à jour
    }

    /**
     * Méthode protégée permettant d'exécuter une requête de recherche.
     *
     * @param requete Requête de recherche à exécuter.
     * @param id      Identifiant(s) nécessaire(s) pour la recherche.
     * @return Liste d'instances de l'objet métier résultantes de la recherche.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    protected List<T> find(Requete<T> requete, String... id) throws SQLException {
        PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(requete.requete());
        requete.parametres(st, id);
        List<T> liste = select(st);
        st.close();
        return liste;
    }

    /**
     * Méthode protégée permettant d'exécuter une requête de recherche par ID.
     *
     * @param req Requête de recherche par ID à exécuter.
     * @param id  Identifiant(s) nécessaire(s) pour la recherche.
     * @return Une instance de l'objet métier trouvée ou null si non trouvée.
     * @throws SQLException Si une erreur SQL survient lors de l'exécution de la requête.
     */
    public T findById(Requete<T> req, String... id) throws SQLException {
        PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(req.requete());
        req.parametres(st, id);
        st.close();
        List<T> liste = find(req, id);
        if (liste.isEmpty()) {
            return null;
        }
        return liste.get(0);
    }
}

