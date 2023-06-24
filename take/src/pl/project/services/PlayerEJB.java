package pl.project.services;

import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pl.project.entities.Player;

@Stateless
public class PlayerEJB {
	
	@PersistenceContext(name = "players")
	EntityManager manager;

	public Player getPlayer(Long id) {
		Player player = manager.find(Player.class, id);
		
		return player;
	}

	public List<Player> getAllPlayers() {
		Query query = manager.createQuery("SELECT P FROM Player P");

		@SuppressWarnings("unchecked")
		List<Player> players = query.getResultList();
		
		return players;
	}

	public void createPlayer(Player player) {
		manager.persist(player);
		manager.flush();
		
	}

	public void updatePlayer(Player player) {
		manager.merge(player);
	}

	public void deletePlayer(Long id) {
		Player player = manager.find(Player.class,id);
		manager.remove(player);
	}

}
