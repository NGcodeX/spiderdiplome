package com.spiderdiplome.repository.dao;

import com.spiderdiplome.models.Utilisateur;

import java.sql.Timestamp;
import java.util.List;

public interface UtilisateurDAO {
    void save(Utilisateur utilisateur);
    boolean create(Utilisateur utilisateur);
    Utilisateur read(int id);
    List<Utilisateur> readAll();
    void update(Utilisateur utilisateur);
    void delete(int id);
    void deleteByMatricule(String matricule);
    Utilisateur findByMatricule(String matricule);
    Utilisateur findByPhone(String phone);
    void updateSalt(String matricule, String salt);
    Utilisateur findByEmail(String email);
    List<Utilisateur> findByRole(String role);
    void updatePassword(String matricule, String newPassword);
    void updateProfilePicture(String matricule, String newProfilePicture);
    List<Utilisateur> findByStatus(int status);
    void updateStatus(String matricule, int newStatus);
    List<Utilisateur> findByDateInscription(Timestamp dateInscription);
    void updateBio(String matricule, String newBio);
    Utilisateur findByMatriculeAndPassword(String matricule, String password);
    String findSaltByMatricule(String matricule);
    Utilisateur findByMatriculeAndEmail(String matricule, String email);
    void refreshUser(Utilisateur utilisateur);
    Utilisateur findByNomAndPrenom(String nom, String prenom);
    void updateEmail(String matricule, String newEmail);
    void updatePhone(String matricule, String newPhone);
    List<Utilisateur> findByDateCreation(Timestamp dateCreation);
    List<Utilisateur> findByDateModification(Timestamp dateModification);
    List<Utilisateur> findByGenre(String genre);
    void updateGenre(String matricule, String newGenre);
    List<Utilisateur> findByAdresse(String adresse);
    void updateAdresse(String matricule, String newAdresse);
}