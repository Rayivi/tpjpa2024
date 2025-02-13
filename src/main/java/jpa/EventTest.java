package jpa;

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
				Artiste artiste = new Artiste("Almok","Gospel");
				manager.persist(artiste);
				
				manager.persist(new Concert(artiste, "2025-04-11","palais de congres",20,"Thanks God for this new year",2000));

				manager.persist(new PremiumTicket(1, "email", manager.find(Concert.class, 1L), "VIP"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		// Example usage of findTicketsByConcert
        Concert concert = manager.find(Concert.class, 1L); // Assuming a concert with ID 1 exists
        test.findTicketsByConcert(concert);
			
   	 	manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		System.out.println(".. done");
	}


}
