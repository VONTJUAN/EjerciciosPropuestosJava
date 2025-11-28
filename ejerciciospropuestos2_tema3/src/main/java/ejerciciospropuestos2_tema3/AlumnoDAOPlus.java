package ejerciciospropuestos2_tema3;

import jakarta.persistence.*;
import java.util.List;

public class AlumnoDAOPlus {

    private EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("EscuelaPU");

    // ----------------------------
    // MÉTODO EJERCICIO 2
    // ----------------------------
    public void actualizarEdad(String nombre, int nuevaEdad) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        List<Alumno> lista = em
                .createQuery("from Alumno a where a.nombre = :n", Alumno.class)
                .setParameter("n", nombre)
                .getResultList();

        if (!lista.isEmpty()) {
            Alumno alu = lista.get(0);
            alu.setEdad(nuevaEdad);
            em.merge(alu);
        }

        em.getTransaction().commit();
        em.close();
    }

    // ----------------------------
    // MÉTODO EJERCICIO 2
    // ----------------------------
    public List<Alumno> buscarPorNombre(String nombre) {
        EntityManager em = emf.createEntityManager();

        List<Alumno> lista = em
                .createQuery("from Alumno a where a.nombre = :n", Alumno.class)
                .setParameter("n", nombre)
                .getResultList();

        em.close();
        return lista;
    }

    // ----------------------------
    // MÉTODOS DEL EJERCICIO 4
    // ----------------------------
    public List<Alumno> buscarPorEdad(int edadMinima) {
        EntityManager em = emf.createEntityManager();

        List<Alumno> lista = em
                .createQuery("from Alumno a where a.edad >= :e", Alumno.class)
                .setParameter("e", edadMinima)
                .getResultList();

        em.close();
        return lista;
    }

    public void borrar(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Alumno alu = em.find(Alumno.class, id);
        if (alu != null) {
            em.remove(alu);
        }

        em.getTransaction().commit();
        em.close();
    }
}
