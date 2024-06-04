package com.spiderdiplome.repository.dao;

import com.spiderdiplome.models.Paiement;

import java.sql.Timestamp;
import java.util.List;

public interface PaiementDAO {
    void save(Paiement paiement);
    boolean create(Paiement paiement);
    Paiement read(int id);
    List<Paiement> readAll();
    void update(Paiement paiement);
    void delete(int id);
    Paiement findByReference(String reference);
    List<Paiement> findByUtilisateurId(int utilisateurId);
    List<Paiement> findByPayerId(int payerId);
    List<Paiement> findByMontant(double montant);
    List<Paiement> findByCurrency(String currency);
    List<Paiement> findByDatePaiement(Timestamp datePaiement);
    List<Paiement> findByPaymentDate(Timestamp paymentDate);
    List<Paiement> findByMethodePaiement(String methodePaiement);
    List<Paiement> findByStatutPaiement(String statutPaiement);
    List<Paiement> findByTransactionId(String transactionId);

}