package modele.dao.requetes.sousProgramme;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface SousProgramme<T> {

    String appelSousProgramme();

    void parametres(PreparedStatement prSt, String... parametres) throws SQLException;
    
    
    void parametres(PreparedStatement prSt, T donnee) throws SQLException;
    
    //Méthode utile pour les requêtes sur les séquences
    void parametres(PreparedStatement prSt, T donnee, int Sequence) throws SQLException;
    
    
    
    
}
