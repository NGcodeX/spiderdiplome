FROM tomcat:8.5-jre8

# Créer un répertoire webapps s'il n'existe pas déjà
RUN mkdir -p /usr/local/tomcat/webapps

# Copier le fichier WAR de votre application dans le répertoire webapps de Tomcat
COPY target/spiderdiplome.war /usr/local/tomcat/webapps/

# Exposer le port 8080 pour accéder à l'application via HTTP
EXPOSE 8080

# Commande pour démarrer Tomcat
CMD ["catalina.sh", "run"]


