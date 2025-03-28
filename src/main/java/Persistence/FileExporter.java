package punto1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileExporter1 implements Exportador {
    private final File archivo;

    public FileExporter1(String filePath) {
        this.archivo = new File(filePath);
    }

    public void export(String data) {
        //String fechaHora = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        //String registro = fechaHora + ", " + idParticipante + ", " + idConcurso + "\n";
        try (FileWriter writer = new FileWriter(archivo, true)) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
