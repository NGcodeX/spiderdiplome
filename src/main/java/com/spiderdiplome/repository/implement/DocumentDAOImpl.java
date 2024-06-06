package com.spiderdiplome.repository.implement;

import com.spiderdiplome.models.Document;
import com.spiderdiplome.repository.dao.DocumentDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DocumentDAOImpl implements DocumentDAO {
    private Connection connection;

    public DocumentDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Document findById(int id) {
        Document document = null;
        String sql = "SELECT * FROM Documents WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                document = new Document();
                document.setId(resultSet.getInt("id"));
                document.setUtilisateurId(resultSet.getInt("utilisateurId"));
                document.setCandidatureId(resultSet.getInt("candidatureId"));
                document.setNom(resultSet.getString("nom"));
                document.setType(resultSet.getString("type"));
                document.setDateSoumission(resultSet.getTimestamp("dateSoumission"));
                document.setStatut(resultSet.getString("statut"));
                document.setCommentaire(resultSet.getString("commentaire"));
                document.setCheminFichier(resultSet.getString("cheminFichier"));
                document.setTailleFichier(resultSet.getDouble("tailleFichier"));
                document.setFormatFichier(resultSet.getString("formatFichier"));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche du document : " + e.getMessage());
        }

        return document;
    }

    @Override
    public List<Document> findAll() {
        List<Document> documents = new ArrayList<>();
        String sql = "SELECT * FROM Documents";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Document document = new Document();
                document.setId(resultSet.getInt("id"));
                document.setUtilisateurId(resultSet.getInt("utilisateurId"));
                document.setCandidatureId(resultSet.getInt("candidatureId"));
                document.setNom(resultSet.getString("nom"));
                document.setType(resultSet.getString("type"));
                document.setDateSoumission(resultSet.getTimestamp("dateSoumission"));
                document.setStatut(resultSet.getString("statut"));
                document.setCommentaire(resultSet.getString("commentaire"));
                document.setCheminFichier(resultSet.getString("cheminFichier"));
                document.setTailleFichier(resultSet.getDouble("tailleFichier"));
                document.setFormatFichier(resultSet.getString("formatFichier"));
                documents.add(document);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des documents : " + e.getMessage());
        }

        return documents;
    }

    @Override
    public void save(Document document) {
        String sql = "INSERT INTO Documents (utilisateurId, candidatureId, nom, type, statut, commentaire, cheminFichier, tailleFichier, formatFichier) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, document.getUtilisateurId());
            statement.setInt(2, document.getCandidatureId());
            statement.setString(3, document.getNom());
            statement.setString(4, document.getType());
            statement.setString(5, document.getStatut());
            statement.setString(6, document.getCommentaire());
            statement.setString(7, document.getCheminFichier());
            statement.setDouble(8, document.getTailleFichier());
            statement.setString(9, document.getFormatFichier());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'insertion du document : " + e.getMessage());
        }
    }

    @Override
    public void update(Document document) {
        String sql = "UPDATE Documents SET utilisateurId = ?, candidatureId = ?, nom = ?, type = ?, statut = ?, commentaire = ?, cheminFichier = ?, tailleFichier = ?, formatFichier = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, document.getUtilisateurId());
            statement.setInt(2, document.getCandidatureId());
            statement.setString(3, document.getNom());
            statement.setString(4, document.getType());
            statement.setString(5, document.getStatut());
            statement.setString(6, document.getCommentaire());
            statement.setString(7, document.getCheminFichier());
            statement.setDouble(8, document.getTailleFichier());
            statement.setString(9, document.getFormatFichier());
            statement.setInt(10, document.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour du document : " + e.getMessage());
        }
    }

    @Override
    public void delete(Document document) {
        String sql = "DELETE FROM Documents WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, document.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression du document : " + e.getMessage());
        }
    }
}