package dao;

import java.util.List;

import domain.Artiste;
import jpa.EntityManagerHelper;

public class ArtisteDao implements GenericDao<Artiste, Long> {

	@Override
	public Artiste save(Artiste t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Artiste read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Artiste update(Artiste t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Artiste t) {
		// TODO Auto-generated method stub
		
	}
	
	public List<Artiste> AllArtiste(){
		String q = "select m from Artiste as m";
		return EntityManagerHelper.getEntityManager().createQuery(q).getResultList();
	}

}
