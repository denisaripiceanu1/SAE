package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Iterateur<T> implements Iterator<T>{
    private ResultSet rSt;
    private boolean rStNext;
    private DaoModele<T> modele;

    public Iterateur(ResultSet rSt, DaoModele<T> modele) throws SQLException {
        this.modele = modele;
        this.rSt = rSt;
        this.rStNext = rSt.next();
    }

    @Override
    public boolean hasNext() {
        return rStNext;
    }

    @Override
    public T next() throws NoSuchElementException{
        T data = null;
        try {
            data = this.modele.creerInstance(this.rSt);
            this.rStNext = this.rSt.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (data == null) throw new NoSuchElementException();
        return data;
    }

}