package punto1;

import java.io.IOException;

public class Inscription {
    private Contest contest;
    private Participant participant;

    public void inscribirParticipante(Participant participant, Contest contest) throws IOException {
        if (verificarFecha(participant, contest)) {
            contest.inscribir(participant);
        } else {
            System.out.println("La fecha de inscripcion expiró.");
        }
    }

    public boolean verificarFecha(Participant participant, Contest contest) {
        if (participant.fechaInscripcion().isAfter(contest.getFechaInicial().plusDays(-1)) && participant.fechaInscripcion().isBefore(contest.getFechaFinal().plusDays(1))) {
            if (fechaPorPuntos(participant, contest)) {
                participant.sumarPuntos(10);
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean fechaPorPuntos(Participant participant, Contest contest) {
        if (participant.fechaInscripcion().equals(contest.getFechaInicial())) {
            return true;
        } else {
            return false;
        }
    }

}
