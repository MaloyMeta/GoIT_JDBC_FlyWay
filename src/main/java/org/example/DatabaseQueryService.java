package org.example;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    String findLongestProjectPATH = "src/main/java/sql/find_longest_project.sql";
    String findMaxProjectsClientPATH = "src/main/java/sql/find_max_projects_client.sql";
    String findMaxSalaryWorkerPATH = "src/main/java/sql/find_max_salary_worker.sql";
    String findYoungestEldestWorkersPATH = "src/main/java/sql/find_youngest_eldest_workers.sql";

    public List<LongestProject> findLongestProject() throws IOException, SQLException {
        List<LongestProject> result = new ArrayList<>();
        String sql = ReaderAndExecutor.readFile(findLongestProjectPATH);
        Connection conn = Database.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            result.add(new LongestProject(rs.getInt("ID"), rs.getInt("MONTH_COUNT")));
        }
        return result;
    }

    public List<MaxProjectsClient> findMaxProjectsClient() throws IOException, SQLException {
        List<MaxProjectsClient> result = new ArrayList<>();
        String sql = ReaderAndExecutor.readFile(findMaxProjectsClientPATH);
        Connection conn = Database.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            result.add(new MaxProjectsClient(rs.getString("NAME"), rs.getInt("PROJECT_COUNT")));
        }
        return result;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() throws IOException, SQLException {
        List<MaxSalaryWorker> result = new ArrayList<>();
        String sql = ReaderAndExecutor.readFile(findMaxSalaryWorkerPATH);
        Connection conn = Database.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            result.add(new MaxSalaryWorker(rs.getString("NAME"), rs.getInt("SALARY")));
        }
        return result;
    }

    public List<YoungestEldestWorkers> findYoungestEldestWorkers() throws IOException, SQLException {
        List<YoungestEldestWorkers> result = new ArrayList<>();
        String sql = ReaderAndExecutor.readFile(findYoungestEldestWorkersPATH);
        Connection conn = Database.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            String rawDate = rs.getString("BIRTHDAY");
            LocalDate date = LocalDate.parse(rawDate);
            result.add(new YoungestEldestWorkers(rs.getString("TYPE"), rs.getString("NAME"), date));
        }
        return result;
    }
}

