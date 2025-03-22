package org.example;

public class Client {
    private final long id;
    private String name;

    public Client(long id, String name){
        this.id = id;
        this.setName(name);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        validateName(name);
        this.name = name;
    }

    public static void validateName(String name){
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Ім'я не може бути пустим!");
        }
        if (name.length() < 2 || name.length() > 100){
            throw new IllegalArgumentException("Ім'я закоротке(менше 2 символів) або задовге(більше 100 символів)");
        }
    }
}
