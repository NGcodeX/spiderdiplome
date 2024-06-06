package com.spiderdiplome.models;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class Universite {
    private int id;
    private String nom;
    private String emplacement;
    private String description;
    private Timestamp date_ajoutee;
    private String statut;
    private String logo;
    private String site_web;
    private String numero_contact;
    private String email_contact;
    private String adresse_postale;
    private String cours_offerts;
    private Date date_limite_application;
    private BigDecimal frais_scolarite;
    private int nombre_etudiants;
    private int nombre_professeurs;
    private int classement_universite;
    private String type_universite;
    private String accreditations;
    private String programmes_offerts;
    private String bourses_disponibles;
    private String installations;
    private String partenariats_internationaux;
    private BigDecimal taux_acceptation;
    private BigDecimal taux_diplomation;
    private BigDecimal taux_emploi;

    public Universite() {

    }

    public Universite(int id, String nom, String emplacement, String description, Timestamp date_ajoutee, String statut, String logo, String site_web, String numero_contact, String email_contact, String adresse_postale, String cours_offerts, Date date_limite_application, BigDecimal frais_scolarite, int nombre_etudiants, int nombre_professeurs, int classement_universite, String type_universite, String accreditations, String programmes_offerts, String bourses_disponibles, String installations, String partenariats_internationaux, BigDecimal taux_acceptation, BigDecimal taux_diplomation, BigDecimal taux_emploi) {
        this.id = id;
        this.nom = nom;
        this.emplacement = emplacement;
        this.description = description;
        this.date_ajoutee = date_ajoutee;
        this.statut = statut;
        this.logo = logo;
        this.site_web = site_web;
        this.numero_contact = numero_contact;
        this.email_contact = email_contact;
        this.adresse_postale = adresse_postale;
        this.cours_offerts = cours_offerts;
        this.date_limite_application = date_limite_application;
        this.frais_scolarite = frais_scolarite;
        this.nombre_etudiants = nombre_etudiants;
        this.nombre_professeurs = nombre_professeurs;
        this.classement_universite = classement_universite;
        this.type_universite = type_universite;
        this.accreditations = accreditations;
        this.programmes_offerts = programmes_offerts;
        this.bourses_disponibles = bourses_disponibles;
        this.installations = installations;
        this.partenariats_internationaux = partenariats_internationaux;
        this.taux_acceptation = taux_acceptation;
        this.taux_diplomation = taux_diplomation;
        this.taux_emploi = taux_emploi;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getDate_ajoutee() {
        return date_ajoutee;
    }

    public void setDate_ajoutee(Timestamp date_ajoutee) {
        this.date_ajoutee = date_ajoutee;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSite_web() {
        return site_web;
    }

    public void setSite_web(String site_web) {
        this.site_web = site_web;
    }

    public String getNumero_contact() {
        return numero_contact;
    }

    public void setNumero_contact(String numero_contact) {
        this.numero_contact = numero_contact;
    }

    public String getEmail_contact() {
        return email_contact;
    }

    public void setEmail_contact(String email_contact) {
        this.email_contact = email_contact;
    }

    public String getAdresse_postale() {
        return adresse_postale;
    }

    public void setAdresse_postale(String adresse_postale) {
        this.adresse_postale = adresse_postale;
    }

    public String getCours_offerts() {
        return cours_offerts;
    }

    public void setCours_offerts(String cours_offerts) {
        this.cours_offerts = cours_offerts;
    }

    public Date getDate_limite_application() {
        return date_limite_application;
    }

    public void setDate_limite_application(Date date_limite_application) {
        this.date_limite_application = date_limite_application;
    }

    public BigDecimal getFrais_scolarite() {
        return frais_scolarite;
    }

    public void setFrais_scolarite(BigDecimal frais_scolarite) {
        this.frais_scolarite = frais_scolarite;
    }

    public int getNombre_etudiants() {
        return nombre_etudiants;
    }

    public void setNombre_etudiants(int nombre_etudiants) {
        this.nombre_etudiants = nombre_etudiants;
    }

    public int getNombre_professeurs() {
        return nombre_professeurs;
    }

    public void setNombre_professeurs(int nombre_professeurs) {
        this.nombre_professeurs = nombre_professeurs;
    }

    public int getClassement_universite() {
        return classement_universite;
    }

    public void setClassement_universite(int classement_universite) {
        this.classement_universite = classement_universite;
    }

    public String getType_universite() {
        return type_universite;
    }

    public void setType_universite(String type_universite) {
        this.type_universite = type_universite;
    }

    public String getAccreditations() {
        return accreditations;
    }

    public void setAccreditations(String accreditations) {
        this.accreditations = accreditations;
    }

    public String getProgrammes_offerts() {
        return programmes_offerts;
    }

    public void setProgrammes_offerts(String programmes_offerts) {
        this.programmes_offerts = programmes_offerts;
    }

    public String getBourses_disponibles() {
        return bourses_disponibles;
    }

    public void setBourses_disponibles(String bourses_disponibles) {
        this.bourses_disponibles = bourses_disponibles;
    }

    public String getInstallations() {
        return installations;
    }

    public void setInstallations(String installations) {
        this.installations = installations;
    }

    public String getPartenariats_internationaux() {
        return partenariats_internationaux;
    }

    public void setPartenariats_internationaux(String partenariats_internationaux) {
        this.partenariats_internationaux = partenariats_internationaux;
    }

    public BigDecimal getTaux_acceptation() {
        return taux_acceptation;
    }

    public void setTaux_acceptation(BigDecimal taux_acceptation) {
        this.taux_acceptation = taux_acceptation;
    }

    public BigDecimal getTaux_diplomation() {
        return taux_diplomation;
    }

    public void setTaux_diplomation(BigDecimal taux_diplomation) {
        this.taux_diplomation = taux_diplomation;
    }

    public BigDecimal getTaux_emploi() {
        return taux_emploi;
    }

    public void setTaux_emploi(BigDecimal taux_emploi) {
        this.taux_emploi = taux_emploi;
    }
}