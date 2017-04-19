FROM tomcat:8
MAINTAINER Vasil Peevski

RUN ["rm", "-fr", "$CONTAINER_CATALINA_HOME/webapps/app"]
COPY ./target/spring-mvc-app-0.0.1-SNAPSHOT.war $CONTAINER_CATALINA_HOME/webapps/app.war
COPY ./context.xml $CONTAINER_CATALINA_HOME/conf/context.xml
COPY ./tomcat-users.xml $CONTAINER_CATALINA_HOME/conf/tomcat-users.xml
COPY ./target/spring-mvc-app-0.0.1-SNAPSHOT/WEB-INF/lib/mysql-connector-java-6.0.6.jar $CONTAINER_CATALINA_HOME/lib/mysql-connector-java-6.0.6.jar

CMD ["catalina.sh", "run"]