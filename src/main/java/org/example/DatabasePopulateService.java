package org.example;

import java.io.IOException;
import java.sql.SQLException;

public class DatabasePopulateService {
    public static void main(String[] args) throws IOException, SQLException {
        String sqlPathQuery = "src/main/java/sql/populate_db.sql";
        ReaderAndExecutor.executeSqlQuery(ReaderAndExecutor.readFile(sqlPathQuery).toString());
    }
}
