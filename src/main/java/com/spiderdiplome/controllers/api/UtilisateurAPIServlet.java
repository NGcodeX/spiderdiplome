package com.spiderdiplome.controllers.api;

import com.spiderdiplome.models.Utilisateur;
import com.spiderdiplome.repository.dao.UtilisateurDAO;
import com.spiderdiplome.repository.implement.UtilisateurDAOImpl;
import com.spiderdiplome.security.hashing.PasswordHashing;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "API Utilisateurs spider", value = "/api/v1/utilisateurs")
public class UtilisateurAPIServlet extends HttpServlet {

    private UtilisateurDAO utilisateurDAO;

    @Override
    public void init() {
        this.utilisateurDAO = new UtilisateurDAOImpl();  // Remplacez par votre méthode d'instanciation
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String pathInfo = req.getPathInfo();  // /{id}
        if (pathInfo == null || pathInfo.equals("/")) {
            // Handle request to /api/v1/utilisateurs
            List<Utilisateur> utilisateurs = utilisateurDAO.readAll();
            JSONArray jsonArray = new JSONArray();
            for (Utilisateur utilisateur : utilisateurs) {
                JSONObject json = new JSONObject();
                json.put("id", utilisateur.getId());
                json.put("prenom", utilisateur.getPrenom());
                json.put("nom", utilisateur.getNom());
                json.put("email", utilisateur.getEmail());
                json.put("phone", utilisateur.getPhone());
                json.put("adresse", utilisateur.getAdresse());
                json.put("genre", utilisateur.getGenre());
                json.put("dateInscription", utilisateur.getDateInscription());
                json.put("dateCreation", utilisateur.getDateCreation());
                json.put("role", utilisateur.getRole());
                json.put("photoProfil", utilisateur.getPhotoProfil());
                json.put("matricule", utilisateur.getMatricule());
                json.put("bio", utilisateur.getBio());
                json.put("statut", utilisateur.getStatut());
                jsonArray.put(json);
            }
            resp.setContentType("application/json");
            PrintWriter out = resp.getWriter();
            out.print(jsonArray.toString());
            out.flush();
        } else {
            // Handle request to /api/v1/utilisateurs/{id}
            String[] splits = pathInfo.split("/");
            if (splits.length != 2) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }
            String idStr = splits[1];  // {id}
            int id;
            try {
                id = Integer.parseInt(idStr);
            } catch (NumberFormatException e) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }
            Utilisateur utilisateur = utilisateurDAO.read(id);
            if (utilisateur == null) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                return;
            }
            JSONObject json = new JSONObject();
            json.put("id", utilisateur.getId());
            json.put("prenom", utilisateur.getPrenom());
            json.put("nom", utilisateur.getNom());
            json.put("email", utilisateur.getEmail());
            json.put("phone", utilisateur.getPhone());
            json.put("adresse", utilisateur.getAdresse());
            json.put("genre", utilisateur.getGenre());
            json.put("dateInscription", utilisateur.getDateInscription());
            json.put("dateCreation", utilisateur.getDateCreation());
            json.put("role", utilisateur.getRole());
            json.put("photoProfil", utilisateur.getPhotoProfil());
            json.put("matricule", utilisateur.getMatricule());
            json.put("bio", utilisateur.getBio());
            json.put("statut", utilisateur.getStatut());
            resp.setContentType("application/json");
            PrintWriter out = resp.getWriter();
            out.print(json.toString());
            out.flush();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Read the request body
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = req.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }

        // Parse the request body to a JSON object
        JSONObject json = new JSONObject(sb.toString());

        // Create a new Utilisateur object from the JSON
        Utilisateur utilisateur = new Utilisateur();
        // Set the properties of the Utilisateur object from the JSON
        utilisateur.setNom(json.getString("nom"));
        utilisateur.setPrenom(json.getString("prenom"));
        utilisateur.setPhone(json.getString("phone"));

        // Hash the password
        PasswordHashing passwordHashing = new PasswordHashing();
        String salt = passwordHashing.generateSalt();
        String hashedPassword = passwordHashing.hash(json.getString("motDePasse"), salt);
        utilisateur.setMotDePasse(hashedPassword);
        utilisateur.setSalt(salt);

        // Save the new user to the database
        utilisateurDAO.create(utilisateur);

        // Set the response content type to JSON
        resp.setContentType("application/json");

        // Write the user JSON object to the response
        PrintWriter out = resp.getWriter();
        out.print(json.toString());
        out.flush();
    }


}