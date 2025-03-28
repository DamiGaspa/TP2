package Persistence;

import punto1.Exportador;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Objects;

public class FileExporter implements Exportador {

    private String path;

    public FileExporter(String path) {
        this.path = Objects.requireNonNull(path);
    }

    public void export(String registro) {
        try {
            File archivo = new File(path);
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
            Files.write(Paths.get(this.path),
                    registro.getBytes(),
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo persistir...", e);
        }
    }
}
