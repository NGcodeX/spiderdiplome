package com.spiderdiplome.models;

import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.Date;

public class Paiement {
    private int id;
    private int utilisateurId;
    private int payerId;
    private BigDecimal montant;
    private String currency;
    private Timestamp datePaiement;
    private Date paymentDate;
    private String methodePaiement;
    private String paymentDetails;
    private String statutPaiement;
    private String reference;
    private String transactionId;

    public Paiement() {
    }

    public Paiement(int id, int utilisateurId, int payerId, BigDecimal montant, String currency, Timestamp datePaiement, Date paymentDate, String methodePaiement, String paymentDetails, String statutPaiement, String reference, String transactionId) {
        this.id = id;
        this.utilisateurId = utilisateurId;
        this.payerId = payerId;
        this.montant = montant;
        this.currency = currency;
        this.datePaiement = datePaiement;
        this.paymentDate = paymentDate;
        this.methodePaiement = methodePaiement;
        this.paymentDetails = paymentDetails;
        this.statutPaiement = statutPaiement;
        this.reference = reference;
        this.transactionId = transactionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(int utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public int getPayerId() {
        return payerId;
    }

    public void setPayerId(int payerId) {
        this.payerId = payerId;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Timestamp getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Timestamp datePaiement) {
        this.datePaiement = datePaiement;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getMethodePaiement() {
        return methodePaiement;
    }

    public void setMethodePaiement(String methodePaiement) {
        this.methodePaiement = methodePaiement;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public String getStatutPaiement() {
        return statutPaiement;
    }

    public void setStatutPaiement(String statutPaiement) {
        this.statutPaiement = statutPaiement;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
