* PrisonerRepo

** Start

For å kjøre docker containeren (husk å velge port):

docker run -itd -p <din port>:8080 marstran/persistering-neo4j

Det kan ta litt tid før rest-endepunktet er oppe. Ser ut som docker bruker tid på å starte en "SecureRandom instance" (mellom 60 og 200 sekunder).

Hvis du bruker boot2docker, så må du forwarde porten hvis du vil aksessere endepunktet fra maskinen din (f.eks. hvis du vil bruke Postman) Dette gjøres med:

VBoxManage controlvm boot2docker-vm natpf1 "PrisonerRepoPort,tcp,127.0.0.1,8080,,8080"

Testet ut på mac.


Spring data Neo4j

http://docs.spring.io/spring-data/data-neo4j/docs/3.2.2.RELEASE/reference/html/#tutorial_running