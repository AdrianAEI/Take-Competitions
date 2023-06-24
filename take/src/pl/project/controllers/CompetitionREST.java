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

import pl.project.entities.Competition;
import pl.project.services.CompetitionEJB;


@Path(value = "competition")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class CompetitionREST {

	@EJB
	CompetitionEJB competitionEJB;
	
	@GET
	@Path("/{id}")
	public Competition getCompetition(@PathParam("id") Long id) {
		return competitionEJB.getCompetition(id);
	}
	
	@GET
	public List<Competition> getAllCompetitions() {
		return competitionEJB.getAllCompetitions();
	}
	
	@POST
	public String createCompetition(Competition competition){
		competitionEJB.createCompetition(competition);
		return "competition created!";
	}
	
	@PUT
	public String updateCompetition(Competition competition){
		competitionEJB.updateCompetition(competition);
		return "competition updated!";
	}
	
	@DELETE
	@Path("/{id}")
	public String deleteCompetition(@PathParam("id") Long id){
		competitionEJB.deleteCompetition(id);
		return "competition deleted!";
	}
	
}
