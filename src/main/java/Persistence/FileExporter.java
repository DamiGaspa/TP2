package Persistence;

import punto1.Exporter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileExporter implements Exporter {

    private static final String DIRECCION_LOCAL = "C:/Users/gaspa/Desktop/punto1.txt";

    public void export(String registro) {
        try {
            File archivo = new File(DIRECCION_LOCAL);
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
            Files.write(Paths.get(this.DIRECCION_LOCAL),
                    registro.getBytes(),
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo persistir...", e);
        }
    }
}
