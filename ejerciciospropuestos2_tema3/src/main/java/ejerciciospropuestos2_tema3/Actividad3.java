package ejerciciospropuestos2_tema3;

import java.io.IOException;
import java.util.*;

public class Actividad3 {

    public static void main(String[] args) throws IOException {

        AlumnoObjectRepository repo = new AlumnoObjectRepository();

        // Lista de alumnos como objetos normales
        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno("Pepe", 20, "1DAM"));
        alumnos.add(new Alumno("Lucia", 22, "2DAM"));
        alumnos.add(new Alumno("Carlos", 19, "1ASIR"));

        // Guardamos en JSON
        repo.guardar(alumnos);

        // Cargamos otra vez desde el archivo JSON
        List<Alumno> cargados = repo.cargar();

        System.out.println("Alumnos leidos del JSON como OBJETOS:");
        cargados.forEach(System.out::println);
    }
}
