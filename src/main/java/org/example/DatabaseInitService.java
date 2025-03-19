package org.example;


import java.io.IOException;
import java.sql.SQLException;

public class DatabaseInitService {
    public static void main(String[] args) throws SQLException, IOException {
        String sqlPathQuery = "src/main/java/sql/init_db.sql";
        ReaderAndExecutor.executeSqlQuery(ReaderAndExecutor.readFile(sqlPathQuery));
    }
}

