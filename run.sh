(trap 'kill 0' SIGINT; 
cd web
mvn spring-boot:run &
cd ../rest
mvn spring-boot:run &
cd ../msg
mvn spring-boot:run 
)