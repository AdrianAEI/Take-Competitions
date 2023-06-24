package pl.project.controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import pl.project.entities.Player;
import pl.project.services.PlayerEJB;

@Path(value = "player")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class PlayerREST {

	@EJB
	PlayerEJB playerEJB;
	
	@GET
	@Path("/{id}")
	public Player getPlayer(@PathParam("id") Long id) {
		return playerEJB.getPlayer(id);
	}

	@GET
	public List<Player> getAllPlayers() {
		return playerEJB.getAllPlayers();
	}
	
	@POST
	public String createPlayer(Player player) {
		playerEJB.createPlayer(player);
		return "player created!";
	}
	
	@PUT
	public String updatePlayer(Player player) {
		playerEJB.updatePlayer(player);
		return "player updated!";
	}
	
	@DELETE
	@Path("/{id}")
	public String deletePlayer(@PathParam("id") Long id) {
		playerEJB.deletePlayer(id);
		return "player delated!";
	}
	
}
