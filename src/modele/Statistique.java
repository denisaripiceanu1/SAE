package modele;

import java.util.List;

public class Statistique {

	public static double calculerMoyenne(List<Double> donnees) {
		if (donnees == null || donnees.isEmpty()) {
			throw new IllegalArgumentException("La liste de données ne peut pas être vide ou nulle.");
		}

		double somme = 0.0;
		for (double valeur : donnees) {
			somme += valeur;
		}

		return somme / donnees.size();
	}

	public static double calculerMediane(List<Double> donnees) {
		if (donnees == null || donnees.isEmpty()) {
			throw new IllegalArgumentException("La liste de données ne peut pas être vide ou nulle.");
		}

		int taille = donnees.size();
		donnees.sort(null);

		if (taille % 2 == 0) {
			int index1 = taille / 2 - 1;
			int index2 = taille / 2;
			return (donnees.get(index1) + donnees.get(index2)) / 2.0;
		} else {
			return donnees.get(taille / 2);
		}
	}
}
