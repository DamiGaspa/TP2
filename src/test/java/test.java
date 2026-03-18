import Persistence.FileExporter;
import org.junit.Test;
import punto1.Contest;
import punto1.Inscription;
import punto1.Participant;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class test {

    @Test
    public void test1() throws IOException {
        var p1 = new Participant(1, "participante1@gmail.com");
        p1.fechaManual(new FakeDateProvider().fecha());
        var c1 = new Contest(1, new FileExporter(), new FakeDateProvider());
        var inscripcion = new Inscription();

        inscripcion.inscribirParticipante(p1, c1);
        System.out.println("Cantidad de inscriptos: " + c1.obtenerCantidadParticipantes());

        assertTrue(c1.existeParticipante(p1));
        assertTrue(c1.obtenerCantidadParticipantes() > 0);
    }

    @Test
    public void test2() throws IOException {
        var p1 = new Participant(2, "participante2@gmail.com");
        p1.fechaManual(new FakeDateProvider().fecha());
        var c1 = new Contest(2, new FileExporter(), new FakeDateProvider());
        var inscripcion = new Inscription();

        inscripcion.inscribirParticipante(p1, c1);
        System.out.println("Cantidad de inscriptos: " + c1.obtenerCantidadParticipantes());
        System.out.println("Cantidad de puntos: " + p1.getPuntos());

        assertTrue(c1.existeParticipante(p1));
        assertTrue(c1.obtenerCantidadParticipantes() > 0);
    }
}
