package ejerciciospropuestos2_tema3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class AlumnoDAOPlusTest {

    @Test
    void pruebaActualizarEdad() {
        AlumnoDAOPlus dao = new AlumnoDAOPlus();

        assertDoesNotThrow(() -> {
            dao.actualizarEdad("Ana", 25);
        });
    }

    @Test
    void pruebaBuscarPorNombre() {
        AlumnoDAOPlus dao = new AlumnoDAOPlus();

        assertDoesNotThrow(() -> {
            dao.buscarPorNombre("Ana");
        });
    }
}
