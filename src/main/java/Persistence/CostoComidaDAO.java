package Persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class CostoComidaDAO {

    public static void registrarCosto(double monto) {
        String sql = "INSERT INTO CostosComidas (fecha, monto) VALUES (?, ?)";

        try (Connection conn = ConnectionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
            stmt.setDouble(2, monto);

            stmt.executeUpdate();
            System.out.println("Costo de item registrado en la BD.");
        } catch (SQLException e) {
            System.out.println("Error al registrar costo: " + e.getMessage());
        }
    }
}
