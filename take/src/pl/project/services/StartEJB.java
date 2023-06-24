package pl.project.services;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pl.project.entities.Start;
@Stateless
public class StartEJB {
	
	@PersistenceContext(name = "starts")
	EntityManager manager;

	public Start getStart(Long id) {
		Start start = manager.find(Start.class, id);
		return start;
	}

	public List<Start> getAllStarts() {
		Query query = manager.createQuery("SELECT S FROM Start S");

		@SuppressWarnings("unchecked")
		List<Start> starts = query.getResultList();
		
		return starts;
	}

	public void createStart(Start start) {
		manager.persist(start);
		manager.flush();
	}

	public void updateStart(Start start) {
		manager.merge(start);
	}

	public void deleteStart(Long id) {
		Start start = manager.find(Start.class, id);
		manager.remove(start);
		
	}

}
