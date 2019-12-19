FROM adoptopenjdk:11.0.4_11-jre-hotspot
COPY build/libs/dinamarca-services-0.0.1-SNAPSHOT.jar /opt/dinamarca-services/dinamarca-services.jar

VOLUME /var/log/dinamarca-services

CMD exec java ${SPRING_OPTS} -jar /opt/dinamarca-services/dinamarca-services.jar
