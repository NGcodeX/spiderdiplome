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


DROP TABLE IF EXISTS universities;
SELECT *
FROM universities;
CREATE TABLE IF NOT EXISTS universities
(
    id                   INT AUTO_INCREMENT PRIMARY KEY,
    name                 VARCHAR(100) NOT NULL,
    location             VARCHAR(255) NOT NULL,
    description          TEXT,
    service_admin_email  VARCHAR(100) NOT NULL,
    date_added           TIMESTAMP    DEFAULT CURRENT_TIMESTAMP,
    statut               TINYINT(1)   DEFAULT 1,
    logo                 VARCHAR(255) DEFAULT NULL,
    website              VARCHAR(255) DEFAULT NULL,
    contact_number       VARCHAR(20)  DEFAULT NULL,
    courses_offered      TEXT         DEFAULT NULL,
    application_deadline DATE         DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;


DROP TABLE IF EXISTS serviceadministratifecole;
SELECT *
FROM serviceadministratifecole;
CREATE TABLE IF NOT EXISTS serviceadministratifecole
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    matricule     VARCHAR(20)                 NOT NULL,
    university_id INT                         NOT NULL,
    date_added    TIMESTAMP                            DEFAULT CURRENT_TIMESTAMP,
    status        ENUM ('active', 'inactive') NOT NULL DEFAULT 'active',
    logo          VARCHAR(255)                         DEFAULT NULL,
    FOREIGN KEY (matricule) REFERENCES utilisateurs (matricule),
    FOREIGN KEY (university_id) REFERENCES universities (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;




