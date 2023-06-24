package pl.project.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pl.project.entities.Result;

@Stateless
public class ResultEJB {

	@PersistenceContext(name = "results")
	EntityManager manager;
	
	public Result getResult(Long id) {
		Result result = manager.find(Result.class,id);
		return result;
	}

	public List<Result> getAllResults() {
		
	Query query = manager.createQuery("SELECT R FROM Result R");
		
	@SuppressWarnings("unchecked")
	List<Result> results = query.getResultList();
	return results;
	}
	
	public void createResult(Result result) {
		manager.persist(result);
		manager.flush();
	}
	
	public void updateResult(Result result) {
		manager.merge(result);
	}
	
	public void deleteResult(Long id) {
		Result result = manager.find(Result.class, id);
		manager.remove(result);
	}
	
}