package jpa;

import java.util.Collection;

import dao.ArtisteDao;
import domain.Artiste;
import domain.Concert;
import domain.PremiumTicket;
import domain.Ticket;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class EventTest {
	
	private EntityManager manager;
	
	public EventTest(EntityManager manager) {
		this.manager=manager;
	}

	public void findTicketsByConcert(Concert concert) {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Ticket> cq = cb.createQuery(Ticket.class);
        Root<Ticket> ticket = cq.from(Ticket.class);
        cq.select(ticket).where(cb.equal(ticket.get("concert"), concert));

        manager.createQuery(cq).getResultList().forEach(System.out::println);
    }

	public static void main(String[] args) {
		EntityManager manager= EntityManagerHelper.getEntityManager();
		EventTest test = new EventTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			int numofConcert = manager.createQuery("Select a From Concert a", Concert.class).getResultList().size();
			if (numofConcert == 0) {
				Artiste artiste1 = new Artiste("Almok","Gospel");
				Artiste artiste2 = new Artiste("Dadju","Afro beat");
				Artiste artiste3 = new Artiste("SEthlo","Rap");
				Artiste artiste4 = new Artiste("Bouba","Rap");
				manager.persist(artiste1);
				manager.persist(artiste2);
				manager.persist(artiste3);
				manager.persist(artiste4);
				
				manager.persist(new Concert(artiste1, "2025-04-11","palais de congres",20,"Thanks God for this new year",2000));

				manager.persist(new PremiumTicket(1, "email", manager.find(Concert.class, 1L), "VIP"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ArtisteDao dao = new ArtisteDao();
		Collection<Artiste> mags = dao.AllArtiste();
		for (Artiste m : mags) {
			System.out.println(m.getNom());
		}
		
		tx.commit();

		// Example usage of findTicketsByConcert
        //Concert concert = manager.find(Concert.class, 1L); // Assuming a concert with ID 1 exists
        //test.findTicketsByConcert(concert);
			
   	 	manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		System.out.println(".. done");
	}


}
