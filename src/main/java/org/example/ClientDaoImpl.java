package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class ClientDaoImpl implements ClientDao {
    private final Connection connection;

    public ClientDaoImpl() throws SQLException {
        this.connection = Database.getInstance().getConnection();
    }

    @Override
    public long create(String name) throws SQLException {
        String sql = "INSERT INTO CLIENT (NAME) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, name);
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getLong(1);
                }
            }
            throw new SQLException("Не вдалося створити клієнта");
        }
    }

    @Override
    public String getById(long id) throws SQLException {
        String sql = "SELECT NAME FROM CLIENT WHERE ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("NAME");
                }
            }
            throw new NoSuchElementException("Клієнта з ID: " + id + " немає");
        }
    }

    @Override
    public void setName(long id, String name) throws SQLException {
        String sql = "UPDATE CLIENT SET NAME = ? WHERE ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setLong(2, id);
            if (stmt.executeUpdate() == 0) {
                throw new NoSuchElementException("Клієнта з ID: " + id + " немає");
            }
        }
    }

    @Override
    public void deleteById(long id) throws SQLException {
        String sql = "DELETE FROM CLIENT WHERE ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            if (stmt.executeUpdate() == 0) {
                throw new NoSuchElementException("Клієнта з ID: " + id + " немає");
            }
        }
    }

    @Override
    public List<Client> listAll() throws SQLException {
        String sql = "SELECT ID, NAME FROM CLIENT";
        List<Client> clients = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                clients.add(new Client(rs.getLong("ID"), rs.getString("NAME")));
            }
        }
        return clients;
    }
}
