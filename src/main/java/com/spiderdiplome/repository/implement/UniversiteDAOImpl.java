package com.spiderdiplome.repository.implement;

import com.spiderdiplome.database.DatabaseConnection;
import com.spiderdiplome.models.Universite;
import com.spiderdiplome.repository.dao.UniversiteDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UniversiteDAOImpl implements UniversiteDAO {
    private Connection connection;

    public UniversiteDAOImpl() {
        this.connection = connection;
    }

    @Override
    public Universite findById(int id) {
        Universite universite = null;
        String sql = "SELECT * FROM universites WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                universite = new Universite();
                universite.setId(resultSet.getInt("id"));
                universite.setNom(resultSet.getString("nom"));
                universite.setEmplacement(resultSet.getString("emplacement"));
                universite.setDescription(resultSet.getString("description"));
                universite.setDate_ajoutee(resultSet.getTimestamp("date_ajoutee"));
                universite.setStatut(resultSet.getString("statut"));
                universite.setLogo(resultSet.getString("logo"));
                universite.setSite_web(resultSet.getString("site_web"));
                universite.setNumero_contact(resultSet.getString("numero_contact"));
                universite.setEmail_contact(resultSet.getString("email_contact"));
                universite.setAdresse_postale(resultSet.getString("adresse_postale"));
                universite.setCours_offerts(resultSet.getString("cours_offerts"));
                universite.setDate_limite_application(resultSet.getDate("date_limite_application"));
                universite.setFrais_scolarite(resultSet.getBigDecimal("frais_scolarite"));
                universite.setNombre_etudiants(resultSet.getInt("nombre_etudiants"));
                universite.setNombre_professeurs(resultSet.getInt("nombre_professeurs"));
                universite.setClassement_universite(resultSet.getInt("classement_universite"));
                universite.setType_universite(resultSet.getString("type_universite"));
                universite.setAccreditations(resultSet.getString("accreditations"));
                universite.setProgrammes_offerts(resultSet.getString("programmes_offerts"));
                universite.setBourses_disponibles(resultSet.getString("bourses_disponibles"));
                universite.setInstallations(resultSet.getString("installations"));
                universite.setPartenariats_internationaux(resultSet.getString("partenariats_internationaux"));
                universite.setTaux_acceptation(resultSet.getBigDecimal("taux_acceptation"));
                universite.setTaux_diplomation(resultSet.getBigDecimal("taux_diplomation"));
                universite.setTaux_emploi(resultSet.getBigDecimal("taux_emploi"));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche de l'universite par ID : " + e.getMessage());
        }

        return universite;
    }

    @Override
    public List<Universite> findAll() {
        List<Universite> universites = new ArrayList<>();
        String sql = "SELECT * FROM universites";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Universite universite = new Universite();
                universite.setId(resultSet.getInt("id"));
                universite.setNom(resultSet.getString("nom"));
                universite.setEmplacement(resultSet.getString("emplacement"));
                universite.setDescription(resultSet.getString("description"));
                universite.setDate_ajoutee(resultSet.getTimestamp("date_ajoutee"));
                universite.setStatut(resultSet.getString("statut"));
                universite.setLogo(resultSet.getString("logo"));
                universite.setSite_web(resultSet.getString("site_web"));
                universite.setNumero_contact(resultSet.getString("numero_contact"));
                universite.setEmail_contact(resultSet.getString("email_contact"));
                universite.setAdresse_postale(resultSet.getString("adresse_postale"));
                universite.setCours_offerts(resultSet.getString("cours_offerts"));
                universite.setDate_limite_application(resultSet.getDate("date_limite_application"));
                universite.setFrais_scolarite(resultSet.getBigDecimal("frais_scolarite"));
                universite.setNombre_etudiants(resultSet.getInt("nombre_etudiants"));
                universite.setNombre_professeurs(resultSet.getInt("nombre_professeurs"));
                universite.setClassement_universite(resultSet.getInt("classement_universite"));
                universite.setType_universite(resultSet.getString("type_universite"));
                universite.setAccreditations(resultSet.getString("accreditations"));
                universite.setProgrammes_offerts(resultSet.getString("programmes_offerts"));
                universite.setBourses_disponibles(resultSet.getString("bourses_disponibles"));
                universite.setInstallations(resultSet.getString("installations"));
                universite.setPartenariats_internationaux(resultSet.getString("partenariats_internationaux"));
                universite.setTaux_acceptation(resultSet.getBigDecimal("taux_acceptation"));
                universite.setTaux_diplomation(resultSet.getBigDecimal("taux_diplomation"));
                universite.setTaux_emploi(resultSet.getBigDecimal("taux_emploi"));
                universites.add(universite);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche de toutes les universites : " + e.getMessage());
        }

        return universites;
    }

    @Override
    public void save(Universite universite) {
        String sql = "INSERT INTO universites (nom, emplacement, description, date_ajoutee, statut, logo, site_web, numero_contact, email_contact, adresse_postale, cours_offerts, date_limite_application, frais_scolarite, nombre_etudiants, nombre_professeurs, classement_universite, type_universite, accreditations, programmes_offerts, bourses_disponibles, installations, partenariats_internationaux, taux_acceptation, taux_diplomation, taux_emploi) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, universite.getNom());
            statement.setString(2, universite.getEmplacement());
            statement.setString(3, universite.getDescription());
            statement.setTimestamp(4, universite.getDate_ajoutee());
            statement.setString(5, universite.getStatut());
            statement.setString(6, universite.getLogo());
            statement.setString(7, universite.getSite_web());
            statement.setString(8, universite.getNumero_contact());
            statement.setString(9, universite.getEmail_contact());
            statement.setString(10, universite.getAdresse_postale());
            statement.setString(11, universite.getCours_offerts());
            statement.setDate(12, universite.getDate_limite_application());
            statement.setBigDecimal(13, universite.getFrais_scolarite());
            statement.setInt(14, universite.getNombre_etudiants());
            statement.setInt(15, universite.getNombre_professeurs());
            statement.setInt(16, universite.getClassement_universite());
            statement.setString(17, universite.getType_universite());
            statement.setString(18, universite.getAccreditations());
            statement.setString(19, universite.getProgrammes_offerts());
            statement.setString(20, universite.getBourses_disponibles());
            statement.setString(21, universite.getInstallations());
            statement.setString(22, universite.getPartenariats_internationaux());
            statement.setBigDecimal(23, universite.getTaux_acceptation());
            statement.setBigDecimal(24, universite.getTaux_diplomation());
            statement.setBigDecimal(25, universite.getTaux_emploi());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'insertion de l'universite : " + e.getMessage());
        }
    }

    @Override
    public void update(Universite universite) {
        String sql = "UPDATE universites SET nom = ?, emplacement = ?, description = ?, date_ajoutee = ?, statut = ?, logo = ?, site_web = ?, numero_contact = ?, email_contact = ?, adresse_postale = ?, cours_offerts = ?, date_limite_application = ?, frais_scolarite = ?, nombre_etudiants = ?, nombre_professeurs = ?, classement_universite = ?, type_universite = ?, accreditations = ?, programmes_offerts = ?, bourses_disponibles = ?, installations = ?, partenariats_internationaux = ?, taux_acceptation = ?, taux_diplomation = ?, taux_emploi = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, universite.getNom());
            statement.setString(2, universite.getEmplacement());
            statement.setString(3, universite.getDescription());
            statement.setTimestamp(4, universite.getDate_ajoutee());
            statement.setString(5, universite.getStatut());
            statement.setString(6, universite.getLogo());
            statement.setString(7, universite.getSite_web());
            statement.setString(8, universite.getNumero_contact());
            statement.setString(9, universite.getEmail_contact());
            statement.setString(10, universite.getAdresse_postale());
            statement.setString(11, universite.getCours_offerts());
            statement.setDate(12, universite.getDate_limite_application());
            statement.setBigDecimal(13, universite.getFrais_scolarite());
            statement.setInt(14, universite.getNombre_etudiants());
            statement.setInt(15, universite.getNombre_professeurs());
            statement.setInt(16, universite.getClassement_universite());
            statement.setString(17, universite.getType_universite());
            statement.setString(18, universite.getAccreditations());
            statement.setString(19, universite.getProgrammes_offerts());
            statement.setString(20, universite.getBourses_disponibles());
            statement.setString(21, universite.getInstallations());
            statement.setString(22, universite.getPartenariats_internationaux());
            statement.setBigDecimal(23, universite.getTaux_acceptation());
            statement.setBigDecimal(24, universite.getTaux_diplomation());
            statement.setBigDecimal(25, universite.getTaux_emploi());
            statement.setInt(26, universite.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour de l'universite : " + e.getMessage());
        }
    }

    @Override
    public void delete(Universite universite) {
        String sql = "DELETE FROM universites WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, universite.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de l'universite : " + e.getMessage());
        }
    }
}
