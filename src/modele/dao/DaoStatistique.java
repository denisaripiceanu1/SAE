package modele.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modele.Statistique;

public class DaoStatistique {

	public double recupererMoyenneLoyers() throws SQLException {
		List<Double> loyers = new ArrayList<>();

		try (Connection cn = CictOracleDataSource.getConnectionBD()) {
			String query = "SELECT loyer_ttc FROM louer";
			try (PreparedStatement statement = cn.prepareStatement(query);
					ResultSet resultSet = statement.executeQuery()) {

				while (resultSet.next()) {
					double montant = resultSet.getDouble("montant");
					loyers.add(montant);
				}
			}
		}

		return Statistique.calculerMoyenne(loyers);
	}
}
