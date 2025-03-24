package org.example;

public class Client {
    private final long id;
    private String name;

    public Client(long id, String name){
        this.id = id;
        this.name = (name);
    }

    @Override
    public String toString(){
        return "ID: " + id + " Name: " + name ;
    }
}
