package com.spiderdiplome.repository.implement;

import com.spiderdiplome.database.DatabaseConnection;
import com.spiderdiplome.models.Paiement;
import com.spiderdiplome.repository.dao.PaiementDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaiementDAOImpl implements PaiementDAO {

@Override
public void save(Paiement paiement) {
    if (paiement.getId() == 0) {
        create(paiement);
    } else {
        update(paiement);
    }
}

@Override
public boolean create(Paiement paiement) {
    String sql = "INSERT INTO Paiement (utilisateurId, payerId, montant, currency, datePaiement, paymentDate, methodePaiement, paymentDetails, statutPaiement, reference, transactionId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    int rowsAffected = 0;

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setInt(1, paiement.getUtilisateurId());
        statement.setInt(2, paiement.getPayerId());
        statement.setBigDecimal(3, paiement.getMontant());
        statement.setString(4, paiement.getCurrency());
        statement.setTimestamp(5, paiement.getDatePaiement() != null ? paiement.getDatePaiement() : new Timestamp(System.currentTimeMillis()));
        statement.setDate(6, paiement.getPaymentDate() != null ? new java.sql.Date(paiement.getPaymentDate().getTime()) : null);
        statement.setString(7, paiement.getMethodePaiement());
        statement.setString(8, paiement.getPaymentDetails());
        statement.setString(9, paiement.getStatutPaiement());
        statement.setString(10, paiement.getReference());
        statement.setString(11, paiement.getTransactionId());

        rowsAffected = statement.executeUpdate();
    } catch (SQLException e) {
        System.err.println("Erreur lors de la création du paiement : " + e.getMessage());
    }

    return rowsAffected > 0;
}

@Override
public Paiement read(int id) {
    String sql = "SELECT * FROM Paiement WHERE id = ?";
    Paiement paiement = null;

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            paiement = new Paiement();
            paiement.setId(resultSet.getInt("id"));
            paiement.setUtilisateurId(resultSet.getInt("utilisateurId"));
            paiement.setPayerId(resultSet.getInt("payerId"));
            paiement.setMontant(resultSet.getBigDecimal("montant"));
            paiement.setCurrency(resultSet.getString("currency"));
            paiement.setDatePaiement(resultSet.getTimestamp("datePaiement"));
            paiement.setPaymentDate(resultSet.getDate("paymentDate"));
            paiement.setMethodePaiement(resultSet.getString("methodePaiement"));
            paiement.setPaymentDetails(resultSet.getString("paymentDetails"));
            paiement.setStatutPaiement(resultSet.getString("statutPaiement"));
            paiement.setReference(resultSet.getString("reference"));
            paiement.setTransactionId(resultSet.getString("transactionId"));
        }
    } catch (SQLException e) {
        System.err.println("Erreur lors de la lecture du paiement : " + e.getMessage());
    }

    return paiement;
}

@Override
public List<Paiement> readAll() {
    String sql = "SELECT * FROM Paiement";
    List<Paiement> paiements = new ArrayList<>();

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Paiement paiement = new Paiement();
            paiement.setId(resultSet.getInt("id"));
            paiement.setUtilisateurId(resultSet.getInt("utilisateurId"));
            paiement.setPayerId(resultSet.getInt("payerId"));
            paiement.setMontant(resultSet.getBigDecimal("montant"));
            paiement.setCurrency(resultSet.getString("currency"));
            paiement.setDatePaiement(resultSet.getTimestamp("datePaiement"));
            paiement.setPaymentDate(resultSet.getDate("paymentDate"));
            paiement.setMethodePaiement(resultSet.getString("methodePaiement"));
            paiement.setPaymentDetails(resultSet.getString("paymentDetails"));
            paiement.setStatutPaiement(resultSet.getString("statutPaiement"));
            paiement.setReference(resultSet.getString("reference"));
            paiement.setTransactionId(resultSet.getString("transactionId"));
            paiements.add(paiement);
        }
    } catch (SQLException e) {
        System.err.println("Erreur lors de la lecture des paiements : " + e.getMessage());
    }

    return paiements;
}

@Override
public void update(Paiement paiement) {
    String sql = "UPDATE Paiement SET utilisateurId = ?, payerId = ?, montant = ?, currency = ?, datePaiement = ?, paymentDate = ?, methodePaiement = ?, paymentDetails = ?, statutPaiement = ?, reference = ?, transactionId = ? WHERE id = ?";

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setInt(1, paiement.getUtilisateurId());
        statement.setInt(2, paiement.getPayerId());
        statement.setBigDecimal(3, paiement.getMontant());
        statement.setString(4, paiement.getCurrency());
        statement.setTimestamp(5, paiement.getDatePaiement() != null ? paiement.getDatePaiement() : new Timestamp(System.currentTimeMillis()));
        statement.setDate(6, paiement.getPaymentDate() != null ? new java.sql.Date(paiement.getPaymentDate().getTime()) : null);
        statement.setString(7, paiement.getMethodePaiement());
        statement.setString(8, paiement.getPaymentDetails());
        statement.setString(9, paiement.getStatutPaiement());
        statement.setString(10, paiement.getReference());
        statement.setString(11, paiement.getTransactionId());
        statement.setInt(12, paiement.getId());

        statement.executeUpdate();
    } catch (SQLException e) {
        System.err.println("Erreur lors de la mise à jour du paiement : " + e.getMessage());
    }
}

@Override
public void delete(int id) {
    String sql = "DELETE FROM Paiement WHERE id = ?";

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setInt(1, id);
        statement.executeUpdate();
    } catch (SQLException e) {
        System.err.println("Erreur lors de la suppression du paiement : " + e.getMessage());
    }
}

@Override
public Paiement findByReference(String reference) {
    String sql = "SELECT * FROM Paiement WHERE reference = ?";
    Paiement paiement = null;

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setString(1, reference);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            paiement = new Paiement();
            paiement.setId(resultSet.getInt("id"));
            paiement.setUtilisateurId(resultSet.getInt("utilisateurId"));
            paiement.setPayerId(resultSet.getInt("payerId"));
            paiement.setMontant(resultSet.getBigDecimal("montant"));
            paiement.setCurrency(resultSet.getString("currency"));
            paiement.setDatePaiement(resultSet.getTimestamp("datePaiement"));
            paiement.setPaymentDate(resultSet.getDate("paymentDate"));
            paiement.setMethodePaiement(resultSet.getString("methodePaiement"));
            paiement.setPaymentDetails(resultSet.getString("paymentDetails"));
            paiement.setStatutPaiement(resultSet.getString("statutPaiement"));
            paiement.setReference(resultSet.getString("reference"));
            paiement.setTransactionId(resultSet.getString("transactionId"));
        }
    } catch (SQLException e) {
        System.err.println("Erreur lors de la recherche du paiement par référence : " + e.getMessage());
    }

    return paiement;
}


@Override
public List<Paiement> findByUtilisateurId(int utilisateurId) {
    String sql = "SELECT * FROM Paiement WHERE utilisateurId = ?";
    List<Paiement> paiements = new ArrayList<>();

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setInt(1, utilisateurId);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Paiement paiement = new Paiement();
            paiement.setId(resultSet.getInt("id"));
            paiement.setUtilisateurId(resultSet.getInt("utilisateurId"));
            paiement.setPayerId(resultSet.getInt("payerId"));
            paiement.setMontant(resultSet.getBigDecimal("montant"));
            paiement.setCurrency(resultSet.getString("currency"));
            paiement.setDatePaiement(resultSet.getTimestamp("datePaiement"));
            paiement.setPaymentDate(resultSet.getDate("paymentDate"));
            paiement.setMethodePaiement(resultSet.getString("methodePaiement"));
            paiement.setPaymentDetails(resultSet.getString("paymentDetails"));
            paiement.setStatutPaiement(resultSet.getString("statutPaiement"));
            paiement.setReference(resultSet.getString("reference"));
            paiement.setTransactionId(resultSet.getString("transactionId"));
            paiements.add(paiement);
        }
    } catch (SQLException e) {
        System.err.println("Erreur lors de la recherche des paiements par utilisateurId : " + e.getMessage());
    }

    return paiements;
}

@Override
public List<Paiement> findByPayerId(int payerId) {
    String sql = "SELECT * FROM Paiement WHERE payerId = ?";
    List<Paiement> paiements = new ArrayList<>();

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setInt(1, payerId);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Paiement paiement = new Paiement();
            paiement.setId(resultSet.getInt("id"));
            paiement.setUtilisateurId(resultSet.getInt("utilisateurId"));
            paiement.setPayerId(resultSet.getInt("payerId"));
            paiement.setMontant(resultSet.getBigDecimal("montant"));
            paiement.setCurrency(resultSet.getString("currency"));
            paiement.setDatePaiement(resultSet.getTimestamp("datePaiement"));
            paiement.setPaymentDate(resultSet.getDate("paymentDate"));
            paiement.setMethodePaiement(resultSet.getString("methodePaiement"));
            paiement.setPaymentDetails(resultSet.getString("paymentDetails"));
            paiement.setStatutPaiement(resultSet.getString("statutPaiement"));
            paiement.setReference(resultSet.getString("reference"));
            paiement.setTransactionId(resultSet.getString("transactionId"));
            paiements.add(paiement);
        }
    } catch (SQLException e) {
        System.err.println("Erreur lors de la recherche des paiements par payerId : " + e.getMessage());
    }

    return paiements;
}

@Override
public List<Paiement> findByMontant(double montant) {
    String sql = "SELECT * FROM Paiement WHERE montant = ?";
    List<Paiement> paiements = new ArrayList<>();

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setDouble(1, montant);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Paiement paiement = new Paiement();
            paiement.setId(resultSet.getInt("id"));
            paiement.setUtilisateurId(resultSet.getInt("utilisateurId"));
            paiement.setPayerId(resultSet.getInt("payerId"));
            paiement.setMontant(resultSet.getBigDecimal("montant"));
            paiement.setCurrency(resultSet.getString("currency"));
            paiement.setDatePaiement(resultSet.getTimestamp("datePaiement"));
            paiement.setPaymentDate(resultSet.getDate("paymentDate"));
            paiement.setMethodePaiement(resultSet.getString("methodePaiement"));
            paiement.setPaymentDetails(resultSet.getString("paymentDetails"));
            paiement.setStatutPaiement(resultSet.getString("statutPaiement"));
            paiement.setReference(resultSet.getString("reference"));
            paiement.setTransactionId(resultSet.getString("transactionId"));
            paiements.add(paiement);
        }
    } catch (SQLException e) {
        System.err.println("Erreur lors de la recherche des paiements par montant : " + e.getMessage());
    }

    return paiements;
}

@Override
public List<Paiement> findByCurrency(String currency) {
    String sql = "SELECT * FROM Paiement WHERE currency = ?";
    List<Paiement> paiements = new ArrayList<>();

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setString(1, currency);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Paiement paiement = new Paiement();
            paiement.setId(resultSet.getInt("id"));
            paiement.setUtilisateurId(resultSet.getInt("utilisateurId"));
            paiement.setPayerId(resultSet.getInt("payerId"));
            paiement.setMontant(resultSet.getBigDecimal("montant"));
            paiement.setCurrency(resultSet.getString("currency"));
            paiement.setDatePaiement(resultSet.getTimestamp("datePaiement"));
            paiement.setPaymentDate(resultSet.getDate("paymentDate"));
            paiement.setMethodePaiement(resultSet.getString("methodePaiement"));
            paiement.setPaymentDetails(resultSet.getString("paymentDetails"));
            paiement.setStatutPaiement(resultSet.getString("statutPaiement"));
            paiement.setReference(resultSet.getString("reference"));
            paiement.setTransactionId(resultSet.getString("transactionId"));
            paiements.add(paiement);
        }
    } catch (SQLException e) {
        System.err.println("Erreur lors de la recherche des paiements par currency : " + e.getMessage());
    }

    return paiements;
}

@Override
public List<Paiement> findByDatePaiement(Timestamp datePaiement) {
    String sql = "SELECT * FROM Paiement WHERE datePaiement = ?";
    List<Paiement> paiements = new ArrayList<>();

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setTimestamp(1, datePaiement);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Paiement paiement = new Paiement();
            paiement.setId(resultSet.getInt("id"));
            paiement.setUtilisateurId(resultSet.getInt("utilisateurId"));
            paiement.setPayerId(resultSet.getInt("payerId"));
            paiement.setMontant(resultSet.getBigDecimal("montant"));
            paiement.setCurrency(resultSet.getString("currency"));
            paiement.setDatePaiement(resultSet.getTimestamp("datePaiement"));
            paiement.setPaymentDate(resultSet.getDate("paymentDate"));
            paiement.setMethodePaiement(resultSet.getString("methodePaiement"));
            paiement.setPaymentDetails(resultSet.getString("paymentDetails"));
            paiement.setStatutPaiement(resultSet.getString("statutPaiement"));
            paiement.setReference(resultSet.getString("reference"));
            paiement.setTransactionId(resultSet.getString("transactionId"));
            paiements.add(paiement);
        }
    } catch (SQLException e) {
        System.err.println("Erreur lors de la recherche des paiements par datePaiement : " + e.getMessage());
    }

    return paiements;
}

@Override
public List<Paiement> findByMethodePaiement(String methodePaiement) {
    String sql = "SELECT * FROM Paiement WHERE methodePaiement = ?";
    List<Paiement> paiements = new ArrayList<>();

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setString(1, methodePaiement);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Paiement paiement = new Paiement();
            paiement.setId(resultSet.getInt("id"));
            paiement.setUtilisateurId(resultSet.getInt("utilisateurId"));
            paiement.setPayerId(resultSet.getInt("payerId"));
            paiement.setMontant(resultSet.getBigDecimal("montant"));
            paiement.setCurrency(resultSet.getString("currency"));
            paiement.setDatePaiement(resultSet.getTimestamp("datePaiement"));
            paiement.setPaymentDate(resultSet.getDate("paymentDate"));
            paiement.setMethodePaiement(resultSet.getString("methodePaiement"));
            paiement.setPaymentDetails(resultSet.getString("paymentDetails"));
            paiement.setStatutPaiement(resultSet.getString("statutPaiement"));
            paiement.setReference(resultSet.getString("reference"));
            paiement.setTransactionId(resultSet.getString("transactionId"));
            paiements.add(paiement);
        }
    } catch (SQLException e) {
        System.err.println("Erreur lors de la recherche des paiements par methodePaiement : " + e.getMessage());
    }

    return paiements;
}

@Override
public List<Paiement> findByStatutPaiement(String statutPaiement) {
    String sql = "SELECT * FROM Paiement WHERE statutPaiement = ?";
    List<Paiement> paiements = new ArrayList<>();

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setString(1, statutPaiement);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Paiement paiement = new Paiement();
            paiement.setId(resultSet.getInt("id"));
            paiement.setUtilisateurId(resultSet.getInt("utilisateurId"));
            paiement.setPayerId(resultSet.getInt("payerId"));
            paiement.setMontant(resultSet.getBigDecimal("montant"));
            paiement.setCurrency(resultSet.getString("currency"));
            paiement.setDatePaiement(resultSet.getTimestamp("datePaiement"));
            paiement.setPaymentDate(resultSet.getDate("paymentDate"));
            paiement.setMethodePaiement(resultSet.getString("methodePaiement"));
            paiement.setPaymentDetails(resultSet.getString("paymentDetails"));
            paiement.setStatutPaiement(resultSet.getString("statutPaiement"));
            paiement.setReference(resultSet.getString("reference"));
            paiement.setTransactionId(resultSet.getString("transactionId"));
            paiements.add(paiement);
        }
    } catch (SQLException e) {
        System.err.println("Erreur lors de la recherche des paiements par statutPaiement : " + e.getMessage());
    }

    return paiements;
}

@Override
public List<Paiement> findByTransactionId(String transactionId) {
    String sql = "SELECT * FROM Paiement WHERE transactionId = ?";
    List<Paiement> paiements = new ArrayList<>();

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setString(1, transactionId);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Paiement paiement = new Paiement();
            paiement.setId(resultSet.getInt("id"));
            paiement.setUtilisateurId(resultSet.getInt("utilisateurId"));
            paiement.setPayerId(resultSet.getInt("payerId"));
            paiement.setMontant(resultSet.getBigDecimal("montant"));
            paiement.setCurrency(resultSet.getString("currency"));
            paiement.setDatePaiement(resultSet.getTimestamp("datePaiement"));
            paiement.setPaymentDate(resultSet.getDate("paymentDate"));
            paiement.setMethodePaiement(resultSet.getString("methodePaiement"));
            paiement.setPaymentDetails(resultSet.getString("paymentDetails"));
            paiement.setStatutPaiement(resultSet.getString("statutPaiement"));
            paiement.setReference(resultSet.getString("reference"));
            paiement.setTransactionId(resultSet.getString("transactionId"));
            paiements.add(paiement);
        }
    } catch (SQLException e) {
        System.err.println("Erreur lors de la recherche des paiements par transactionId : " + e.getMessage());
    }

    return paiements;
}

@Override
public List<Paiement> findByPaymentDate(Timestamp paymentDate) {
    String sql = "SELECT * FROM Paiement WHERE paymentDate = ?";
    List<Paiement> paiements = new ArrayList<>();

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setTimestamp(1, paymentDate);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Paiement paiement = new Paiement();
            paiement.setId(resultSet.getInt("id"));
            paiement.setUtilisateurId(resultSet.getInt("utilisateurId"));
            paiement.setPayerId(resultSet.getInt("payerId"));
            paiement.setMontant(resultSet.getBigDecimal("montant"));
            paiement.setCurrency(resultSet.getString("currency"));
            paiement.setDatePaiement(resultSet.getTimestamp("datePaiement"));
            paiement.setPaymentDate(resultSet.getDate("paymentDate"));
            paiement.setMethodePaiement(resultSet.getString("methodePaiement"));
            paiement.setPaymentDetails(resultSet.getString("paymentDetails"));
            paiement.setStatutPaiement(resultSet.getString("statutPaiement"));
            paiement.setReference(resultSet.getString("reference"));
            paiement.setTransactionId(resultSet.getString("transactionId"));
            paiements.add(paiement);
        }
    } catch (SQLException e) {
        System.err.println("Erreur lors de la recherche des paiements par paymentDate : " + e.getMessage());
    }

    return paiements;
}
}