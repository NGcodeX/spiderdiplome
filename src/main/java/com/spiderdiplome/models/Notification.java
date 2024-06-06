package com.spiderdiplome.models;

import java.sql.Timestamp;

public class Notification {
    private int id;
    private int utilisateurId;
    private String titre;
    private String message;
    private Timestamp dateEnvoi;
    private boolean lu;
    private Timestamp dateLecture;
    private String type;
    private String urlRedirection;
    private String icone;
    private String couleurFond;
    private String couleurTexte;

    public Notification() {

    }

    public Notification(int id, int utilisateurId, String titre, String message, Timestamp dateEnvoi, boolean lu, Timestamp dateLecture, String type, String urlRedirection, String icone, String couleurFond, String couleurTexte) {
        this.id = id;
        this.utilisateurId = utilisateurId;
        this.titre = titre;
        this.message = message;
        this.dateEnvoi = dateEnvoi;
        this.lu = lu;
        this.dateLecture = dateLecture;
        this.type = type;
        this.urlRedirection = urlRedirection;
        this.icone = icone;
        this.couleurFond = couleurFond;
        this.couleurTexte = couleurTexte;
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

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(Timestamp dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    public boolean isLu() {
        return lu;
    }

    public void setLu(boolean lu) {
        this.lu = lu;
    }

    public Timestamp getDateLecture() {
        return dateLecture;
    }

    public void setDateLecture(Timestamp dateLecture) {
        this.dateLecture = dateLecture;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrlRedirection() {
        return urlRedirection;
    }

    public void setUrlRedirection(String urlRedirection) {
        this.urlRedirection = urlRedirection;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public String getCouleurFond() {
        return couleurFond;
    }

    public void setCouleurFond(String couleurFond) {
        this.couleurFond = couleurFond;
    }

    public String getCouleurTexte() {
        return couleurTexte;
    }

    public void setCouleurTexte(String couleurTexte) {
        this.couleurTexte = couleurTexte;
    }
}
