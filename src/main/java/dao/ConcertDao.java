package dao;

import java.io.Serializable;

import domain.Artiste;
import domain.Concert;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpa.EntityManagerHelper;

public class ConcertDao implements GenericDao<Concert, Long>{

	@Override
	public Concert save(Concert t) {
		EntityManager manager= EntityManagerHelper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Artiste artiste = new Artiste("Almok","Gospel");
		manager.persist(artiste);
		manager.persist(new Concert(artiste,t.getDate(),t.getLieu(),t.getPrix(),t.getDescription(),t.getNbrePlace()));
		return t;
	}

	@Override
	public Concert read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Concert update(Concert t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Concert t) {
		// TODO Auto-generated method stub
		
	}

}
