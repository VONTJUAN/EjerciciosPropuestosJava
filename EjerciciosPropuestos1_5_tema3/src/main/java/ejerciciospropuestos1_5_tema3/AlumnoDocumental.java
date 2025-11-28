package ejerciciospropuestos1_5_tema3;

import com.google.gson.*;
import java.io.*;
import java.util.*;

public class AlumnoDocumental {

    private final String jsonFile = "alumnos.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // Guarda la lista de alumnos convertida a JSON en un archivo
    public void guardar(List<Map<String, Object>> alumnos) throws IOException {
        try (Writer w = new FileWriter(jsonFile)) {
            gson.toJson(alumnos, w);
        }
    }

    // Lee el archivo JSON y devuelve la lista como estructuras Map
    public List<Map<String, Object>> leer() throws IOException {
        try (Reader r = new FileReader(jsonFile)) {
            return gson.fromJson(r, List.class);
        }
    }

    // Este main prueba los métodos de arriba
    public static void main(String[] args) throws IOException {
        AlumnoDocumental doc = new AlumnoDocumental();

        List<Map<String, Object>> lista = new ArrayList<>();
        lista.add(Map.of("nombre", "Ana", "edad", 20, "curso", "1DAM"));
        lista.add(Map.of("nombre", "Luis", "edad", 21, "curso", "2DAM"));

        doc.guardar(lista);

        System.out.println("Datos leídos del JSON: ");
        System.out.println(doc.leer());
    }
}
