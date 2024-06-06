-- nom de la base de donnee spider_diplome (creation CREATE IF NOT EXIT DATABASE spider_diplome;)
-- delimiter par defaut: DELIMITER ;
-- SHOW DATABASES;
-- SELECT * FROM utilisateurs;
-- DROP TABLE IF EXISTS utilisateurs;
-- DELETE FROM utilisateurs WHERE id = 1;

CREATE TABLE IF NOT EXISTS Utilisateurs
(
    id                  INT AUTO_INCREMENT PRIMARY KEY,
    Nom                 VARCHAR(50) NOT NULL,
    prenom              VARCHAR(50) NOT NULL,
    email               VARCHAR(100) NOT NULL UNIQUE,
    phone               VARCHAR(100) NOT NULL UNIQUE,
    matricule           VARCHAR(20) NOT NULL UNIQUE,
    motDePasse          VARCHAR(100) NOT NULL,
    role                ENUM ('candidat', 'autoritesignataire', 'superadmin', 'administrateur', 'responsablesecurite', 'candidatpotentiel', 'serviceadministratifecole') NOT NULL DEFAULT 'candidatpotentiel',
    dateInscription     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    statut              TINYINT(1) NOT NULL DEFAULT 1,
    dateCreation        TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    derniereConnexion   TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    dateModification    TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    dateNaissance       DATE DEFAULT NULL,
    genre               ENUM('homme', 'femme', 'autre') DEFAULT 'autre',
    photoProfil         VARCHAR(255) DEFAULT NULL,
    bio                 TEXT DEFAULT NULL,
    adresse             VARCHAR(255) DEFAULT NULL,
    salt                VARCHAR(255) NOT NULL UNIQUE,
    lastLoginIP         VARCHAR(45) DEFAULT NULL,
    failedLoginAttempts INT DEFAULT 0,
    accountLocked       BOOLEAN DEFAULT FALSE,
    resetPasswordToken  VARCHAR(255) DEFAULT NULL,
    resetPasswordExpiry TIMESTAMP DEFAULT NULL,
    twoFactorEnabled    BOOLEAN DEFAULT FALSE,
    twoFactorSecret     VARCHAR(255) DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

INSERT INTO Utilisateurs
(Nom, prenom, email, phone, matricule, motDePasse, role, statut, salt, lastLoginIP, failedLoginAttempts, accountLocked, twoFactorEnabled)
VALUES
('Pilote', 'ZEBS', 'zebs@superadmin.com', '692077005', 'CM20240000', 'Vxh-or0Maf67XxRqDJlm15GwFX3rt46IdLzCn_zQJTjRLv12AbBuKM1A5dobXs3nHqr_8oqNkpgLqokZDnTp-Q==', 'superadmin', 1, 'Jt2WDyr7xFc1m5m_SnICyQ==', '192.168.1.1', 0, FALSE, FALSE);

SELECT * FROM Paiement;
CREATE TABLE IF NOT EXISTS Paiement
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    utilisateurId INT NOT NULL,
    payerId INT,
    montant DECIMAL(10, 2) NOT NULL,
    currency VARCHAR(3),
    datePaiement TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    paymentDate DATE,
    methodePaiement VARCHAR(50) NOT NULL,
    paymentDetails TEXT,
    statutPaiement ENUM('réussi', 'échoué', 'en attente') NOT NULL,
    reference VARCHAR(255) NOT NULL,
    transactionId VARCHAR(255) NOT NULL,
    FOREIGN KEY (utilisateurId) REFERENCES Utilisateurs(id),
    FOREIGN KEY (payerId) REFERENCES Utilisateurs(id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

INSERT INTO Paiement
(utilisateurId, payerId, montant, currency, datePaiement, paymentDate, methodePaiement, paymentDetails, statutPaiement, reference, transactionId)
VALUES
(1, 1, 1000.00, 'XAF', NOW(), NOW(), 'MOMO', 'Payement analyse de dossier', 'réussi', 'REF123', 'TRANS123');



CREATE TABLE IF NOT EXISTS Universites
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    emplacement VARCHAR(255),
    description TEXT,
    date_ajoutee TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    statut ENUM('active', 'inactive'),
    logo VARCHAR(255),
    site_web VARCHAR(255),
    numero_contact VARCHAR(20),
    email_contact VARCHAR(100),
    adresse_postale VARCHAR(255),
    cours_offerts TEXT,
    date_limite_application DATE,
    frais_scolarite DECIMAL(10, 2),
    nombre_etudiants INT,
    nombre_professeurs INT,
    classement_universite INT,
    type_universite ENUM('public', 'prive'),
    accreditations TEXT,
    programmes_offerts TEXT,
    bourses_disponibles TEXT,
    installations TEXT,
    partenariats_internationaux TEXT,
    taux_acceptation DECIMAL(5, 2),
    taux_diplomation DECIMAL(5, 2),
    taux_emploi DECIMAL(5, 2)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

INSERT INTO Universites
(nom, emplacement, description, statut, logo, site_web, numero_contact, email_contact, adresse_postale, cours_offerts, date_limite_application, frais_scolarite, nombre_etudiants, nombre_professeurs, classement_universite, type_universite, accreditations, programmes_offerts, bourses_disponibles, installations, partenariats_internationaux, taux_acceptation, taux_diplomation, taux_emploi)
VALUES
('ICT University USA', 'Dispensaire Messassi', 'Une université de test pour démonstration.', 'active', 'logo_url', 'ictuniversity.org', '+237685456847', 'contact@ictuniversity.org', '237 yde cameroun', 'C++, Java, python', '2023-12-31', 1000.00, 10000, 1000, 100, 'public', 'Accréditation de test', 'Programme de test', 'Bourse de test', 'Installations de test', 'Partenariats de test', 0.80, 0.90, 0.95);


CREATE TABLE IF NOT EXISTS Candidatures
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    utilisateurId INT,
    universiteId INT,
    dateSoumission TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    statut ENUM('en attente', 'accepte', 'rejete'),
    dateExamen DATE,
    scoreExamen DECIMAL(5, 2),
    dateEntretien DATE,
    scoreEntretien DECIMAL(5, 2),
    dateDecisionFinale DATE,
    decisionFinale ENUM('accepte', 'rejete', 'liste attente'),
    commentaire TEXT,
    fraisApplication DECIMAL(10, 2),
    aPayer BOOLEAN DEFAULT FALSE,
    aPayerAvant DATE,
    aPayerMontant DECIMAL(10, 2),
    aPayerMethode ENUM('carte de credit', 'virement bancaire', 'paypal', 'MTN money', 'ORANGE money', 'autre'),
    aPayerStatut ENUM('non paye', 'paye'),
    aPayerDate TIMESTAMP,
    aPayerTransactionId VARCHAR(255),
    FOREIGN KEY (utilisateurId) REFERENCES Utilisateurs(id),
    FOREIGN KEY (universiteId) REFERENCES Universites(id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

INSERT INTO Candidatures
(utilisateurId, universiteId, statut, dateExamen, scoreExamen, dateEntretien, scoreEntretien, dateDecisionFinale, decisionFinale, commentaire, fraisApplication, aPayer, aPayerAvant, aPayerMontant, aPayerMethode, aPayerStatut, aPayerDate, aPayerTransactionId)
VALUES
(1, 1, 'en attente', '2023-12-01', 85.00, '2023-12-15', 90.00, '2024-01-01', 'liste attente', 'Candidature en cours de traitement.', 100.00, TRUE, '2024-01-15', 1000.00, 'MTN money', 'non paye', NOW(), 'TRANS123');


CREATE TABLE IF NOT EXISTS Documents
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    utilisateurId INT,
    candidatureId INT,
    nom VARCHAR(255) NOT NULL,
    type ENUM('CV', 'Lettre de motivation', 'Relevé de notes', 'Diplôme', 'Autre'),
    dateSoumission TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    statut ENUM('en attente', 'validé', 'rejeté'),
    commentaire TEXT,
    cheminFichier VARCHAR(255) NOT NULL,
    tailleFichier DECIMAL(10, 2),
    formatFichier VARCHAR(50),
    FOREIGN KEY (utilisateurId) REFERENCES Utilisateurs(id),
    FOREIGN KEY (candidatureId) REFERENCES Candidatures(id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;


INSERT INTO Documents
(utilisateurId, candidatureId, nom, type, statut, cheminFichier, tailleFichier, formatFichier)
VALUES
(1, 1, 'CV Test', 'CV', 'en attente', '/chemin/vers/le/fichier', 1.00, 'pdf');


CREATE TABLE IF NOT EXISTS Notifications
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    utilisateurId INT,
    titre VARCHAR(255) NOT NULL,
    message TEXT NOT NULL,
    dateEnvoi TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    lu BOOLEAN DEFAULT FALSE,
    dateLecture TIMESTAMP,
    type ENUM('info', 'alerte', 'erreur', 'succès'),
    urlRedirection VARCHAR(255),
    icone VARCHAR(50),
    couleurFond VARCHAR(7),
    couleurTexte VARCHAR(7),
    FOREIGN KEY (utilisateurId) REFERENCES Utilisateurs(id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

INSERT INTO Notifications
(utilisateurId, titre, message, type, urlRedirection, icone, couleurFond, couleurTexte)
VALUES
(1, 'Titre de la notification', 'Ceci est un message de notification de test.', 'info', 'www.example.com', 'icone_info', '#FFFFFF', '#000000');


CREATE TABLE IF NOT EXISTS HistoriqueConnexion
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    utilisateurId INT,
    dateConnexion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ip VARCHAR(45),
    navigateur VARCHAR(255),
    systemeExploitation VARCHAR(255),
    pays VARCHAR(50),
    ville VARCHAR(50),
    codePostal VARCHAR(10),
    latitude DECIMAL(9, 6),
    longitude DECIMAL(9, 6),
    FOREIGN KEY (utilisateurId) REFERENCES Utilisateurs(id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

INSERT INTO HistoriqueConnexion
(utilisateurId, ip, navigateur, systemeExploitation, pays, ville, codePostal, latitude, longitude)
VALUES
(1, '192.168.1.1', 'Chrome', 'Windows 10', 'Cameroun', 'Yaoundé', '1000', 3.848, 11.5021);







