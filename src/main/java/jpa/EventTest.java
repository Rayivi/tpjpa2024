package jpa;

import java.util.Date;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventTest {
	
	private EntityManager manager;
	
	public EventTest(EntityManager manager) {
		this.manager=manager;
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

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

			
   	 	manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		System.out.println(".. done");
	}


}
