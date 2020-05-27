The project uses Maven and can be built with the following command: mvn clean install

Once it's built, run the Application class. You can check the deployed process in localhost:8080. Please note that the application will not start if this port is already in use.

Login credentials for the Camunda cockpit: 
username: kermit
password: superSecret

Database:

The project uses a PostgreSQL database. You need to have PostgreSQL installed in your machine.
To create the database needed for the project, run the following commands on a terminal window:
1. psql -h localhost -U postgres (connect to localhost as postgres user)
2. create database pawnshop;
3. grant all privileges on database pawnshop to postgres;

IMPORTANT: the application uses the username/password combination postgres/postgres to connect to the database.
If you use a different password for your postgres user, please adjust your application.properties file accordingly, specifically the line:
spring.datasource.password=postgres

Just make sure to revert that change if you need to commit any changes to the application.properties file.
