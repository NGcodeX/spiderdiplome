package com.spiderdiplome.repository.implement;

import com.spiderdiplome.models.HistoriqueConnexion;
import com.spiderdiplome.repository.dao.HistoriqueConnexionDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistoriqueConnexionDAOImpl implements HistoriqueConnexionDAO {
    private Connection connection;

    public HistoriqueConnexionDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(HistoriqueConnexion historiqueConnexion) {
        String sql = "INSERT INTO HistoriqueConnexion (utilisateurId, dateConnexion, ip, navigateur, systemeExploitation, pays, ville, codePostal, latitude, longitude) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, historiqueConnexion.getUtilisateurId());
            statement.setTimestamp(2, historiqueConnexion.getDateConnexion());
            statement.setString(3, historiqueConnexion.getIp());
            statement.setString(4, historiqueConnexion.getNavigateur());
            statement.setString(5, historiqueConnexion.getSystemeExploitation());
            statement.setString(6, historiqueConnexion.getPays());
            statement.setString(7, historiqueConnexion.getVille());
            statement.setString(8, historiqueConnexion.getCodePostal());
            statement.setDouble(9, historiqueConnexion.getLatitude());
            statement.setDouble(10, historiqueConnexion.getLongitude());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'insertion de l'historique de connexion : " + e.getMessage());
        }
    }

    @Override
    public HistoriqueConnexion read(int id) {
        HistoriqueConnexion historiqueConnexion = null;
        String sql = "SELECT * FROM HistoriqueConnexion WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                historiqueConnexion = new HistoriqueConnexion();
                historiqueConnexion.setId(resultSet.getInt("id"));
                historiqueConnexion.setUtilisateurId(resultSet.getInt("utilisateurId"));
                historiqueConnexion.setDateConnexion(resultSet.getTimestamp("dateConnexion"));
                historiqueConnexion.setIp(resultSet.getString("ip"));
                historiqueConnexion.setNavigateur(resultSet.getString("navigateur"));
                historiqueConnexion.setSystemeExploitation(resultSet.getString("systemeExploitation"));
                historiqueConnexion.setPays(resultSet.getString("pays"));
                historiqueConnexion.setVille(resultSet.getString("ville"));
                historiqueConnexion.setCodePostal(resultSet.getString("codePostal"));
                historiqueConnexion.setLatitude(resultSet.getDouble("latitude"));
                historiqueConnexion.setLongitude(resultSet.getDouble("longitude"));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la lecture de l'historique de connexion : " + e.getMessage());
        }

        return historiqueConnexion;
    }

    @Override
    public void update(HistoriqueConnexion historiqueConnexion) {
        String sql = "UPDATE HistoriqueConnexion SET utilisateurId = ?, dateConnexion = ?, ip = ?, navigateur = ?, systemeExploitation = ?, pays = ?, ville = ?, codePostal = ?, latitude = ?, longitude = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, historiqueConnexion.getUtilisateurId());
            statement.setTimestamp(2, historiqueConnexion.getDateConnexion());
            statement.setString(3, historiqueConnexion.getIp());
            statement.setString(4, historiqueConnexion.getNavigateur());
            statement.setString(5, historiqueConnexion.getSystemeExploitation());
            statement.setString(6, historiqueConnexion.getPays());
            statement.setString(7, historiqueConnexion.getVille());
            statement.setString(8, historiqueConnexion.getCodePostal());
            statement.setDouble(9, historiqueConnexion.getLatitude());
            statement.setDouble(10, historiqueConnexion.getLongitude());
            statement.setInt(11, historiqueConnexion.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour de l'historique de connexion : " + e.getMessage());
        }
    }

    @Override
    public void delete(HistoriqueConnexion historiqueConnexion) {
        String sql = "DELETE FROM HistoriqueConnexion WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, historiqueConnexion.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de l'historique de connexion : " + e.getMessage());
        }
    }

    @Override
    public List<HistoriqueConnexion> readAll() {
        List<HistoriqueConnexion> historiqueConnexions = new ArrayList<>();
        String sql = "SELECT * FROM HistoriqueConnexion";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                HistoriqueConnexion historiqueConnexion = new HistoriqueConnexion();
                historiqueConnexion.setId(resultSet.getInt("id"));
                historiqueConnexion.setUtilisateurId(resultSet.getInt("utilisateurId"));
                historiqueConnexion.setDateConnexion(resultSet.getTimestamp("dateConnexion"));
                historiqueConnexion.setIp(resultSet.getString("ip"));
                historiqueConnexion.setNavigateur(resultSet.getString("navigateur"));
                historiqueConnexion.setSystemeExploitation(resultSet.getString("systemeExploitation"));
                historiqueConnexion.setPays(resultSet.getString("pays"));
                historiqueConnexion.setVille(resultSet.getString("ville"));
                historiqueConnexion.setCodePostal(resultSet.getString("codePostal"));
                historiqueConnexion.setLatitude(resultSet.getDouble("latitude"));
                historiqueConnexion.setLongitude(resultSet.getDouble("longitude"));

                historiqueConnexions.add(historiqueConnexion);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la lecture de tous les historiques de connexion : " + e.getMessage());
        }

        return historiqueConnexions;
    }
}
