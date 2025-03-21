package org.example;

public class MaxProjectsClient {
    private String name;
    private int project_count;

    public MaxProjectsClient(String name, int project_count) {
        this.name = name;
        this.project_count = project_count;
    }

    public String getName() {
        return this.name;
    }

    public int getProject_count() {
        return this.project_count;
    }
}
