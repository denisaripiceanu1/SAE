package modele.dao.requetes.select;

public class RequeteSelectAssuranceByLogement extends RequeteSelectAssurance {

    @Override
    public String requete() {
        return super.requete() + " WHERE Id_Immeuble = ?";
    }
}
