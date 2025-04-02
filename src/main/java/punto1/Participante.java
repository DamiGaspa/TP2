package punto1;

import java.time.LocalDate;

public class Participante {
    private int id;
    private LocalDate fecha;
    private boolean inscripto;
    private int puntos;

    public Participante(int id) {
        this.id = id;
        this.fecha = LocalDate.now();
        this.inscripto = false;
        this.puntos = 0;

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
}
