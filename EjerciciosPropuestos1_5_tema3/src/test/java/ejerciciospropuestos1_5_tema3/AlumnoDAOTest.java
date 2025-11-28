package ejerciciospropuestos1_5_tema3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlumnoDAOTest {

    @Test
    void testInsertarAlumno() {
        AlumnoDAO dao = new AlumnoDAO();

        assertDoesNotThrow(() -> {
            dao.insertar("AlumnoTest", 25);
        });
    }
}
