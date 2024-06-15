package com.spiderdiplome.security.authentification;

import com.spiderdiplome.models.Utilisateur;
import com.spiderdiplome.repository.implement.UtilisateurDAOImpl;
import com.spiderdiplome.security.hashing.PasswordHashing;


/**
 * This class provides methods for authenticating users and registering new users.
 */
public class AuthenticationService {

    private final UtilisateurDAOImpl utilisateurDAO;
    private final PasswordHashing passwordHashing;

    /**
     * Default constructor that initializes the UtilisateurDAOImpl and PasswordHashing objects.
     */
    public AuthenticationService() {
        this.utilisateurDAO = new UtilisateurDAOImpl();
        this.passwordHashing = new PasswordHashing();
    }

    /**
     * Constructor that accepts UtilisateurDAOImpl and PasswordHashing objects.
     * @param utilisateurDAO The DAO object for handling database operations related to Utilisateur.
     * @param passwordHashing The object for handling password hashing operations.
     */
    public AuthenticationService(UtilisateurDAOImpl utilisateurDAO, PasswordHashing passwordHashing) {
        this.utilisateurDAO = utilisateurDAO;
        this.passwordHashing = passwordHashing;
    }

    /**
     * Authenticates a user by their matricule and password.
     * @param matricule The matricule of the user.
     * @param password The password of the user.
     * @return true if the user is authenticated successfully, false otherwise.
     */
    public boolean authenticate(String matricule, String password) {
        System.out.println("Dans la Methode AuthenticationService.authenticate()....");
        Utilisateur utilisateur = this.utilisateurDAO.findByMatricule(matricule);
        if (utilisateur == null) {
            System.out.println("Utilisateur non trouvé Domage!");
            System.out.println("Matricule fourni: " + matricule);
            return false;
        }
        System.out.println("Utilisateur trouvé");
        String hashedPassword = this.passwordHashing.hash(password, utilisateur.getSalt());
        if(hashedPassword == null){
            System.out.println("Erreur lors du hachage du mot de passe");
            return false;
        }
        if(!hashedPassword.equals(utilisateur.getMotDePasse())){
            System.out.println("Les mot de passe ne corresponde pas");
            return false;
        }
        System.out.println("Son nom est:" + utilisateur.getNom() + " " + utilisateur.getPrenom());
        System.out.println("Son role est: " + utilisateur.getRole());
        System.out.println("Salt de la base de donnée: " + utilisateur.getSalt());
        System.out.println("Mot de passe fourni: " + password);
        System.out.println("Mot de passe haché: " + hashedPassword);
        System.out.println("Mot de passe de la base de donnée: " + utilisateur.getMotDePasse());
        return utilisateur.getMotDePasse().equals(hashedPassword);
    }

    /**
     * Registers a new user with the given details.
     * @param firstname The first name of the user.
     * @param lastname The last name of the user.
     * @param phoneEmail The phone number or email of the user.
     * @param password The password of the user.
     * @return true if the user is registered successfully, false otherwise.
     */
    public boolean register(String firstname, String lastname, String phoneEmail, String password) {
        System.out.println("Dans la Methode AuthenticationService.register()....");
        String phone = "";
        String email = "";
        // verifie si phoneEmail est un numero ou un email avant de faire la recherche
        Utilisateur existingUser = new Utilisateur();
        if(phoneEmail.matches("^[0-9]*$")){
            // Vérifiez si l'utilisateur existe déjà
            phone = phoneEmail;
            existingUser = this.utilisateurDAO.findByPhone(phone);
        } else if (phoneEmail.contains("@")) {
            email = phoneEmail;
            existingUser = this.utilisateurDAO.findByEmail(email);
        }


        if (existingUser != null) {
            System.out.println("Utilisateur déjà existant");
            // Si l'utilisateur existe déjà, l'inscription échoue
            return false;
        }

    System.out.println("Utilisateur non existant");

    // No need to check existingUser.getNom() and existingUser.getPrenom() here because if existingUser was not null,
    // the method would have already returned false and stopped executing.

    // Générez un sel pour le hachage du mot de passe
    String salt = passwordHashing.generateSalt();
    if (salt == null) {
        System.out.println("Erreur lors de la génération du sel");
        // Si la génération du sel échoue, l'inscription échoue
        return false;
    }

    System.out.println("Sel généré");
    // Hachez le mot de passe avec le sel
    String hashedPassword = this.passwordHashing.hash(password, salt);
    if (hashedPassword == null) {
        System.out.println("Erreur lors du hachage du mot de passe");
        // Si le hachage du mot de passe échoue, l'inscription échoue
        return false;
    }

    System.out.println("Mot de passe haché");
        Utilisateur newUser = new Utilisateur();
        if(phoneEmail.matches("^[0-9]*$")){
            newUser.setMatricule(phone);
            newUser.setNom(firstname);
            newUser.setPrenom(lastname);
            newUser.setPhone(phone);
            newUser.setEmail("default@"+salt);
            newUser.setStatut(1);
            newUser.setMotDePasse(hashedPassword);
            newUser.setSalt(salt);
        } else if (phoneEmail.contains("@")) {
            newUser.setMatricule(email);
            newUser.setNom(firstname);
            newUser.setPrenom(lastname);
            newUser.setEmail(email);
            newUser.setPhone("237"+salt);
            newUser.setStatut(1);
            newUser.setMotDePasse(hashedPassword);
            newUser.setSalt(salt);
        }

    // Créez un nouvel utilisateur avec le mot de passe haché et le sel



    // Enregistrez le nouvel utilisateur dans la base de données
    boolean isUserCreated = this.utilisateurDAO.create(newUser);
    if (!isUserCreated) {
        System.out.println("Erreur lors de la création de l'utilisateur");
        // Si la création de l'utilisateur échoue, l'inscription échoue
        return false;
    }

    // Retournez le résultat de la création de l'utilisateur
    return true;
}
}