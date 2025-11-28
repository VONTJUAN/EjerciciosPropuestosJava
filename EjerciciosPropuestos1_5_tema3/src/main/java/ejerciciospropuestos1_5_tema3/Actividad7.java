package ejerciciospropuestos1_5_tema3;

import java.io.IOException;

public class Actividad7 {

    public static void main(String[] args) throws IOException {

        AlumnoDocumental doc = new AlumnoDocumental();

        System.out.println("Guardando y leyendo alumnos JSON...");

        doc.main(args); // reutiliza el main de la clase documental
    }
}
