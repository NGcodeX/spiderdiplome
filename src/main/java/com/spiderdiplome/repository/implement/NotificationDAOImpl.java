package com.spiderdiplome.repository.implement;

import com.spiderdiplome.models.Notification;
import com.spiderdiplome.repository.dao.NotificationDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotificationDAOImpl implements NotificationDAO {
    private Connection connection;

    public NotificationDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Notification> findAll() {
        List<Notification> notifications = new ArrayList<>();

        String sql = "SELECT * FROM Notifications";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Notification notification = new Notification();
                notification.setId(resultSet.getInt("id"));
                notification.setUtilisateurId(resultSet.getInt("utilisateurId"));
                notification.setTitre(resultSet.getString("titre"));
                notification.setMessage(resultSet.getString("message"));
                notification.setDateEnvoi(resultSet.getTimestamp("dateEnvoi"));
                notification.setLu(resultSet.getBoolean("lu"));
                notification.setDateLecture(resultSet.getTimestamp("dateLecture"));
                notification.setType(resultSet.getString("type"));
                notification.setUrlRedirection(resultSet.getString("urlRedirection"));
                notification.setIcone(resultSet.getString("icone"));
                notification.setCouleurFond(resultSet.getString("couleurFond"));
                notification.setCouleurTexte(resultSet.getString("couleurTexte"));

                notifications.add(notification);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des notifications : " + e.getMessage());
        }

        return notifications;
    }

    @Override
    public Notification findById(int id) {
        Notification notification = null;
        String sql = "SELECT * FROM Notifications WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    notification = new Notification();
                    notification.setId(resultSet.getInt("id"));
                    notification.setUtilisateurId(resultSet.getInt("utilisateurId"));
                    notification.setTitre(resultSet.getString("titre"));
                    notification.setMessage(resultSet.getString("message"));
                    notification.setDateEnvoi(resultSet.getTimestamp("dateEnvoi"));
                    notification.setLu(resultSet.getBoolean("lu"));
                    notification.setDateLecture(resultSet.getTimestamp("dateLecture"));
                    notification.setType(resultSet.getString("type"));
                    notification.setUrlRedirection(resultSet.getString("urlRedirection"));
                    notification.setIcone(resultSet.getString("icone"));
                    notification.setCouleurFond(resultSet.getString("couleurFond"));
                    notification.setCouleurTexte(resultSet.getString("couleurTexte"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de la notification : " + e.getMessage());
        }

        return notification;
    }

    @Override
    public void save(Notification notification) {
        String sql = "INSERT INTO Notifications (utilisateurId, titre, message, lu, dateLecture, type, urlRedirection, icone, couleurFond, couleurTexte) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, notification.getUtilisateurId());
            statement.setString(2, notification.getTitre());
            statement.setString(3, notification.getMessage());
            statement.setBoolean(4, notification.isLu());
            statement.setTimestamp(5, notification.getDateLecture());
            statement.setString(6, notification.getType());
            statement.setString(7, notification.getUrlRedirection());
            statement.setString(8, notification.getIcone());
            statement.setString(9, notification.getCouleurFond());
            statement.setString(10, notification.getCouleurTexte());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'insertion de la notification : " + e.getMessage());
        }
    }

    @Override
    public void update(Notification notification) {
        String sql = "UPDATE Notifications SET utilisateurId = ?, titre = ?, message = ?, lu = ?, dateLecture = ?, type = ?, urlRedirection = ?, icone = ?, couleurFond = ?, couleurTexte = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, notification.getUtilisateurId());
            statement.setString(2, notification.getTitre());
            statement.setString(3, notification.getMessage());
            statement.setBoolean(4, notification.isLu());
            statement.setTimestamp(5, notification.getDateLecture());
            statement.setString(6, notification.getType());
            statement.setString(7, notification.getUrlRedirection());
            statement.setString(8, notification.getIcone());
            statement.setString(9, notification.getCouleurFond());
            statement.setString(10, notification.getCouleurTexte());
            statement.setInt(11, notification.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour de la notification : " + e.getMessage());
        }
    }

    @Override
    public void delete(Notification notification) {
        String sql = "DELETE FROM Notifications WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, notification.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de la notification : " + e.getMessage());
        }
    }
}