package ejerciciospropuestos1_tema3;

import java.sql.*;
import java.util.*;

/**
 *
 * @author Juan
 */
public class Actividad4 {

    private final String url = "jdbc:mysql://localhost:3306/escuela";
    private final String user = "root";
    private final String pass = "";

    public void insertar(String nombre, int edad) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO alumno(nombre, edad) VALUES (?, ?)"
        );

        ps.setString(1, nombre);
        ps.setInt(2, edad);
        ps.executeUpdate();
        con.close();
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

    public static void main(String[] args) throws SQLException {
        Actividad4 dao = new Actividad4();
        dao.insertar("Juan", 22);

        System.out.println("Alumnos: " + dao.listar());
    }
}
