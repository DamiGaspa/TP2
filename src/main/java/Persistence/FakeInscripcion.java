package Persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class FakeInscripcion implements InscripcionDB {

    public void export(int idParticipante, int idConcurso, String email) {
        String sql = "INSERT INTO Inscripciones (fecha, id_participante, id_concurso) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionDB.conectar()) {
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
                stmt.setInt(2, idParticipante);
                stmt.setInt(3, idConcurso);

                stmt.executeUpdate();
                System.out.println("Inscripción registrada en la BD.");

                String asunto = "Inscripción Confirmada";
                String mensaje = "¡Hola! Te has inscrito exitosamente en el concurso #" + idConcurso;
                EmailSender.enviarEmail(email, asunto, mensaje);
            }
        } catch (SQLException e) {
            System.out.println("Error al registrar inscripción: " + e.getMessage());
        }
    }
}
