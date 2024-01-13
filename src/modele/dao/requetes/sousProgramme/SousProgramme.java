package modele.dao.requetes.sousProgramme;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Louer;

public interface SousProgramme<T> {

    String appelSousProgramme();

    void parametres(PreparedStatement prSt, String... parametres) throws SQLException;
    
    
    void parametres(PreparedStatement prSt, T donnee) throws SQLException;
    
    //Méthode utile pour les requêtes sur les séquences
    void parametres(PreparedStatement prSt, T donnee, int Sequence) throws SQLException;

	void parametresCalcul(CallableStatement st, Louer donnees) throws SQLException;
    
    
    
    
}
