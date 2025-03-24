package org.example;

import java.sql.*;
import java.util.*;

public class ClientService {
    private final Connection connection;
    private final PreparedStatement createSt;
    private final PreparedStatement readSt;
    private final PreparedStatement updateSt;
    private final PreparedStatement deleteSt;
    private final PreparedStatement listAllSt;

    public ClientService() throws SQLException{
        this.connection = Database.getInstance().getConnection();
        this.createSt = connection.prepareStatement("INSERT INTO CLIENT (NAME) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
        this.readSt = connection.prepareStatement("SELECT NAME FROM CLIENT WHERE ID = ?");
        this.updateSt = connection.prepareStatement("UPDATE CLIENT SET NAME = ? WHERE ID = ?");
        this.deleteSt = connection.prepareStatement("DELETE FROM CLIENT WHERE ID = ?");
        this.listAllSt = connection.prepareStatement("SELECT ID, NAME FROM CLIENT");
    }

    public long create(String name) throws SQLException{
        validateName(name);
        createSt.setString(1,name);
        createSt.executeUpdate();

        try(ResultSet rs = createSt.getGeneratedKeys()){
            if (rs.next()){
                return rs.getLong(1);
            }
        }
        throw new SQLException("не вдалося створити клієнта");

    }

    public String getById(long id) throws SQLException{
        readSt.setLong(1,id);
        try(ResultSet rs = readSt.executeQuery()){
            if (rs.next()){
                return rs.getString("NAME");
            }
        }
        throw new NoSuchElementException("Клієнта з ID: " + id + " немає");
    }

    public void setName(long id, String name) throws SQLException{
        validateName(name);
        updateSt.setLong(2,id);
        updateSt.setString(1,name);
        if (updateSt.executeUpdate() == 0){
            throw new NoSuchElementException("Клієнта з ID: " + id + " немає");
        }
    }

    public void deleteById(long id) throws SQLException{
        deleteSt.setLong(1,id);
        if (deleteSt.executeUpdate() == 0){
            throw new NoSuchElementException("Клієнта з ID: " + id + " немає");
        }
    }

    public List<Client> listAll() throws SQLException{
        List<Client> clients = new ArrayList<>();
        try (ResultSet rs = listAllSt.executeQuery()){
            while(rs.next()){
                clients.add(new Client(rs.getLong("ID"),rs.getString("NAME")));
            }
        }
        return clients;
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
