package ejerciciospropuestos1_5_tema3;

import java.util.List;

public class AlumnoService {

    private AlumnoDAO dao = new AlumnoDAO();
    private AlumnoFileRepository fileRepo = new AlumnoFileRepository();

    // Inserta un alumno usando el DAO
    public void agregarAlumno(String nombre, int edad) throws Exception {
        dao.insertar(nombre, edad);
    }

    // Muestra alumnos tanto de BD como del archivo
    public void mostrarAlumnos() throws Exception {
        List<String> lista = dao.listar();
        System.out.println("Alumnos en la BD:");
        lista.forEach(System.out::println);
    }

    // Guarda alumnos en un fichero
    public void guardarEnArchivo() throws Exception {
        List<String> lista = dao.listar();
        fileRepo.guardar(lista);
    }

    // Carga alumnos desde archivo
    public void mostrarArchivo() throws Exception {
        System.out.println("Alumnos guardados en archivo:");
        fileRepo.cargar().forEach(System.out::println);
    }
}
