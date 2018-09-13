package com.fimc.people.resource;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@Path("/people")
public class PeopleResource implements Serializable {
	private static List<PeopleResponse> peoplelist = new ArrayList<>();
	SimpleDateFormat dateFormatter = new SimpleDateFormat("MM-dd-yyyy");
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response hello(PeopleRequest request) {
		PeopleResponse messageResponse = new PeopleResponse(request.getFirstName(), request.getLastName(), dateFormatter.format(request.getBirthDate()));
		if(StringUtils.isEmpty(request.getFirstName()) || StringUtils.isEmpty(request.getLastName()) || request.getBirthDate()==null) {
			System.out.println("All fields are required");
			return Response.status(HttpServletResponse.SC_BAD_REQUEST).entity("All fields are required").type(MediaType.TEXT_PLAIN).build();
		} else {
			peoplelist.add(messageResponse);
			return Response.status(HttpServletResponse.SC_CREATED).entity(messageResponse).build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response hi(PeopleRequest request) {
		return Response.ok().entity(peoplelist).build();
	}
}
