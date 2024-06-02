-- nom de la base de donnee spider_diplome (creation CREATE IF NOT EXIT DATABASE spider_diplome;)
-- delimiter par defaut: DELIMITER ;
SHOW DATABASES;
SELECT * FROM utilisateurs;
DROP TABLE IF EXISTS utilisateurs;
DELETE FROM utilisateurs WHERE id = 1;

CREATE TABLE IF NOT EXISTS utilisateurs
(
    id                  INT AUTO_INCREMENT PRIMARY KEY,
    nom                 VARCHAR(50) NOT NULL,
    prenom              VARCHAR(50) NOT NULL,
    email     VARCHAR(100) NOT NULL,
    phone     VARCHAR(20)  NOT NULL UNIQUE,
    matricule VARCHAR(20)  NOT NULL,
    motdepasse          VARCHAR(100) NOT NULL,
    role                ENUM ('candidat', 'autoritesignataire', 'superadmin', 'administrateur', 'responsablesecurite', 'candidatpotentiel', 'serviceadministratifecole') NOT NULL DEFAULT 'candidatpotentiel',
    dateinscription     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    statut              TINYINT(1) DEFAULT 1,
    datecreation        TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    derniereconnexion   TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    datemodification    TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    datenaissance       DATE DEFAULT NULL,
    genre               ENUM('homme', 'femme', 'autre') DEFAULT 'autre',
    photoprofil         VARCHAR(255) DEFAULT NULL,
    bio                 TEXT DEFAULT NULL,
    adresse             VARCHAR(255) DEFAULT NULL,
    salt                VARCHAR(255) NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

INSERT INTO utilisateurs
(nom, prenom, email, phone, matricule, motdepasse, role, dateinscription, statut, datecreation, derniereconnexion, datemodification, datenaissance, genre, photoprofil, bio, adresse, salt)
VALUES
    ('Pilote', 'ZEBS', 'zebs@superadmin.com', '692077005', 'CM20240000', 'Vxh-or0Maf67XxRqDJlm15GwFX3rt46IdLzCn_zQJTjRLv12AbBuKM1A5dobXs3nHqr_8oqNkpgLqokZDnTp-Q==', 'superadmin', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL, NULL, '2002-01-01', 'homme', NULL, 'Bio de zebs', '237 Dispensaire Yauonde', 'Jt2WDyr7xFc1m5m_SnICyQ==');

DELETE FROM utilisateurs WHERE id = 2;

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




