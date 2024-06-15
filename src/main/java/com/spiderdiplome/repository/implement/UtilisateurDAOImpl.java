package com.spiderdiplome.repository.implement;

import com.spiderdiplome.database.DatabaseConnection;
import com.spiderdiplome.models.Utilisateur;
import com.spiderdiplome.repository.dao.UtilisateurDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurDAOImpl implements UtilisateurDAO {

    @Override
    public void save(Utilisateur utilisateur) {
        if (utilisateur.getId() == 0) {
            create(utilisateur);
        } else {
            update(utilisateur);
        }
    }

    @Override
    public boolean create(Utilisateur utilisateur) {
    String sql = "INSERT INTO utilisateurs (nom, prenom, email, phone, matricule, motdepasse, role, dateinscription, statut, datecreation, derniereconnexion, datemodification, datenaissance, genre, photoprofil, bio, adresse, salt) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    int rowsAffected = 0;

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setString(1, utilisateur.getNom());
        statement.setString(2, utilisateur.getPrenom());
        statement.setString(3, utilisateur.getEmail());
        statement.setString(4, utilisateur.getPhone());
        statement.setString(5, utilisateur.getMatricule());
        statement.setString(6, utilisateur.getMotDePasse());
        statement.setString(7, utilisateur.getRole() != null ? utilisateur.getRole() : "candidatpotentiel");
        statement.setTimestamp(8, utilisateur.getDateInscription() != null ? utilisateur.getDateInscription() : new Timestamp(System.currentTimeMillis()));
        statement.setInt(9, utilisateur.getStatut() != 1 ? utilisateur.getStatut() : 1);
        statement.setTimestamp(10, utilisateur.getDateCreation() != null ? utilisateur.getDateCreation() : new Timestamp(System.currentTimeMillis()));
        statement.setTimestamp(11, utilisateur.getDerniereConnexion());
        statement.setTimestamp(12, utilisateur.getDateModification());
        statement.setDate(13, utilisateur.getDateNaissance() != null ? new java.sql.Date(utilisateur.getDateNaissance().getTime()) : null);
        statement.setString(14, utilisateur.getGenre() != null ? utilisateur.getGenre() : "autre");
        statement.setString(15, utilisateur.getPhotoProfil() != null ? utilisateur.getPhotoProfil() : "");
        statement.setString(16, utilisateur.getBio() != null ? utilisateur.getBio() : "");
        statement.setString(17, utilisateur.getAdresse() != null ? utilisateur.getAdresse() : "");
        statement.setString(18, utilisateur.getSalt());

        rowsAffected = statement.executeUpdate();
    } catch (SQLException e) {
        System.err.println("Erreur lors de la création de l'utilisateur : " + e.getMessage());
    }

    return rowsAffected > 0;
}

    @Override
    public Utilisateur read(int id) {
        Utilisateur utilisateur = null;
        String sql = "SELECT * FROM utilisateurs WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                utilisateur = new Utilisateur();
                utilisateur.setId(resultSet.getInt("id"));
                utilisateur.setNom(resultSet.getString("nom"));
                utilisateur.setPrenom(resultSet.getString("prenom"));
                utilisateur.setEmail(resultSet.getString("email"));
                utilisateur.setPhone(resultSet.getString("phone"));
                utilisateur.setMatricule(resultSet.getString("matricule"));
                utilisateur.setMotDePasse(resultSet.getString("motdepasse"));
                utilisateur.setRole(resultSet.getString("role"));
                utilisateur.setDateInscription(resultSet.getTimestamp("dateinscription"));
                utilisateur.setStatut(resultSet.getInt("statut"));
                utilisateur.setDateCreation(resultSet.getTimestamp("datecreation"));
                utilisateur.setDerniereConnexion(resultSet.getTimestamp("derniereconnexion"));
                utilisateur.setDateModification(resultSet.getTimestamp("datemodification"));
                utilisateur.setDateNaissance(resultSet.getDate("datenaissance"));
                utilisateur.setGenre(resultSet.getString("genre"));
                utilisateur.setPhotoProfil(resultSet.getString("photoprofil"));
                utilisateur.setBio(resultSet.getString("bio"));
                utilisateur.setAdresse(resultSet.getString("adresse"));
                utilisateur.setSalt(resultSet.getString("salt"));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la lecture de l'utilisateur : " + e.getMessage());
        }

        return utilisateur;
    }

    @Override
    public List<Utilisateur> readAll() {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        String sql = "SELECT * FROM utilisateurs";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setId(resultSet.getInt("id"));
                utilisateur.setNom(resultSet.getString("nom"));
                utilisateur.setPrenom(resultSet.getString("prenom"));
                utilisateur.setEmail(resultSet.getString("email"));
                utilisateur.setPhone(resultSet.getString("phone"));
                utilisateur.setMatricule(resultSet.getString("matricule"));
                utilisateur.setMotDePasse(resultSet.getString("motdepasse"));
                utilisateur.setRole(resultSet.getString("role"));
                utilisateur.setDateInscription(resultSet.getTimestamp("dateinscription"));
                utilisateur.setStatut(resultSet.getInt("statut"));
                utilisateur.setDateCreation(resultSet.getTimestamp("datecreation"));
                utilisateur.setDerniereConnexion(resultSet.getTimestamp("derniereconnexion"));
                utilisateur.setDateModification(resultSet.getTimestamp("datemodification"));
                utilisateur.setDateNaissance(resultSet.getDate("datenaissance"));
                utilisateur.setGenre(resultSet.getString("genre"));
                utilisateur.setPhotoProfil(resultSet.getString("photoprofil"));
                utilisateur.setBio(resultSet.getString("bio"));
                utilisateur.setAdresse(resultSet.getString("adresse"));
                utilisateur.setSalt(resultSet.getString("salt"));

                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la lecture des utilisateurs : " + e.getMessage());
        }

        return utilisateurs;
    }

@Override
public void update(Utilisateur utilisateur) {
    String sql = "UPDATE utilisateurs SET nom = ?, prenom = ?, phone = ?, matricule = ?, motdepasse = ?, role = ?, statut = ?, salt = ?, email = ? WHERE id = ?";

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setString(1, utilisateur.getNom());
        statement.setString(2, utilisateur.getPrenom());
        statement.setString(3, utilisateur.getPhone());
        statement.setString(4, utilisateur.getMatricule());
        statement.setString(5, utilisateur.getMotDePasse());
        statement.setString(6, utilisateur.getRole());
        statement.setInt(7, utilisateur.getStatut());
        statement.setString(8, utilisateur.getSalt());
        statement.setString(9, utilisateur.getEmail());
        statement.setInt(10, utilisateur.getId());

        statement.executeUpdate();
    } catch (SQLException e) {
        System.err.println("Erreur lors de la mise à jour de l'utilisateur : " + e.getMessage());
    }
}

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM utilisateurs WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de l'utilisateur : " + e.getMessage());
        }
    }

    @Override
public void deleteByMatricule(String matricule) {
    String sql = "DELETE FROM utilisateurs WHERE matricule = ?";

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setString(1, matricule);

        statement.executeUpdate();
    } catch (SQLException e) {
        System.err.println("Erreur lors de la suppression de l'utilisateur : " + e.getMessage());
    }
}

    @Override
public Utilisateur findByMatricule(String matricule) {
    Utilisateur utilisateur = null;
    String sql = "SELECT * FROM utilisateurs WHERE matricule = ?";

    Connection connection = null;
    PreparedStatement statement = null;
    try {
        connection = DatabaseConnection.getConnection();
        statement = connection.prepareStatement(sql);

        statement.setString(1, matricule);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            utilisateur = new Utilisateur();
            utilisateur.setId(resultSet.getInt("id"));
            utilisateur.setNom(resultSet.getString("nom"));
            utilisateur.setPrenom(resultSet.getString("prenom"));
            utilisateur.setEmail(resultSet.getString("email"));
            utilisateur.setPhone(resultSet.getString("phone"));
            utilisateur.setMatricule(resultSet.getString("matricule"));
            utilisateur.setMotDePasse(resultSet.getString("motdepasse"));
            utilisateur.setRole(resultSet.getString("role"));
            utilisateur.setDateInscription(resultSet.getTimestamp("dateinscription"));
            utilisateur.setStatut(resultSet.getInt("statut"));
            utilisateur.setDateCreation(resultSet.getTimestamp("datecreation"));
            utilisateur.setDerniereConnexion(resultSet.getTimestamp("derniereconnexion"));
            utilisateur.setDateModification(resultSet.getTimestamp("datemodification"));
            utilisateur.setDateNaissance(resultSet.getDate("datenaissance"));
            utilisateur.setGenre(resultSet.getString("genre"));
            utilisateur.setPhotoProfil(resultSet.getString("photoprofil"));
            utilisateur.setBio(resultSet.getString("bio"));
            utilisateur.setAdresse(resultSet.getString("adresse"));
            utilisateur.setSalt(resultSet.getString("salt"));
        }
    } catch (SQLException e) {
        System.err.println("Erreur lors de la recherche de l'utilisateur par matricule : " + e.getMessage());
    } finally {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.err.println("Erreur lors de la fermeture du PreparedStatement : " + e.getMessage());
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Erreur lors de la fermeture de la connexion à la base de données : " + e.getMessage());
            }
        }
    }

    return utilisateur;
}

@Override
public Utilisateur findByEmailOrPhoneOrMatricule(String emailOrPhoneOrMatricule) {
    String sql = "SELECT * FROM utilisateurs WHERE email = ? OR phone = ? OR matricule = ?";
    Utilisateur utilisateur = null;

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setString(1, emailOrPhoneOrMatricule);
        statement.setString(2, emailOrPhoneOrMatricule);
        statement.setString(3, emailOrPhoneOrMatricule);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            utilisateur = new Utilisateur();
            utilisateur.setId(resultSet.getInt("id"));
            utilisateur.setNom(resultSet.getString("nom"));
            utilisateur.setPrenom(resultSet.getString("prenom"));
            utilisateur.setEmail(resultSet.getString("email"));
            utilisateur.setPhone(resultSet.getString("phone"));
            utilisateur.setMatricule(resultSet.getString("matricule"));
            utilisateur.setMotDePasse(resultSet.getString("motdepasse"));
            utilisateur.setRole(resultSet.getString("role"));
            utilisateur.setDateInscription(resultSet.getTimestamp("dateinscription"));
            utilisateur.setStatut(resultSet.getInt("statut"));
            utilisateur.setDateCreation(resultSet.getTimestamp("datecreation"));
            utilisateur.setDerniereConnexion(resultSet.getTimestamp("derniereconnexion"));
            utilisateur.setDateModification(resultSet.getTimestamp("datemodification"));
            utilisateur.setDateNaissance(resultSet.getDate("datenaissance"));
            utilisateur.setGenre(resultSet.getString("genre"));
            utilisateur.setPhotoProfil(resultSet.getString("photoprofil"));
            utilisateur.setBio(resultSet.getString("bio"));
            utilisateur.setAdresse(resultSet.getString("adresse"));
            utilisateur.setSalt(resultSet.getString("salt"));
        }
    } catch (SQLException e) {
        System.err.println("Erreur lors de la recherche de l'utilisateur par email, téléphone ou matricule : " + e.getMessage());
    }

    return utilisateur;
}

    @Override
    public Utilisateur findByPhone(String phone) {
        Utilisateur utilisateur = null;
        String sql = "SELECT * FROM utilisateurs WHERE phone = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, phone);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                utilisateur = new Utilisateur();
                utilisateur.setId(resultSet.getInt("id"));
                utilisateur.setNom(resultSet.getString("nom"));
                utilisateur.setPrenom(resultSet.getString("prenom"));
                utilisateur.setEmail(resultSet.getString("email"));
                utilisateur.setPhone(resultSet.getString("phone"));
                utilisateur.setMatricule(resultSet.getString("matricule"));
                utilisateur.setMotDePasse(resultSet.getString("motdepasse"));
                utilisateur.setRole(resultSet.getString("role"));
                utilisateur.setDateInscription(resultSet.getTimestamp("dateinscription"));
                utilisateur.setStatut(resultSet.getInt("statut"));
                utilisateur.setDateCreation(resultSet.getTimestamp("datecreation"));
                utilisateur.setDerniereConnexion(resultSet.getTimestamp("derniereconnexion"));
                utilisateur.setDateModification(resultSet.getTimestamp("datemodification"));
                utilisateur.setDateNaissance(resultSet.getDate("datenaissance"));
                utilisateur.setGenre(resultSet.getString("genre"));
                utilisateur.setPhotoProfil(resultSet.getString("photoprofil"));
                utilisateur.setBio(resultSet.getString("bio"));
                utilisateur.setAdresse(resultSet.getString("adresse"));
                utilisateur.setSalt(resultSet.getString("salt"));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche de l'utilisateur par téléphone : " + e.getMessage());
        }

        return utilisateur;
    }

    @Override
    public void updateSalt(String matricule, String salt) {
        String sql = "UPDATE utilisateurs SET salt = ? WHERE matricule = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, salt);
            statement.setString(2, matricule);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour du salt de l'utilisateur : " + e.getMessage());
        }
    }

    @Override
    public Utilisateur findByEmail(String email) {
        Utilisateur utilisateur = null;
        String sql = "SELECT * FROM utilisateurs WHERE email = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                utilisateur = new Utilisateur();
                utilisateur.setId(resultSet.getInt("id"));
                utilisateur.setNom(resultSet.getString("nom"));
                utilisateur.setPrenom(resultSet.getString("prenom"));
                utilisateur.setEmail(resultSet.getString("email"));
                utilisateur.setPhone(resultSet.getString("phone"));
                utilisateur.setMatricule(resultSet.getString("matricule"));
                utilisateur.setMotDePasse(resultSet.getString("motdepasse"));
                utilisateur.setRole(resultSet.getString("role"));
                utilisateur.setDateInscription(resultSet.getTimestamp("dateinscription"));
                utilisateur.setStatut(resultSet.getInt("statut"));
                utilisateur.setDateCreation(resultSet.getTimestamp("datecreation"));
                utilisateur.setDerniereConnexion(resultSet.getTimestamp("derniereconnexion"));
                utilisateur.setDateModification(resultSet.getTimestamp("datemodification"));
                utilisateur.setDateNaissance(resultSet.getDate("datenaissance"));
                utilisateur.setGenre(resultSet.getString("genre"));
                utilisateur.setPhotoProfil(resultSet.getString("photoprofil"));
                utilisateur.setBio(resultSet.getString("bio"));
                utilisateur.setAdresse(resultSet.getString("adresse"));
                utilisateur.setSalt(resultSet.getString("salt"));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche de l'utilisateur par email : " + e.getMessage());
        }

        return utilisateur;
    }

    @Override
    public List<Utilisateur> findByRole(String role) {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        String sql = "SELECT * FROM utilisateurs WHERE role = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, role);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setId(resultSet.getInt("id"));
                utilisateur.setNom(resultSet.getString("nom"));
                utilisateur.setPrenom(resultSet.getString("prenom"));
                utilisateur.setEmail(resultSet.getString("email"));
                utilisateur.setPhone(resultSet.getString("phone"));
                utilisateur.setMatricule(resultSet.getString("matricule"));
                utilisateur.setMotDePasse(resultSet.getString("motdepasse"));
                utilisateur.setRole(resultSet.getString("role"));
                utilisateur.setDateInscription(resultSet.getTimestamp("dateinscription"));
                utilisateur.setStatut(resultSet.getInt("statut"));
                utilisateur.setDateCreation(resultSet.getTimestamp("datecreation"));
                utilisateur.setDerniereConnexion(resultSet.getTimestamp("derniereconnexion"));
                utilisateur.setDateModification(resultSet.getTimestamp("datemodification"));
                utilisateur.setDateNaissance(resultSet.getDate("datenaissance"));
                utilisateur.setGenre(resultSet.getString("genre"));
                utilisateur.setPhotoProfil(resultSet.getString("photoprofil"));
                utilisateur.setBio(resultSet.getString("bio"));
                utilisateur.setAdresse(resultSet.getString("adresse"));
                utilisateur.setSalt(resultSet.getString("salt"));

                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche des utilisateurs par role : " + e.getMessage());
        }

        return utilisateurs;
    }

    @Override
    public void updatePassword(String matricule, String newPassword) {
        String sql = "UPDATE utilisateurs SET motdepasse = ? WHERE matricule = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, newPassword);
            statement.setString(2, matricule);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour du mot de passe de l'utilisateur : " + e.getMessage());
        }
    }

    @Override
    public void updateProfilePicture(String matricule, String newProfilePicture) {
        String sql = "UPDATE utilisateurs SET photoprofil = ? WHERE matricule = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, newProfilePicture);
            statement.setString(2, matricule);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour de la photo de profil de l'utilisateur : " + e.getMessage());
        }
    }

    @Override
    public List<Utilisateur> findByStatus(int status) {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        String sql = "SELECT * FROM utilisateurs WHERE statut = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, status);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setId(resultSet.getInt("id"));
                utilisateur.setNom(resultSet.getString("nom"));
                utilisateur.setPrenom(resultSet.getString("prenom"));
                utilisateur.setEmail(resultSet.getString("email"));
                utilisateur.setPhone(resultSet.getString("phone"));
                utilisateur.setMatricule(resultSet.getString("matricule"));
                utilisateur.setMotDePasse(resultSet.getString("motdepasse"));
                utilisateur.setRole(resultSet.getString("role"));
                utilisateur.setDateInscription(resultSet.getTimestamp("dateinscription"));
                utilisateur.setStatut(resultSet.getInt("statut"));
                utilisateur.setDateCreation(resultSet.getTimestamp("datecreation"));
                utilisateur.setDerniereConnexion(resultSet.getTimestamp("derniereconnexion"));
                utilisateur.setDateModification(resultSet.getTimestamp("datemodification"));
                utilisateur.setDateNaissance(resultSet.getDate("datenaissance"));
                utilisateur.setGenre(resultSet.getString("genre"));
                utilisateur.setPhotoProfil(resultSet.getString("photoprofil"));
                utilisateur.setBio(resultSet.getString("bio"));
                utilisateur.setAdresse(resultSet.getString("adresse"));
                utilisateur.setSalt(resultSet.getString("salt"));

                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche des utilisateurs par statut : " + e.getMessage());
        }

        return utilisateurs;
    }

    @Override
    public void updateStatus(String matricule, int newStatus) {
        String sql = "UPDATE utilisateurs SET statut = ? WHERE matricule = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, newStatus);
            statement.setString(2, matricule);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour du statut de l'utilisateur : " + e.getMessage());
        }
    }

    @Override
    public List<Utilisateur> findByDateInscription(Timestamp dateInscription) {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        String sql = "SELECT * FROM utilisateurs WHERE dateinscription = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setTimestamp(1, dateInscription);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setId(resultSet.getInt("id"));
                utilisateur.setNom(resultSet.getString("nom"));
                utilisateur.setPrenom(resultSet.getString("prenom"));
                utilisateur.setEmail(resultSet.getString("email"));
                utilisateur.setPhone(resultSet.getString("phone"));
                utilisateur.setMatricule(resultSet.getString("matricule"));
                utilisateur.setMotDePasse(resultSet.getString("motdepasse"));
                utilisateur.setRole(resultSet.getString("role"));
                utilisateur.setDateInscription(resultSet.getTimestamp("dateinscription"));
                utilisateur.setStatut(resultSet.getInt("statut"));
                utilisateur.setDateCreation(resultSet.getTimestamp("datecreation"));
                utilisateur.setDerniereConnexion(resultSet.getTimestamp("derniereconnexion"));
                utilisateur.setDateModification(resultSet.getTimestamp("datemodification"));
                utilisateur.setDateNaissance(resultSet.getDate("datenaissance"));
                utilisateur.setGenre(resultSet.getString("genre"));
                utilisateur.setPhotoProfil(resultSet.getString("photoprofil"));
                utilisateur.setBio(resultSet.getString("bio"));
                utilisateur.setAdresse(resultSet.getString("adresse"));
                utilisateur.setSalt(resultSet.getString("salt"));

                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche des utilisateurs par date d'inscription : " + e.getMessage());
        }

        return utilisateurs;
    }

    @Override
    public void updateBio(String matricule, String newBio) {
        String sql = "UPDATE utilisateurs SET bio = ? WHERE matricule = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, newBio);
            statement.setString(2, matricule);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour de la bio de l'utilisateur : " + e.getMessage());
        }
    }

    @Override
    public Utilisateur findByMatriculeAndPassword(String matricule, String password) {
        Utilisateur utilisateur = null;
        String sql = "SELECT * FROM utilisateurs WHERE matricule = ? AND motdepasse = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, matricule);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                utilisateur = new Utilisateur();
                utilisateur.setId(resultSet.getInt("id"));
                utilisateur.setNom(resultSet.getString("nom"));
                utilisateur.setPrenom(resultSet.getString("prenom"));
                utilisateur.setEmail(resultSet.getString("email"));
                utilisateur.setPhone(resultSet.getString("phone"));
                utilisateur.setMatricule(resultSet.getString("matricule"));
                utilisateur.setMotDePasse(resultSet.getString("motdepasse"));
                utilisateur.setRole(resultSet.getString("role"));
                utilisateur.setDateInscription(resultSet.getTimestamp("dateinscription"));
                utilisateur.setStatut(resultSet.getInt("statut"));
                utilisateur.setDateCreation(resultSet.getTimestamp("datecreation"));
                utilisateur.setDerniereConnexion(resultSet.getTimestamp("derniereconnexion"));
                utilisateur.setDateModification(resultSet.getTimestamp("datemodification"));
                utilisateur.setDateNaissance(resultSet.getDate("datenaissance"));
                utilisateur.setGenre(resultSet.getString("genre"));
                utilisateur.setPhotoProfil(resultSet.getString("photoprofil"));
                utilisateur.setBio(resultSet.getString("bio"));
                utilisateur.setAdresse(resultSet.getString("adresse"));
                utilisateur.setSalt(resultSet.getString("salt"));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche de l'utilisateur par matricule et mot de passe : " + e.getMessage());
        }

        return utilisateur;
    }

    @Override
    public String findSaltByMatricule(String matricule) {
        String salt = null;
        String sql = "SELECT salt FROM utilisateurs WHERE matricule = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, matricule);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                salt = resultSet.getString("salt");
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche du salt de l'utilisateur par matricule : " + e.getMessage());
        }

        return salt;
    }

    @Override
    public Utilisateur findByMatriculeAndEmail(String matricule, String email) {
        Utilisateur utilisateur = null;
        String sql = "SELECT * FROM utilisateurs WHERE matricule = ? AND email = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, matricule);
            statement.setString(2, email);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                utilisateur = new Utilisateur();
                utilisateur.setId(resultSet.getInt("id"));
                utilisateur.setNom(resultSet.getString("nom"));
                utilisateur.setPrenom(resultSet.getString("prenom"));
                utilisateur.setEmail(resultSet.getString("email"));
                utilisateur.setPhone(resultSet.getString("phone"));
                utilisateur.setMatricule(resultSet.getString("matricule"));
                utilisateur.setMotDePasse(resultSet.getString("motdepasse"));
                utilisateur.setRole(resultSet.getString("role"));
                utilisateur.setDateInscription(resultSet.getTimestamp("dateinscription"));
                utilisateur.setStatut(resultSet.getInt("statut"));
                utilisateur.setDateCreation(resultSet.getTimestamp("datecreation"));
                utilisateur.setDerniereConnexion(resultSet.getTimestamp("derniereconnexion"));
                utilisateur.setDateModification(resultSet.getTimestamp("datemodification"));
                utilisateur.setDateNaissance(resultSet.getDate("datenaissance"));
                utilisateur.setGenre(resultSet.getString("genre"));
                utilisateur.setPhotoProfil(resultSet.getString("photoprofil"));
                utilisateur.setBio(resultSet.getString("bio"));
                utilisateur.setAdresse(resultSet.getString("adresse"));
                utilisateur.setSalt(resultSet.getString("salt"));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche de l'utilisateur par matricule et email : " + e.getMessage());
        }

        return utilisateur;
    }

    @Override
    public void refreshUser(Utilisateur utilisateur) {
        String sql = "UPDATE utilisateurs SET nom = ?, prenom = ?, email = ?, phone = ?, motdepasse = ?, role = ?, dateinscription = ?, statut = ?, datecreation = ?, derniereconnexion = ?, datemodification = ?, datenaissance = ?, genre = ?, photoprofil = ?, bio = ?, adresse = ?, salt = ? WHERE matricule = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, utilisateur.getNom());
            statement.setString(2, utilisateur.getPrenom());
            statement.setString(3, utilisateur.getEmail());
            statement.setString(4, utilisateur.getPhone());
            statement.setString(5, utilisateur.getMotDePasse());
            statement.setString(6, utilisateur.getRole());
            statement.setTimestamp(7, utilisateur.getDateInscription());
            statement.setInt(8, utilisateur.getStatut());
            statement.setTimestamp(9, utilisateur.getDateCreation());
            statement.setTimestamp(10, utilisateur.getDerniereConnexion());
            statement.setTimestamp(11, utilisateur.getDateModification());
            statement.setDate(12, (Date) utilisateur.getDateNaissance());
            statement.setString(13, utilisateur.getGenre());
            statement.setString(14, utilisateur.getPhotoProfil());
            statement.setString(15, utilisateur.getBio());
            statement.setString(16, utilisateur.getAdresse());
            statement.setString(17, utilisateur.getSalt());
            statement.setString(18, utilisateur.getMatricule());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour de l'utilisateur : " + e.getMessage());
        }
    }

    @Override
    public Utilisateur findByNomAndPrenom(String nom, String prenom) {
        Utilisateur utilisateur = null;
        String sql = "SELECT * FROM utilisateurs WHERE nom = ? AND prenom = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, nom);
            statement.setString(2, prenom);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                utilisateur = new Utilisateur();
                utilisateur.setId(resultSet.getInt("id"));
                utilisateur.setNom(resultSet.getString("nom"));
                utilisateur.setPrenom(resultSet.getString("prenom"));
                utilisateur.setEmail(resultSet.getString("email"));
                utilisateur.setPhone(resultSet.getString("phone"));
                utilisateur.setMatricule(resultSet.getString("matricule"));
                utilisateur.setMotDePasse(resultSet.getString("motdepasse"));
                utilisateur.setRole(resultSet.getString("role"));
                utilisateur.setDateInscription(resultSet.getTimestamp("dateinscription"));
                utilisateur.setStatut(resultSet.getInt("statut"));
                utilisateur.setDateCreation(resultSet.getTimestamp("datecreation"));
                utilisateur.setDerniereConnexion(resultSet.getTimestamp("derniereconnexion"));
                utilisateur.setDateModification(resultSet.getTimestamp("datemodification"));
                utilisateur.setDateNaissance(resultSet.getDate("datenaissance"));
                utilisateur.setGenre(resultSet.getString("genre"));
                utilisateur.setPhotoProfil(resultSet.getString("photoprofil"));
                utilisateur.setBio(resultSet.getString("bio"));
                utilisateur.setAdresse(resultSet.getString("adresse"));
                utilisateur.setSalt(resultSet.getString("salt"));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche de l'utilisateur par nom et prenom : " + e.getMessage());
        }

        return utilisateur;
    }

    @Override
    public void updateEmail(String matricule, String newEmail) {
        String sql = "UPDATE utilisateurs SET email = ? WHERE matricule = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, newEmail);
            statement.setString(2, matricule);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour de l'email de l'utilisateur : " + e.getMessage());
        }
    }

    @Override
    public void updatePhone(String matricule, String newPhone) {
        String sql = "UPDATE utilisateurs SET phone = ? WHERE matricule = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, newPhone);
            statement.setString(2, matricule);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour du téléphone de l'utilisateur : " + e.getMessage());
        }
    }

    @Override
    public List<Utilisateur> findByDateCreation(Timestamp dateCreation) {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        String sql = "SELECT * FROM utilisateurs WHERE datecreation = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setTimestamp(1, dateCreation);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setId(resultSet.getInt("id"));
                utilisateur.setNom(resultSet.getString("nom"));
                utilisateur.setPrenom(resultSet.getString("prenom"));
                utilisateur.setEmail(resultSet.getString("email"));
                utilisateur.setPhone(resultSet.getString("phone"));
                utilisateur.setMatricule(resultSet.getString("matricule"));
                utilisateur.setMotDePasse(resultSet.getString("motdepasse"));
                utilisateur.setRole(resultSet.getString("role"));
                utilisateur.setDateInscription(resultSet.getTimestamp("dateinscription"));
                utilisateur.setStatut(resultSet.getInt("statut"));
                utilisateur.setDateCreation(resultSet.getTimestamp("datecreation"));
                utilisateur.setDerniereConnexion(resultSet.getTimestamp("derniereconnexion"));
                utilisateur.setDateModification(resultSet.getTimestamp("datemodification"));
                utilisateur.setDateNaissance(resultSet.getDate("datenaissance"));
                utilisateur.setGenre(resultSet.getString("genre"));
                utilisateur.setPhotoProfil(resultSet.getString("photoprofil"));
                utilisateur.setBio(resultSet.getString("bio"));
                utilisateur.setAdresse(resultSet.getString("adresse"));
                utilisateur.setSalt(resultSet.getString("salt"));

                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche des utilisateurs par date de création : " + e.getMessage());
        }

        return utilisateurs;
    }

    @Override
    public List<Utilisateur> findByDateModification(Timestamp dateModification) {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        String sql = "SELECT * FROM utilisateurs WHERE datemodification = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setTimestamp(1, dateModification);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setId(resultSet.getInt("id"));
                utilisateur.setNom(resultSet.getString("nom"));
                utilisateur.setPrenom(resultSet.getString("prenom"));
                utilisateur.setEmail(resultSet.getString("email"));
                utilisateur.setPhone(resultSet.getString("phone"));
                utilisateur.setMatricule(resultSet.getString("matricule"));
                utilisateur.setMotDePasse(resultSet.getString("motdepasse"));
                utilisateur.setRole(resultSet.getString("role"));
                utilisateur.setDateInscription(resultSet.getTimestamp("dateinscription"));
                utilisateur.setStatut(resultSet.getInt("statut"));
                utilisateur.setDateCreation(resultSet.getTimestamp("datecreation"));
                utilisateur.setDerniereConnexion(resultSet.getTimestamp("derniereconnexion"));
                utilisateur.setDateModification(resultSet.getTimestamp("datemodification"));
                utilisateur.setDateNaissance(resultSet.getDate("datenaissance"));
                utilisateur.setGenre(resultSet.getString("genre"));
                utilisateur.setPhotoProfil(resultSet.getString("photoprofil"));
                utilisateur.setBio(resultSet.getString("bio"));
                utilisateur.setAdresse(resultSet.getString("adresse"));
                utilisateur.setSalt(resultSet.getString("salt"));

                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche des utilisateurs par date de modification : " + e.getMessage());
        }

        return utilisateurs;
    }

    @Override
    public List<Utilisateur> findByGenre(String genre) {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        String sql = "SELECT * FROM utilisateurs WHERE genre = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, genre);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setId(resultSet.getInt("id"));
                utilisateur.setNom(resultSet.getString("nom"));
                utilisateur.setPrenom(resultSet.getString("prenom"));
                utilisateur.setEmail(resultSet.getString("email"));
                utilisateur.setPhone(resultSet.getString("phone"));
                utilisateur.setMatricule(resultSet.getString("matricule"));
                utilisateur.setMotDePasse(resultSet.getString("motdepasse"));
                utilisateur.setRole(resultSet.getString("role"));
                utilisateur.setDateInscription(resultSet.getTimestamp("dateinscription"));
                utilisateur.setStatut(resultSet.getInt("statut"));
                utilisateur.setDateCreation(resultSet.getTimestamp("datecreation"));
                utilisateur.setDerniereConnexion(resultSet.getTimestamp("derniereconnexion"));
                utilisateur.setDateModification(resultSet.getTimestamp("datemodification"));
                utilisateur.setDateNaissance(resultSet.getDate("datenaissance"));
                utilisateur.setGenre(resultSet.getString("genre"));
                utilisateur.setPhotoProfil(resultSet.getString("photoprofil"));
                utilisateur.setBio(resultSet.getString("bio"));
                utilisateur.setAdresse(resultSet.getString("adresse"));
                utilisateur.setSalt(resultSet.getString("salt"));

                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche des utilisateurs par genre : " + e.getMessage());
        }

        return utilisateurs;
    }

    @Override
    public void updateGenre(String matricule, String newGenre) {
        String sql = "UPDATE utilisateurs SET genre = ? WHERE matricule = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, newGenre);
            statement.setString(2, matricule);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour du genre de l'utilisateur : " + e.getMessage());
        }
    }

    @Override
    public List<Utilisateur> findByAdresse(String adresse) {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        String sql = "SELECT * FROM utilisateurs WHERE adresse = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, adresse);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setId(resultSet.getInt("id"));
                utilisateur.setNom(resultSet.getString("nom"));
                utilisateur.setPrenom(resultSet.getString("prenom"));
                utilisateur.setEmail(resultSet.getString("email"));
                utilisateur.setPhone(resultSet.getString("phone"));
                utilisateur.setMatricule(resultSet.getString("matricule"));
                utilisateur.setMotDePasse(resultSet.getString("motdepasse"));
                utilisateur.setRole(resultSet.getString("role"));
                utilisateur.setDateInscription(resultSet.getTimestamp("dateinscription"));
                utilisateur.setStatut(resultSet.getInt("statut"));
                utilisateur.setDateCreation(resultSet.getTimestamp("datecreation"));
                utilisateur.setDerniereConnexion(resultSet.getTimestamp("derniereconnexion"));
                utilisateur.setDateModification(resultSet.getTimestamp("datemodification"));
                utilisateur.setDateNaissance(resultSet.getDate("datenaissance"));
                utilisateur.setGenre(resultSet.getString("genre"));
                utilisateur.setPhotoProfil(resultSet.getString("photoprofil"));
                utilisateur.setBio(resultSet.getString("bio"));
                utilisateur.setAdresse(resultSet.getString("adresse"));
                utilisateur.setSalt(resultSet.getString("salt"));

                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche des utilisateurs par adresse : " + e.getMessage());
        }

        return utilisateurs;
    }

    @Override
    public void updateAdresse(String matricule, String newAdresse) {
        String sql = "UPDATE utilisateurs SET adresse = ? WHERE matricule = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, newAdresse);
            statement.setString(2, matricule);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour de l'adresse de l'utilisateur : " + e.getMessage());
        }
    }


}