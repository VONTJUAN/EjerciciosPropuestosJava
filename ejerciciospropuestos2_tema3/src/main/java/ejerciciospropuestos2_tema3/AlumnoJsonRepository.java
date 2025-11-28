package ejerciciospropuestos2_tema3;

import com.google.gson.*;
import java.io.*;
import java.util.*;

public class AlumnoJsonRepository {

    private final String fileName = "alumnos.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // Guarda la lista completa de alumnos en el JSON (sobrescribe el archivo entero)
    public void guardar(List<Map<String, Object>> alumnos) throws IOException {
        try (Writer w = new FileWriter(fileName)) {
            gson.toJson(alumnos, w);
        }
    }

    // Carga el JSON y devuelve la lista de alumnos como Map<String, Object>
    public List<Map<String, Object>> cargar() throws IOException {
        try (Reader r = new FileReader(fileName)) {
            return gson.fromJson(r, List.class);
        }
    }

    // Método de prueba (no hace falta pa la entrega pero viene bien)
    public static void main(String[] args) throws IOException {

        AlumnoJsonRepository repo = new AlumnoJsonRepository();

        // Creamos alumnos en forma de Map
        List<Map<String, Object>> lista = new ArrayList<>();
        lista.add(Map.of("nombre", "Pepe", "edad", 20, "curso", "1DAM"));
        lista.add(Map.of("nombre", "Lucia", "edad", 22, "curso", "2DAM"));

        // Guardamos en JSON
        repo.guardar(lista);

        // Leemos del JSON
        System.out.println("Alumnos leidos del JSON:");
        System.out.println(repo.cargar());
    }
}
