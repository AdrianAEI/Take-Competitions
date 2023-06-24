package pl.project.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.core.Response;

import pl.project.entities.Competition;



@Stateless
public class CompetitionEJB {

	@PersistenceContext(name = "competitions")
	EntityManager manager;
	
	public Competition getCompetition(Long id){
		Competition competition = manager.find(Competition.class, id);
		return competition;
	}
	
	public List<Competition> getAllCompetitions(){
		
		Query query = manager.createQuery("SELECT C FROM Competition C");
		
		@SuppressWarnings("unchecked")
		List<Competition> competitions = query.getResultList();
		
		return competitions;
	}
	
	public void createCompetition(Competition competition){
		manager.persist(competition);
		manager.flush();
	}
	
	public void updateCompetition(Competition competition){
		manager.merge(competition);
	}
	
	public void deleteCompetition(Long id){
		Competition competition = manager.find(Competition.class,id);
		manager.remove(competition);
	}
	
}
