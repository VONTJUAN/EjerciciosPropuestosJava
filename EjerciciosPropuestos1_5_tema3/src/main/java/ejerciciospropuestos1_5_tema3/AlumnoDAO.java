package ejerciciospropuestos1_5_tema3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO {

    public void insertar(String nombre, int edad) {
        // método vacío, solo para probar que no lanza excepciones
    }

    public List<String> listar() throws SQLException {
        List<String> lista = new ArrayList<>();

        Connection con = DriverManager.getConnection(url, user, pass);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT nombre FROM alumno");

        while (rs.next()) {
            lista.add(rs.getString("nombre"));
        }

        con.close();
        return lista;
    }

    private final String url = "jdbc:mysql://localhost:3306/escuela";
    private final String user = "root";
    private final String pass = "";

    public void mostrarJSON() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, pass);
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(
                "SELECT nombre, JSON_EXTRACT(datos, '$.curso') AS curso FROM alumno"
        );

        while (rs.next()) {
            System.out.println(rs.getString("nombre") + " - Curso: " + rs.getString("curso"));
        }

        con.close();
    }
}
