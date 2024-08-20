package gianlucamessina;

import gianlucamessina.dao.EventoDao;
import gianlucamessina.entities.Evento;
import gianlucamessina.entities.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("BE_U1_S3_L2");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventoDao ed = new EventoDao(em);

        //-----------------------------SAVE---------------------------
        Evento compleanno = new Evento("festa di compleanno", "2024-09-12", "non scordatevi i regali!", TipoEvento.PRIVATO, 40);
        ed.save(compleanno);
        System.out.println("Hello World!");
    }
}
