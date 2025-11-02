package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/scholar_db";
    private static final String USER = "root"; // 🔧 cambia si usas otro usuario
    private static final String PASSWORD = "Arcane25"; // 🔒 cambia según tu configuración

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
