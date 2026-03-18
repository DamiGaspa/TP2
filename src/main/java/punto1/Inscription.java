package punto1;

import java.io.IOException;

public class Inscripcion {
    private Concurso concurso;
    private Participante participante;

    public void inscribirParticipante(Participante participante, Concurso concurso) throws IOException {
        if (verificarFecha(participante, concurso)) {
            concurso.inscribir(participante);
        } else {
            System.out.println("La fecha de inscripcion expiró.");
        }
    }

    public boolean verificarFecha(Participante participante, Concurso concurso) {
        if (participante.fechaInscripcion().isAfter(concurso.getFechaInicial().plusDays(-1)) && participante.fechaInscripcion().isBefore(concurso.getFechaFinal().plusDays(1))) {
            if (fechaPorPuntos(participante, concurso)) {
                participante.sumarPuntos(10);
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean fechaPorPuntos(Participante participante, Concurso concurso) {
        if (participante.fechaInscripcion().equals(concurso.getFechaInicial())) {
            return true;
        } else {
            return false;
        }
    }

}
