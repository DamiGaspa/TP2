package punto1;

import Persistence.InscripcionDAO;

import java.time.LocalDate;
import java.util.ArrayList;

public class Concurso {
    private int id;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private int cantidadParticipantes;
    private ArrayList<Participante> participantes;
    private Exportador registro;
    private ProveedorDeFecha proveedor;

    public Concurso(int id, Exportador registro, ProveedorDeFecha proveedor) {
        this.id = id;
        this.participantes = new ArrayList<>();
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

    public void inscribir(Participante p) {
        this.participantes.add(p);
        this.cantidadParticipantes++;
        p.seInscribio();
        String datos = this.proveedor.fecha().toString() + "||" + p.getId() + "\n";
        this.registro.export(datos);
        InscripcionDAO.registrarInscripcion(p.getId(), this.obtenerId(), "damigasparini96@gmail.com");
    }

    public boolean existeParticipante(Participante p) {
        for (Participante participante : participantes) {
            if (participante.equals(p)) {
                return true;
            }
        }
        return false;
    }
}
