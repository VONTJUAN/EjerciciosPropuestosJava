package ejerciciospropuestos1_5_tema3;

public class MainApp {

    public static void main(String[] args) throws Exception {

        AlumnoService service = new AlumnoService();

        // Insertar alumnos en la BD
        service.agregarAlumno("Juanito", 20);
        service.agregarAlumno("Pepe", 23);

        // Mostrar alumnos de la BD
        service.mostrarAlumnos();

        // Guardar alumnos en archivo
        service.guardarEnArchivo();

        // Leer alumnos desde el archivo
        service.mostrarArchivo();
    }
}
