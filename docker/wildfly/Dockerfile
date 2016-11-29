FROM jboss/wildfly:latest
RUN /opt/jboss/wildfly/bin/add-user.sh admin password --silent
RUN /bin/sh -c '$JBOSS_HOME/bin/standalone.sh &' && \
  sleep 10 && \
  cd /tmp && \
  curl -O  https://repo1.maven.org/maven2/org/postgresql/postgresql/9.4.1212.jre7/postgresql-9.4.1212.jre7.jar && \
  mv postgresql-9.4.1212.jre7.jar postgresql-9.4.jar && \
  $JBOSS_HOME/bin/jboss-cli.sh --connect --command="deploy /tmp/postgresql-9.4.jar" && \
  $JBOSS_HOME/bin/jboss-cli.sh --connect --command="xa-data-source add --jndi-name=java:/jdbc/datasources/formationDS --user-name=admin --password=password --driver-name=postgresql-9.4.jar --xa-datasource-class=org.postgresql.xa.PGXADataSource --xa-datasource-properties=ServerName=postgres,PortNumber=5432,DatabaseName=data --valid-connection-checker-class-name=org.jboss.jca.adapters.jdbc.extensions.postgres.PostgreSQLValidConnectionChecker --exception-sorter-class-name=org.jboss.jca.adapters.jdbc.extensions.postgres.PostgreSQLExceptionSorter --name=formation" &&\
  $JBOSS_HOME/bin/jboss-cli.sh --connect --command=:shutdown && \
  rm -rf $JBOSS_HOME/standalone/configuration/standalone_xml_history/ $JBOSS_HOME/standalone/log/* && \
  rm /tmp/postgresql-9.4.jar && \
  rm -rf /tmp/postgresql-*.jar

EXPOSE 8080 9990 8787
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]