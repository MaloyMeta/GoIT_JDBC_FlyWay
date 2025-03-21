package org.example;

import java.time.LocalDate;

public class YoungestEldestWorkers {
    private String type;
    private String name;
    private LocalDate date;

    public YoungestEldestWorkers(String type, String name, LocalDate date) {
        this.type = type;
        this.name = name;
        this.date = date;
    }

    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public LocalDate getDate() {
        return this.date;
    }
}
