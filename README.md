Java program to be used by Manager in Restaurant Order System

Open port 9765/tcp

Set following according to your use case;

//In src/managerportal/Login.java (MySQL database)
    private static final String serverName = "localhost";
    private static final String port = "3306";
    private static final String dbName = "restaurant"; 

//In src/managerportal/workstation.java (Kitchen system)
    private static final String Kitchen_IP = "localhost";
    private static final Integer Kitchen_PORT = 9766;
	
ManagerPortal, MySql database, REST APIs must be on same system.

Create a database in MySQL named "restaurant", and a mysql user named 'manager' with full access on 'restaurant' database.

Import restaurant.sql (provided in project.zip) to your restaurant database.

project.zip in ManagerPortal git contains required database and php files for REST API.
