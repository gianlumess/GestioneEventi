package gianlucamessina;

import gianlucamessina.dao.EventoDao;
import gianlucamessina.entities.Evento;
import gianlucamessina.entities.TipoEvento;
import gianlucamessina.exceptions.NotFoundException;
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
        Evento party = new Evento("techno party", "2024-10-06", "serata solo musica techno", TipoEvento.PUBBLICO, 200);
        ed.save(compleanno);
        /*  ed.save(party);*/


        //-----------------------------GET BY ID---------------------------
        try {
            Evento partyBYId = ed.getById(2);
            System.out.println(partyBYId);
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        //-----------------------------DELETE---------------------------

       /* try {
            ed.deleteById(1);
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }*/


        em.close();
        emf.close();
    }
}
