package punto1;

import java.time.LocalDate;

public class Participant {
    private int id;
    private LocalDate fecha;
    private boolean inscripto;
    private int puntos;
    private String email;

    public Participant(int id, String email) {
        this.id = id;
        this.fecha = LocalDate.now();
        this.inscripto = false;
        this.puntos = 0;
        this.email = email;
    }

    public void seInscribio() {
        this.inscripto = true;
    }

    public int getPuntos() {
        return puntos;
    }

    public LocalDate fechaInscripcion() {
        return this.fecha;
    }

    public void fechaManual(LocalDate unaFecha) {
        this.fecha = unaFecha;
    }

    public void sumarPuntos(int puntos) {
        this.puntos += puntos;
    }

    public int getId() {
        return id;
    }

    public String email() {
        return email;
    }
}
