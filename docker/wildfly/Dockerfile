FROM jboss/wildfly:latest
RUN /opt/jboss/wildfly/bin/add-user.sh admin password --silent
EXPOSE 8080 9990 8787
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]