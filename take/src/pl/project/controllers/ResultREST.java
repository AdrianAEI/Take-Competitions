package pl.project.controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.*;

import pl.project.entities.Result;
import pl.project.services.ResultEJB;

@Path(value = "result")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class ResultREST {

	@EJB
	ResultEJB resultEJB;
	
	@GET
	@Path("/{id}")
	public Result getResult(@PathParam("id") Long id){
		return resultEJB.getResult(id);
	}
	
	@GET
	public List<Result> getAllResults(){
		return this.resultEJB.getAllResults();
	}
	
	@POST
	public String createResult(Result result) {
		resultEJB.createResult(result);
		return "result created!";
	}
	
	@PUT
	public String updateResult(Result result) {
		resultEJB.updateResult(result);
		return "result updated!";
	}
	
	@DELETE
	@Path("/{id}")
	public String deleteResult(@PathParam("id") Long id){
		resultEJB.deleteResult(id);
		return "result delated!";
	}
}
