package org.example;

import java.util.*;

public class ClientService {
    private final Map<Long,Client> clients = new HashMap<>();
    private long idCounter = 0;

    long create(String name){
        Client.validateName(name);
        long id = idCounter++;
        clients.put(id,new Client(id,name));
        return id;
    }
    String getById(long id){
        Client client = clients.get(id);
        if(client == null){
            throw new NoSuchElementException("Клієнта з ID: " + id + " немає");
        }
        return client.getName();
    }
    void setName(long id, String name){
        Client.validateName(name);
        Client client = clients.get(id);
        if(client == null){
            throw new NoSuchElementException("Клієнта з ID: " + id + " немає");
        }
        client.setName(name);
    }
    void deleteById(long id){
        Client client = clients.get(id);
        if (client == null){
            throw new NoSuchElementException("Клієнта з ID: " + id + " немає");
        }
        clients.remove(id);
    }
    List<Client> listAll(){
        return new ArrayList<>(clients.values());
    }

}
