FROM azul/zulu-openjdk:17.0.12-jdk
WORKDIR /app
VOLUME /data
COPY /target/nexign_lottery_rest-0.0.2-SNAPSHOT.jar /app/nexign_lottery_rest.jar
ENTRYPOINT ["java", "-jar", "nexign_lottery_rest.jar"]
ENV DB_URL="jdbc:mysql://localhost:3306/my_db"
ENV DB_USERNAME="bestuser"
ENV DB_PASSWORD="bestuser"