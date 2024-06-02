// Dans le fichier com/spiderdiplome/database/DatabaseConfig.java
package com.spiderdiplome.database;

import java.io.IOException;
import java.util.Properties;

public class DatabaseConfig {
    public static String URL;
    public static String USER;
    public static String PASSWORD;

    static {
        try {
            Properties properties = new Properties();
            properties.load(DatabaseConfig.class.getClassLoader().getResourceAsStream("config.properties"));

            URL = properties.getProperty("db.url");
            USER = properties.getProperty("db.user");
            PASSWORD = properties.getProperty("db.password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}