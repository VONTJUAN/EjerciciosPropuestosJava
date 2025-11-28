package ejerciciospropuestos1_5_tema3;

import jakarta.persistence.*;
import java.util.List;

public class AlumnoRepository {

    private EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("EscuelaPU");

    public void insertar(Alumno a) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        em.close();
    }

    public List<Alumno> listar() {
        EntityManager em = emf.createEntityManager();
        List<Alumno> lista
                = em.createQuery("from Alumno", Alumno.class).getResultList();
        em.close();
        return lista;
    }
}
