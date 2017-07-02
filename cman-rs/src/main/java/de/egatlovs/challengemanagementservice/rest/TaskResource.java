package de.egatlovs.challengemanagementservice.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import de.egatlovs.challengemanagementservice.boundary.TaskBoundary;
import de.egatlovs.challengemanagementservice.entity.TaskDto;

@RequestScoped
@Path("/tasks")
@Produces("application/json")
@Consumes("application/json")
public class TaskResource {

	@Inject
	private TaskBoundary boundary;

	@GET
	public Response getAll() {
		return Response.ok(boundary.getAll()).build();
	}

	@POST
	public Response create(TaskDto dto) {
		boundary.add(dto);
		return Response.ok().build();
	}

	@GET
	@Path("/{id}")
	public Response getTask(@PathParam("id") long id) {
		return Response.ok(boundary.getTask(id)).build();
	}

	@PUT
	@Path("/{id}")
	public Response update(@PathParam("id") long id, TaskDto dto) {
		boundary.update(dto);
		return Response.ok().build();
	}

	@DELETE
	public Response remove(TaskDto dto) {
		boundary.remove(dto);
		return Response.ok().build();
	}

}
