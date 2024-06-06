package com.spiderdiplome.models;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class Candidature {
    private int id;
    private int utilisateurId;
    private int universiteId;
    private Timestamp dateSoumission;
    private String statut;
    private Date dateExamen;
    private BigDecimal scoreExamen;
    private Date dateEntretien;
    private BigDecimal scoreEntretien;
    private Date dateDecisionFinale;
    private String decisionFinale;
    private String commentaire;
    private BigDecimal fraisApplication;
    private boolean aPayer;
    private Date aPayerAvant;
    private BigDecimal aPayerMontant;
    private String aPayerMethode;
    private String aPayerStatut;
    private Timestamp aPayerDate;
    private String aPayerTransactionId;

    public Candidature() {

    }

    public Candidature(int id, int utilisateurId, int universiteId, Timestamp dateSoumission, String statut, Date dateExamen, BigDecimal scoreExamen, Date dateEntretien, BigDecimal scoreEntretien, Date dateDecisionFinale, String decisionFinale, String commentaire, BigDecimal fraisApplication, boolean aPayer, Date aPayerAvant, BigDecimal aPayerMontant, String aPayerMethode, String aPayerStatut, Timestamp aPayerDate, String aPayerTransactionId) {
        this.id = id;
        this.utilisateurId = utilisateurId;
        this.universiteId = universiteId;
        this.dateSoumission = dateSoumission;
        this.statut = statut;
        this.dateExamen = dateExamen;
        this.scoreExamen = scoreExamen;
        this.dateEntretien = dateEntretien;
        this.scoreEntretien = scoreEntretien;
        this.dateDecisionFinale = dateDecisionFinale;
        this.decisionFinale = decisionFinale;
        this.commentaire = commentaire;
        this.fraisApplication = fraisApplication;
        this.aPayer = aPayer;
        this.aPayerAvant = aPayerAvant;
        this.aPayerMontant = aPayerMontant;
        this.aPayerMethode = aPayerMethode;
        this.aPayerStatut = aPayerStatut;
        this.aPayerDate = aPayerDate;
        this.aPayerTransactionId = aPayerTransactionId;
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

    public int getUniversiteId() {
        return universiteId;
    }

    public void setUniversiteId(int universiteId) {
        this.universiteId = universiteId;
    }

    public Timestamp getDateSoumission() {
        return dateSoumission;
    }

    public void setDateSoumission(Timestamp dateSoumission) {
        this.dateSoumission = dateSoumission;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Date getDateExamen() {
        return dateExamen;
    }

    public void setDateExamen(Date dateExamen) {
        this.dateExamen = dateExamen;
    }

    public BigDecimal getScoreExamen() {
        return scoreExamen;
    }

    public void setScoreExamen(BigDecimal scoreExamen) {
        this.scoreExamen = scoreExamen;
    }

    public Date getDateEntretien() {
        return dateEntretien;
    }

    public void setDateEntretien(Date dateEntretien) {
        this.dateEntretien = dateEntretien;
    }

    public BigDecimal getScoreEntretien() {
        return scoreEntretien;
    }

    public void setScoreEntretien(BigDecimal scoreEntretien) {
        this.scoreEntretien = scoreEntretien;
    }

    public Date getDateDecisionFinale() {
        return dateDecisionFinale;
    }

    public void setDateDecisionFinale(Date dateDecisionFinale) {
        this.dateDecisionFinale = dateDecisionFinale;
    }

    public String getDecisionFinale() {
        return decisionFinale;
    }

    public void setDecisionFinale(String decisionFinale) {
        this.decisionFinale = decisionFinale;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public BigDecimal getFraisApplication() {
        return fraisApplication;
    }

    public void setFraisApplication(BigDecimal fraisApplication) {
        this.fraisApplication = fraisApplication;
    }

    public boolean isaPayer() {
        return aPayer;
    }

    public void setaPayer(boolean aPayer) {
        this.aPayer = aPayer;
    }

    public Date getaPayerAvant() {
        return aPayerAvant;
    }

    public void setaPayerAvant(Date aPayerAvant) {
        this.aPayerAvant = aPayerAvant;
    }

    public BigDecimal getaPayerMontant() {
        return aPayerMontant;
    }

    public void setaPayerMontant(BigDecimal aPayerMontant) {
        this.aPayerMontant = aPayerMontant;
    }

    public String getaPayerMethode() {
        return aPayerMethode;
    }

    public void setaPayerMethode(String aPayerMethode) {
        this.aPayerMethode = aPayerMethode;
    }

    public String getaPayerStatut() {
        return aPayerStatut;
    }

    public void setaPayerStatut(String aPayerStatut) {
        this.aPayerStatut = aPayerStatut;
    }

    public Timestamp getaPayerDate() {
        return aPayerDate;
    }

    public void setaPayerDate(Timestamp aPayerDate) {
        this.aPayerDate = aPayerDate;
    }

    public String getaPayerTransactionId() {
        return aPayerTransactionId;
    }

    public void setaPayerTransactionId(String aPayerTransactionId) {
        this.aPayerTransactionId = aPayerTransactionId;
    }
}