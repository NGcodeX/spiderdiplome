package com.spiderdiplome.models;

import java.sql.Timestamp;

public class HistoriqueConnexion {
    private int id;
    private int utilisateurId;
    private Timestamp dateConnexion;
    private String ip;
    private String navigateur;
    private String systemeExploitation;
    private String pays;
    private String ville;
    private String codePostal;
    private double latitude;
    private double longitude;

    public HistoriqueConnexion() {
    }

    public HistoriqueConnexion(int id, int utilisateurId, Timestamp dateConnexion, String ip, String navigateur, String systemeExploitation, String pays, String ville, String codePostal, double latitude, double longitude) {
        this.id = id;
        this.utilisateurId = utilisateurId;
        this.dateConnexion = dateConnexion;
        this.ip = ip;
        this.navigateur = navigateur;
        this.systemeExploitation = systemeExploitation;
        this.pays = pays;
        this.ville = ville;
        this.codePostal = codePostal;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public Timestamp getDateConnexion() {
        return dateConnexion;
    }

    public void setDateConnexion(Timestamp dateConnexion) {
        this.dateConnexion = dateConnexion;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNavigateur() {
        return navigateur;
    }

    public void setNavigateur(String navigateur) {
        this.navigateur = navigateur;
    }

    public String getSystemeExploitation() {
        return systemeExploitation;
    }

    public void setSystemeExploitation(String systemeExploitation) {
        this.systemeExploitation = systemeExploitation;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}