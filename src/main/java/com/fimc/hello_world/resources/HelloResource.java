package com.fimc.hello_world.resources;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;

import java.io.Serializable;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@Path("/message")
public class HelloResource implements Serializable{
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response hello(MessageRequest request) {
		if(StringUtils.isEmpty(request.getFirstName())||StringUtils.isEmpty(request.getLastName())) {
			return Response.status(HttpServletResponse.SC_BAD_REQUEST).build();
		}
		MessageResponse messageResponse = new MessageResponse();
		messageResponse.setMessage(String.format("Hello %s %s",
							request.getFirstName(),
							request.getLastName()));
		return Response.ok().entity(messageResponse).build();
	}
	
}