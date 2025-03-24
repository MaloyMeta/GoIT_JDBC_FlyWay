package org.example;

import java.sql.*;
import java.util.*;

public class ClientService {
    private final ClientDao clientDao;

    public ClientService(ClientDao clientDao){
        this.clientDao = clientDao;
    }

    public long create(String name) throws SQLException {
        validateName(name);
        return clientDao.create(name);
    }

    public String getById(long id) throws SQLException {
        return clientDao.getById(id);
    }

    public void setName(long id, String name) throws SQLException {
        validateName(name);
        clientDao.setName(id, name);
    }

    public void deleteById(long id) throws SQLException {
        clientDao.deleteById(id);
    }

    public List<Client> listAll() throws SQLException {
        return clientDao.listAll();
    }

    public void validateName(String name){
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Пусте поле");
        }
        if (name.length() < 2 || name.length() > 100){
            throw new IllegalArgumentException("Ім'я менше 2 або більше 100 символів");
        }
    }
}
