package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class ClientDaoImpl implements ClientDao {
    private final Connection connection;
    private final PreparedStatement createSt;
    private final PreparedStatement readSt;
    private final PreparedStatement updateSt;
    private final PreparedStatement deleteSt;
    private final PreparedStatement listAllSt;

    public ClientDaoImpl() throws SQLException {
        this.connection = Database.getInstance().getConnection();
        this.createSt = connection.prepareStatement("INSERT INTO CLIENT (NAME) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
        this.readSt = connection.prepareStatement("SELECT NAME FROM CLIENT WHERE ID = ?");
        this.updateSt = connection.prepareStatement("UPDATE CLIENT SET NAME = ? WHERE ID = ?");
        this.deleteSt = connection.prepareStatement("DELETE FROM CLIENT WHERE ID = ?");
        this.listAllSt = connection.prepareStatement("SELECT ID, NAME FROM CLIENT");
    }

    @Override
    public long create(String name) throws SQLException{
        createSt.setString(1,name);
        createSt.executeUpdate();

        try(ResultSet rs = createSt.getGeneratedKeys()){
            if (rs.next()){
                return rs.getLong(1);
            }
        }
        throw new SQLException("не вдалося створити клієнта");

    }

    @Override
    public String getById(long id) throws SQLException{
        readSt.setLong(1,id);
        try(ResultSet rs = readSt.executeQuery()){
            if (rs.next()){
                return rs.getString("NAME");
            }
        }
        throw new NoSuchElementException("Клієнта з ID: " + id + " немає");
    }

    @Override
    public void setName(long id, String name) throws SQLException{
        updateSt.setLong(2,id);
        updateSt.setString(1,name);
        if (updateSt.executeUpdate() == 0){
            throw new NoSuchElementException("Клієнта з ID: " + id + " немає");
        }
    }

    @Override
    public void deleteById(long id) throws SQLException{
        deleteSt.setLong(1,id);
        if (deleteSt.executeUpdate() == 0){
            throw new NoSuchElementException("Клієнта з ID: " + id + " немає");
        }
    }

    @Override
    public List<Client> listAll() throws SQLException{
        List<Client> clients = new ArrayList<>();
        try (ResultSet rs = listAllSt.executeQuery()){
            while(rs.next()){
                clients.add(new Client(rs.getLong("ID"),rs.getString("NAME")));
            }
        }
        return clients;
    }
}
