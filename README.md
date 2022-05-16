# userGridExample-backEnd

spring boot must have mysql jdbs driver.


In order to connect to mysql, it is necessary to write information about mysql server in the application.properties file in the src/main/resources folder.

Below is the information.
spring.datasource.url=jdbc:mysql://"mysql database address"/"database name"
spring.datasource.username="mysql username"
spring.datasource.password="mysql user password"
spring.jpa.hibernate.ddl-auto=update
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
