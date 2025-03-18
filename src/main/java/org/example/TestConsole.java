package org.example;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TestConsole {
    public static void main(String[] args) {

        DatabaseQueryService service = new DatabaseQueryService();

        try {
            List<DatabaseQueryService.LongestProject> projects0 = service.findLongestProject();
            List<DatabaseQueryService.MaxProjectsClient> projects1 = service.findMaxProjectsClient();
            List<DatabaseQueryService.MaxSalaryWorker> projects2 = service.findMaxSalaryWorker();
            List<DatabaseQueryService.YoungestEldestWorkers> projects3 = service.findYoungestEldestWorkers();

            if (projects0.isEmpty()) {
                System.out.println("Нет данных о самых длительных проектах.");
            } else {
                for (DatabaseQueryService.LongestProject project : projects0) {
                    System.out.println("ID: " + project.getId() + ", : " + project.getMonths() + " months");
                }
            }

            if (projects1.isEmpty()) {
                System.out.println("Нет данных о самых длительных проектах.");
            } else {
                for (DatabaseQueryService.MaxProjectsClient project : projects1) {
                    System.out.println("NAME: " + project.getName() + ", : " + project.getProject_count() + " projects");
                }
            }

            if (projects2.isEmpty()) {
                System.out.println("Нет данных о самых длительных проектах.");
            } else {
                for (DatabaseQueryService.MaxSalaryWorker project : projects2) {
                    System.out.println("NAME: " + project.getName() + ", : " + project.getSalary() + " salary");
                }
            }

            if (projects3.isEmpty()) {
                System.out.println("Нет данных о самых длительных проектах.");
            } else {
                for (DatabaseQueryService.YoungestEldestWorkers project : projects3) {
                    System.out.println("TYPE: " + project.getType() + ", NAME: " + project.getName()+ " " + project.getDate() + " Date");
                }
            }
        } catch (IOException | SQLException e) {
            System.err.println("Ошибка при выполнении запроса: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
