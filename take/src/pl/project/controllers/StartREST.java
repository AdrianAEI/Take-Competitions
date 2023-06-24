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

import pl.project.entities.Start;
import pl.project.services.StartEJB;

@Path(value = "start")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class StartREST {

	@EJB
	StartEJB startEJB;
	
	@GET
	@Path("/{id}")
	public Start getStart(@PathParam("id") Long id){
		return startEJB.getStart(id);
	}
	
	@GET 
	public List<Start>getAllStarts(){
		return startEJB.getAllStarts();
	}
	
	@POST
	public String createStart(Start start){
		startEJB.createStart(start);
		return "start created";
	}
	
	@PUT
	public String updateStart(Start start){
		startEJB.updateStart(start);
		return "start updated";
	}
	
	@DELETE
	@Path("/{id}")
	public String deleteStart(@PathParam("id") Long id){
		startEJB.deleteStart(id);
		return "start deleted";
	}
	
}
