package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ReaderAndExecutor {
    public static String readFile(String sqlPathQuery) throws IOException {
        StringBuilder sqlQuery = new StringBuilder();
        try{
            BufferedReader bf = new BufferedReader(new FileReader(sqlPathQuery));
            String line;
            while ((line = bf.readLine()) != null){
                sqlQuery.append(line + " ");
            }
            bf.close();

        }catch (IOException e){
            System.out.println("Error while read file: " + e.getMessage());
        }
        return sqlQuery.toString();
    }

    public static void executeSqlQuery(String sqlQuery) throws SQLException {
            Connection conn = Database.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sqlQuery);
            System.out.println("Sql Query was succsesful!");
    }
}
