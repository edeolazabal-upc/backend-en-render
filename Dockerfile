FROM  amazoncorretto:17
MAINTAINER EDO
COPY target/ej-pc1-datajpa-api-0.0.1-SNAPSHOT.jar d.jar
ENTRYPOINT ["java", "-jar", "/d.jar"]