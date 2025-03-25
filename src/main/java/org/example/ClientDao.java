package org.example;

import java.sql.*;
import java.util.*;

public interface ClientDao {
    long create(String name) throws SQLException;

    String getById(long id) throws SQLException;

    void setName(long id, String name) throws SQLException;

    void deleteById(long id) throws SQLException;

    List<Client> listAll() throws SQLException;
}

