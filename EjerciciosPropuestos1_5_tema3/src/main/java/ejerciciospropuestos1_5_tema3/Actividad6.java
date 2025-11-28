package ejerciciospropuestos1_5_tema3;

import java.sql.SQLException;

public class Actividad6 {

    public static void main(String[] args) throws SQLException {

        AlumnoDAO dao = new AlumnoDAO();

        System.out.println("Mostrando datos JSON:");
        dao.mostrarJSON();
    }
}
