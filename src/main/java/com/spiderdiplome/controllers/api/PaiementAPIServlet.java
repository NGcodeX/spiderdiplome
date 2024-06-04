package com.spiderdiplome.controllers.api;

import com.spiderdiplome.models.Paiement;
import com.spiderdiplome.models.Utilisateur;
import com.spiderdiplome.repository.dao.PaiementDAO;
import com.spiderdiplome.repository.dao.UtilisateurDAO;
import com.spiderdiplome.repository.implement.PaiementDAOImpl;
import com.spiderdiplome.repository.implement.UtilisateurDAOImpl;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@WebServlet(name = "API Paiements spider", value = "/api/v1/paiements")
public class PaiementAPIServlet extends HttpServlet {

    private PaiementDAO paiementDAO;
    private UtilisateurDAO utilisateurDAO;

    @Override
    public void init() {
        this.paiementDAO = new PaiementDAOImpl();  // Replace with your instantiation method
        this.utilisateurDAO = new UtilisateurDAOImpl();  // Replace with your instantiation method
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String pathInfo = req.getPathInfo();  // /{id}
        if (pathInfo == null || pathInfo.equals("/")) {
            // Handle request to /api/v1/paiements
            List<Paiement> paiements = paiementDAO.readAll();
            JSONArray jsonArray = new JSONArray();
            for (Paiement paiement : paiements) {
                JSONObject json = new JSONObject();
                json.put("id", paiement.getId());
                json.put("utilisateurId", paiement.getUtilisateurId());
                json.put("payerId", paiement.getPayerId());
                json.put("montant", paiement.getMontant());
                json.put("currency", paiement.getCurrency());
                json.put("datePaiement", paiement.getDatePaiement());
                json.put("paymentDate", paiement.getPaymentDate());
                json.put("methodePaiement", paiement.getMethodePaiement());
                json.put("statutPaiement", paiement.getStatutPaiement());
                json.put("reference", paiement.getReference());
                json.put("transactionId", paiement.getTransactionId());
                jsonArray.put(json);
            }
            resp.setContentType("application/json");
            PrintWriter out = resp.getWriter();
            out.print(jsonArray.toString());
            out.flush();
        } else {
            // Handle request to /api/v1/paiements/{id}
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
            Paiement paiement = paiementDAO.read(id);
            if (paiement == null) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                return;
            }
            JSONObject json = new JSONObject();
            json.put("id", paiement.getId());
            json.put("utilisateurId", paiement.getUtilisateurId());
            json.put("payerId", paiement.getPayerId());
            json.put("montant", paiement.getMontant());
            json.put("currency", paiement.getCurrency());
            json.put("datePaiement", paiement.getDatePaiement());
            json.put("paymentDate", paiement.getPaymentDate());
            json.put("methodePaiement", paiement.getMethodePaiement());
            json.put("statutPaiement", paiement.getStatutPaiement());
            json.put("reference", paiement.getReference());
            json.put("transactionId", paiement.getTransactionId());
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

        // Create a new Paiement object from the JSON
        Paiement paiement = new Paiement();
        paiement.setUtilisateurId(1);

        // Initialize the payment with Notch Pay API
        String notchPayUrl = "https://api.notchpay.co/payments/initialize";
        URL url = new URL(notchPayUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "PUBLIC_KEY");  // Replace with your public key
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setDoOutput(true);

        // Retrieve the user's email and phone using the utilisateurId
        Utilisateur utilisateur = utilisateurDAO.read(paiement.getUtilisateurId());
        String email = utilisateur.getEmail();
        String phone = utilisateur.getPhone();

        // Set the request body
        String requestBody = String.format("email=%s&currency=%s&amount=%s&phone=%s&reference=%s&description=%s",
                java.net.URLEncoder.encode(email, "UTF-8"),
                java.net.URLEncoder.encode(paiement.getCurrency(), "UTF-8"),
                java.net.URLEncoder.encode(String.valueOf(paiement.getMontant()), "UTF-8"),
                java.net.URLEncoder.encode(phone, "UTF-8"),
                java.net.URLEncoder.encode(paiement.getReference(), "UTF-8"),
                java.net.URLEncoder.encode(paiement.getPaymentDetails(), "UTF-8"));
        OutputStream os = conn.getOutputStream();
        os.write(requestBody.getBytes());
        os.flush();
        os.close();

        // Get the response
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        conn.disconnect();

        // Parse the response to a JSON object
        JSONObject responseJson = new JSONObject(content.toString());

        // Set the response content type to JSON
        resp.setContentType("application/json");

        // Write the response JSON object to the response
        PrintWriter out = resp.getWriter();
        out.print(responseJson.toString());
        out.flush();
    }
}