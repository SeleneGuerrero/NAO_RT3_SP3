package org.example;

import java.sql.Connection;

public class TestDBConnection {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn != null) {
                System.out.println("✅ Conexión a MySQL exitosa.");
            } else {
                System.out.println("❌ No se pudo establecer conexión.");
            }
        } catch (Exception e) {
            System.err.println("⚠️ Error al conectar: " + e.getMessage());
        }
    }
}
