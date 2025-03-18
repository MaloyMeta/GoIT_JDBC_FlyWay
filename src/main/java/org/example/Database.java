package org.example;
import java.sql.*;

public class Database {

    public static Database instance;

    private Connection connection;

    private Database(){
        try {
            String url = "jdbc:h2:~/goit_test";
            String login = "root";
            String password = "12345";

            this.connection = DriverManager.getConnection(url,login,password);
            System.out.println("Connection succesful");

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Connection failed");
        }
    }

    public static synchronized Database getInstance(){
        if (instance == null){
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection(){
        return this.connection;
    }
}