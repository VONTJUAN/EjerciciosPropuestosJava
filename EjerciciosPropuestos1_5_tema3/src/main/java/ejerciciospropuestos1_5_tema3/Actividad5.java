package ejerciciospropuestos1_5_tema3;

public class Actividad5 {

    public static void main(String[] args) {

        AlumnoRepository repo = new AlumnoRepository();

        repo.insertar(new Alumno("Pepe", 23));
        repo.insertar(new Alumno("Lucia", 21));

        repo.listar().forEach(a -> {
            System.out.println(a.getNombre() + " - " + a.getEdad());
        });
    }
}
