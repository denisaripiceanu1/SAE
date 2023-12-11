package modele.dao;

import java.sql.CallableStatement;
import java.sql.SQLException;

public interface SousProgramme<T> {

    String appelSousProgramme();

    void parametres(CallableStatement prSt, String... parametres) throws SQLException;
}
