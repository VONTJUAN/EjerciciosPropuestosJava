package ejerciciospropuestos1_5_tema3;

import java.io.*;
import java.util.*;

public class AlumnoFileRepository {

    private final String fileName = "alumnos.txt";

    public void guardar(List<String> alumnos) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (String a : alumnos) {
                bw.write(a);
                bw.newLine();
            }
        }
    }

    public List<String> cargar() throws IOException {
        List<String> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lista.add(linea);
            }
        }
        return lista;
    }
}
