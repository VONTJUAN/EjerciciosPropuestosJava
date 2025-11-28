package ejerciciospropuestos2_tema3;

import com.google.gson.*;
import java.io.*;
import java.util.*;

public class AlumnoObjectRepository {

    private final String fileName = "alumnosObjetos.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // Guarda la lista de alumnos como objetos JSON
    public void guardar(List<Alumno> alumnos) throws IOException {
        try (Writer w = new FileWriter(fileName)) {
            gson.toJson(alumnos, w);
        }
    }

    // Carga el JSON y lo convierte otra vez a objetos Alumno
    public List<Alumno> cargar() throws IOException {
        try (Reader r = new FileReader(fileName)) {
            Alumno[] arr = gson.fromJson(r, Alumno[].class);
            return Arrays.asList(arr);
        }
    }
}
