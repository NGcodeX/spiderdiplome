package com.spiderdiplome.repository.implement;

import com.spiderdiplome.database.DatabaseConnection;
import com.spiderdiplome.models.Candidature;
import com.spiderdiplome.repository.dao.CandidatureDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CandidatureDAOImpl implements CandidatureDAO {


    @Override
    public List<Candidature> findAll() {
        List<Candidature> candidatures = new ArrayList<>();
        String sql = "SELECT * FROM Candidatures";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Candidature candidature = new Candidature();
                candidature.setId(resultSet.getInt("id"));
                candidature.setUtilisateurId(resultSet.getInt("utilisateurId"));
                candidature.setUniversiteId(resultSet.getInt("universiteId"));
                candidature.setDateSoumission(resultSet.getTimestamp("dateSoumission"));
                candidature.setStatut(resultSet.getString("statut"));
                candidature.setDateExamen(resultSet.getDate("dateExamen"));
                candidature.setScoreExamen(resultSet.getBigDecimal("scoreExamen"));
                candidature.setDateEntretien(resultSet.getDate("dateEntretien"));
                candidature.setScoreEntretien(resultSet.getBigDecimal("scoreEntretien"));
                candidature.setDateDecisionFinale(resultSet.getDate("dateDecisionFinale"));
                candidature.setDecisionFinale(resultSet.getString("decisionFinale"));
                candidature.setCommentaire(resultSet.getString("commentaire"));
                candidature.setFraisApplication(resultSet.getBigDecimal("fraisApplication"));
                candidature.setaPayer(resultSet.getBoolean("aPayer"));
                candidature.setaPayerAvant(resultSet.getDate("aPayerAvant"));
                candidature.setaPayerMontant(resultSet.getBigDecimal("aPayerMontant"));
                candidature.setaPayerMethode(resultSet.getString("aPayerMethode"));
                candidature.setaPayerStatut(resultSet.getString("aPayerStatut"));
                candidature.setaPayerDate(resultSet.getTimestamp("aPayerDate"));
                candidature.setaPayerTransactionId(resultSet.getString("aPayerTransactionId"));

                candidatures.add(candidature);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des candidatures : " + e.getMessage());
        }

        return candidatures;
    }

    @Override
    public List<Candidature> findByUserId(int utilisateurId) {
        List<Candidature> candidatures = new ArrayList<>();
        String sql = "SELECT * FROM Candidatures WHERE utilisateurId = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, utilisateurId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Candidature candidature = new Candidature();
                candidature.setId(resultSet.getInt("id"));
                candidature.setUtilisateurId(resultSet.getInt("utilisateurId"));
                candidature.setUniversiteId(resultSet.getInt("universiteId"));
                candidature.setDateSoumission(resultSet.getTimestamp("dateSoumission"));
                candidature.setStatut(resultSet.getString("statut"));
                candidature.setDateExamen(resultSet.getDate("dateExamen"));
                candidature.setScoreExamen(resultSet.getBigDecimal("scoreExamen"));
                candidature.setDateEntretien(resultSet.getDate("dateEntretien"));
                candidature.setScoreEntretien(resultSet.getBigDecimal("scoreEntretien"));
                candidature.setDateDecisionFinale(resultSet.getDate("dateDecisionFinale"));
                candidature.setDecisionFinale(resultSet.getString("decisionFinale"));
                candidature.setCommentaire(resultSet.getString("commentaire"));
                candidature.setFraisApplication(resultSet.getBigDecimal("fraisApplication"));
                candidature.setaPayer(resultSet.getBoolean("aPayer"));
                candidature.setaPayerAvant(resultSet.getDate("aPayerAvant"));
                candidature.setaPayerMontant(resultSet.getBigDecimal("aPayerMontant"));
                candidature.setaPayerMethode(resultSet.getString("aPayerMethode"));
                candidature.setaPayerStatut(resultSet.getString("aPayerStatut"));
                candidature.setaPayerDate(resultSet.getTimestamp("aPayerDate"));
                candidature.setaPayerTransactionId(resultSet.getString("aPayerTransactionId"));

                candidatures.add(candidature);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des candidatures : " + e.getMessage());
        }

        return candidatures;
    }

    @Override
    public Candidature findById(int id) {
        Candidature candidature = null;
        String sql = "SELECT * FROM Candidatures WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                candidature = new Candidature();
                candidature.setId(resultSet.getInt("id"));
                candidature.setUtilisateurId(resultSet.getInt("utilisateurId"));
                candidature.setUniversiteId(resultSet.getInt("universiteId"));
                candidature.setDateSoumission(resultSet.getTimestamp("dateSoumission"));
                candidature.setStatut(resultSet.getString("statut"));
                candidature.setDateExamen(resultSet.getDate("dateExamen"));
                candidature.setScoreExamen(resultSet.getBigDecimal("scoreExamen"));
                candidature.setDateEntretien(resultSet.getDate("dateEntretien"));
                candidature.setScoreEntretien(resultSet.getBigDecimal("scoreEntretien"));
                candidature.setDateDecisionFinale(resultSet.getDate("dateDecisionFinale"));
                candidature.setDecisionFinale(resultSet.getString("decisionFinale"));
                candidature.setCommentaire(resultSet.getString("commentaire"));
                candidature.setFraisApplication(resultSet.getBigDecimal("fraisApplication"));
                candidature.setaPayer(resultSet.getBoolean("aPayer"));
                candidature.setaPayerAvant(resultSet.getDate("aPayerAvant"));
                candidature.setaPayerMontant(resultSet.getBigDecimal("aPayerMontant"));
                candidature.setaPayerMethode(resultSet.getString("aPayerMethode"));
                candidature.setaPayerStatut(resultSet.getString("aPayerStatut"));
                candidature.setaPayerDate(resultSet.getTimestamp("aPayerDate"));
                candidature.setaPayerTransactionId(resultSet.getString("aPayerTransactionId"));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de la candidature : " + e.getMessage());
        }

        return candidature;
    }

    @Override
    public void save(Candidature candidature) {
        String sql = "INSERT INTO Candidatures (utilisateurId, universiteId, statut, dateExamen, scoreExamen, dateEntretien, scoreEntretien, dateDecisionFinale, decisionFinale, commentaire, fraisApplication, aPayer, aPayerAvant, aPayerMontant, aPayerMethode, aPayerStatut, aPayerDate, aPayerTransactionId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, candidature.getUtilisateurId());
            statement.setInt(2, candidature.getUniversiteId());
            statement.setString(3, candidature.getStatut());
            statement.setDate(4, new java.sql.Date(candidature.getDateExamen().getTime()));
            statement.setBigDecimal(5, candidature.getScoreExamen());
            statement.setDate(6, new java.sql.Date(candidature.getDateEntretien().getTime()));
            statement.setBigDecimal(7, candidature.getScoreEntretien());
            statement.setDate(8, new java.sql.Date(candidature.getDateDecisionFinale().getTime()));
            statement.setString(9, candidature.getDecisionFinale());
            statement.setString(10, candidature.getCommentaire());
            statement.setBigDecimal(11, candidature.getFraisApplication());
            statement.setBoolean(12, candidature.isaPayer());
            statement.setDate(13, new java.sql.Date(candidature.getaPayerAvant().getTime()));
            statement.setBigDecimal(14, candidature.getaPayerMontant());
            statement.setString(15, candidature.getaPayerMethode());
            statement.setString(16, candidature.getaPayerStatut());
            statement.setTimestamp(17, candidature.getaPayerDate());
            statement.setString(18, candidature.getaPayerTransactionId());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'insertion de la candidature : " + e.getMessage());
        }
    }

    @Override
    public void update(Candidature candidature) {
        String sql = "UPDATE Candidatures SET utilisateurId = ?, universiteId = ?, statut = ?, dateExamen = ?, scoreExamen = ?, dateEntretien = ?, scoreEntretien = ?, dateDecisionFinale = ?, decisionFinale = ?, commentaire = ?, fraisApplication = ?, aPayer = ?, aPayerAvant = ?, aPayerMontant = ?, aPayerMethode = ?, aPayerStatut = ?, aPayerDate = ?, aPayerTransactionId = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, candidature.getUtilisateurId());
            statement.setInt(2, candidature.getUniversiteId());
            statement.setString(3, candidature.getStatut());
            statement.setDate(4, new java.sql.Date(candidature.getDateExamen().getTime()));
            statement.setBigDecimal(5, candidature.getScoreExamen());
            statement.setDate(6, new java.sql.Date(candidature.getDateEntretien().getTime()));
            statement.setBigDecimal(7, candidature.getScoreEntretien());
            statement.setDate(8, new java.sql.Date(candidature.getDateDecisionFinale().getTime()));
            statement.setString(9, candidature.getDecisionFinale());
            statement.setString(10, candidature.getCommentaire());
            statement.setBigDecimal(11, candidature.getFraisApplication());
            statement.setBoolean(12, candidature.isaPayer());
            statement.setDate(13, new java.sql.Date(candidature.getaPayerAvant().getTime()));
            statement.setBigDecimal(14, candidature.getaPayerMontant());
            statement.setString(15, candidature.getaPayerMethode());
            statement.setString(16, candidature.getaPayerStatut());
            statement.setTimestamp(17, candidature.getaPayerDate());
            statement.setString(18, candidature.getaPayerTransactionId());
            statement.setInt(19, candidature.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour de la candidature : " + e.getMessage());
        }
    }

    @Override
    public void delete(Candidature candidature) {
        String sql = "DELETE FROM Candidatures WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, candidature.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de la candidature : " + e.getMessage());
        }
    }
}
