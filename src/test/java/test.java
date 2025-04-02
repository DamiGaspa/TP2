import Persistence.FileExporter;
import org.junit.Test;
import punto1.Concurso;
import punto1.Inscripcion;
import punto1.Participante;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class test {

    @Test
    public void test1() throws IOException {
        var p1 = new Participante(1);
        p1.fechaManual(new FakeProveedorDeFecha().fecha());
        var c1 = new Concurso(1, new FileExporter("C:/Users/gaspa.DAMI/Desktop/archivoprueba.txt"), new FakeProveedorDeFecha());
        var inscripcion = new Inscripcion();

        inscripcion.inscribirParticipante(p1, c1);
        System.out.println("Cantidad de inscriptos: " + c1.obtenerCantidadParticipantes());

        assertTrue(c1.existeParticipante(p1));
        assertTrue(c1.obtenerCantidadParticipantes() > 0);
    }

    @Test
    public void test2() throws IOException {
        var p1 = new Participante(2);
        p1.fechaManual(new FakeProveedorDeFecha().fecha());
        var c1 = new Concurso(2, new FileExporter("C:/Users/gaspa.DAMI/Desktop/archivoprueba.txt"), new FakeProveedorDeFecha());
        var inscripcion = new Inscripcion();

        inscripcion.inscribirParticipante(p1, c1);
        System.out.println("Cantidad de inscriptos: " + c1.obtenerCantidadParticipantes());
        System.out.println("Cantidad de puntos: " + p1.getPuntos());

        assertTrue(c1.existeParticipante(p1));
        assertTrue(c1.obtenerCantidadParticipantes() > 0);
    }
}
