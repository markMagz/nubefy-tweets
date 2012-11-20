nubefy-tweets
=============

pre-requisite
1. create database unit_test;  --for unit test
2. create database nubefy;  --for actual app

please change/create another user if root is not allowed
username:root
pasword:root

PATH: nubefy-tweets-service/src/test/resources/properties/database.properties
jdbc.driverClassName=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/unit_test
jdbc.username=root
jdbc.password=root
hibernate.dialect=org.hibernate.dialect.MySQLDialect
hibernate.hbm2ddl=create-drop
hibernate.show_sql=true

PATH: nubefy-tweets-webapp/src/test/resources/properties/database.properties
jdbc.driverClassName=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/unit_test
jdbc.username=root
jdbc.password=root
hibernate.dialect=org.hibernate.dialect.MySQLDialect
hibernate.hbm2ddl=create-drop
hibernate.show_sql=true

PATH: nubefy-tweets-webapp/src/main/resources/properties/database.properties
jdbc.driverClassName=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/nubefy
jdbc.username=root
jdbc.password=root
hibernate.dialect=org.hibernate.dialect.MySQLDialect
hibernate.hbm2ddl=update
hibernate.show_sql=true


running war file
1. Build the project
   execute: mvn clean install
2. go into the nubefy-tweets-webapp
   execute: mvn jetty:run
3. ounce started acccess http://localhost:8080/archiver/
   click on submit;
4. check data if inserted in nubefy database
   select * from TWITTER_TWEETS;


