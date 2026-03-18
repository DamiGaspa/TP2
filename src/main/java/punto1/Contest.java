package punto1;

import Persistence.FakeInscripcion;

import java.time.LocalDate;
import java.util.ArrayList;

public class Contest {
    private int id;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private int cantidadParticipantes;
    private ArrayList<Participant> participants;
    private Exporter registro;
    private DateProvider proveedor;

    public Contest(int id, Exporter registro, DateProvider proveedor) {
        this.id = id;
        this.participants = new ArrayList<>();
        this.fechaInicial = LocalDate.of(2025, 3, 1);
        this.fechaFinal = LocalDate.of(2025, 3, 31);
        this.cantidadParticipantes = 0;
        this.registro = registro;
        this.proveedor = proveedor;
    }

    public LocalDate getFechaInicial() {
        return fechaInicial;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public int obtenerCantidadParticipantes() {
        return this.cantidadParticipantes;
    }

    public int obtenerId() {
        return id;
    }

    public void inscribir(Participant p) {
        this.participants.add(p);
        this.cantidadParticipantes++;
        p.seInscribio();
        String datos = this.proveedor.fecha().toString() + "||" + p.getId() + "\n";
        this.registro.export(datos);
        FakeInscripcion exportDB = new FakeInscripcion();
        exportDB.export(p.getId(), this.obtenerId(), p.email());
    }

    public boolean existeParticipante(Participant p) {
        for (Participant participant : participants) {
            if (participant.equals(p)) {
                return true;
            }
        }
        return false;
    }
}
