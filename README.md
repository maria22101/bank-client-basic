**Spring boot Rest API client-bank**

---------------------------------------------------------------------
The project is to practice REST API development

run in default profile:
    mvn clean install

run in prod profile:
    mvn package
    java -jar -Dspring.profiles.active=prod target/bank-client-basic-0.0.1-SNAPSHOT.jar