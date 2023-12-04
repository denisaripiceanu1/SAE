package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Iterateur<T> implements Iterator<T> {

	private ResultSet resultSet;
	private DaoModele<T> daoModele;
	private boolean hasCurrent; // Indique si le ResultSet a une valeur courante

	// Constructeur
	public Iterateur(ResultSet resultSet, DaoModele<T> daoModele) {
		this.resultSet = resultSet;
		this.daoModele = daoModele;
		try {
			this.hasCurrent = resultSet.next(); // Positionne l'itérateur sur le premier élément
		} catch (SQLException e) {
			throw new RuntimeException("Erreur lors de l'initialisation de l'itérateur", e);
		}
	}

	// Méthode hasNext
	@Override
	public boolean hasNext() {
		return hasCurrent;
	}

	// Méthode next
	@Override
	public T next() {
		try {
			if (!hasNext()) {
				throw new NoSuchElementException("Il n'y a plus d'élément dans l'itérateur");
			}

			// Crée une instance de l'objet attendu en utilisant la méthode creerInstance du
			// dao
			T instance = daoModele.creerInstance(resultSet);

			// Récupère la valeur retournée par la méthode next du ResultSet
			hasCurrent = resultSet.next();

			return instance;
		} catch (SQLException e) {
			// Gérer l'exception appropriée selon vos besoins
			throw new RuntimeException("Erreur lors de l'itération", e);
		}
	}
}
