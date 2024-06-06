package com.spiderdiplome.models;

import java.sql.Timestamp;

public class Document {
    private int id;
    private int utilisateurId;
    private int candidatureId;
    private String nom;
    private String type;
    private Timestamp dateSoumission;
    private String statut;
    private String commentaire;
    private String cheminFichier;
    private double tailleFichier;
    private String formatFichier;

    public Document() {
    }

    public Document(int id, int utilisateurId, int candidatureId, String nom, String type, Timestamp dateSoumission, String statut, String commentaire, String cheminFichier, double tailleFichier, String formatFichier) {
        this.id = id;
        this.utilisateurId = utilisateurId;
        this.candidatureId = candidatureId;
        this.nom = nom;
        this.type = type;
        this.dateSoumission = dateSoumission;
        this.statut = statut;
        this.commentaire = commentaire;
        this.cheminFichier = cheminFichier;
        this.tailleFichier = tailleFichier;
        this.formatFichier = formatFichier;
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

    public int getCandidatureId() {
        return candidatureId;
    }

    public void setCandidatureId(int candidatureId) {
        this.candidatureId = candidatureId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getCheminFichier() {
        return cheminFichier;
    }

    public void setCheminFichier(String cheminFichier) {
        this.cheminFichier = cheminFichier;
    }

    public double getTailleFichier() {
        return tailleFichier;
    }

    public void setTailleFichier(double tailleFichier) {
        this.tailleFichier = tailleFichier;
    }

    public String getFormatFichier() {
        return formatFichier;
    }

    public void setFormatFichier(String formatFichier) {
        this.formatFichier = formatFichier;
    }
}