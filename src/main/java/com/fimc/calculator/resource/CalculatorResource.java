package com.fimc.calculator.resource;

import java.io.Serializable;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@Path("calculator")
public class CalculatorResource implements Serializable {
	CalculatorResponse calculatorResponse = new CalculatorResponse();
	int defineDecimal;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response calculator(CalculatorRequest request) {
		if (StringUtils.isEmpty(request.getOperator()) || StringUtils.isEmpty(request.getNumber1())|| StringUtils.isEmpty(request.getNumber2())) {
			return Response.status(HttpServletResponse.SC_BAD_REQUEST).entity("All fields are required").type(MediaType.TEXT_PLAIN).build();
		} else if(!request.getNumber1().matches("[0-9]+") || !request.getNumber2().matches("[0-9]+")) {
			return Response.status(HttpServletResponse.SC_BAD_REQUEST).entity("Enter a valid number").type(MediaType.TEXT_PLAIN).build();
		} else if(request.getOperator().equals("+")) {
			calculatorResponse.setAction("Addition");
			calculatorResponse.setResult(Integer.parseInt(request.getNumber1()) + Integer.parseInt(request.getNumber2()));
			return Response.ok().entity(calculatorResponse).build();
		} else if(request.getOperator().equals("-")) {
			calculatorResponse.setAction("Subtraction");
			calculatorResponse.setResult(Integer.parseInt(request.getNumber1()) - Integer.parseInt(request.getNumber2()));
			return Response.ok().entity(calculatorResponse).build();
		} else if(request.getOperator().equals("*")) {
			calculatorResponse.setAction("Multiplication");
			calculatorResponse.setResult(Integer.parseInt(request.getNumber1()) * Integer.parseInt(request.getNumber2()));
			return Response.ok().entity(calculatorResponse).build();
		} else if(request.getOperator().equals("/")) {
			if (Integer.parseInt(request.getNumber2())==0) {
				return Response.status(HttpServletResponse.SC_BAD_REQUEST).entity("Divisor is 0").type(MediaType.TEXT_PLAIN).build();
			} else {
				calculatorResponse.setAction("Division");
				defineDecimal = Integer.parseInt(request.getNumber1())%Integer.parseInt(request.getNumber2());
				if (defineDecimal==0) {
					calculatorResponse.setResult(Integer.parseInt(request.getNumber1()) / Integer.parseInt(request.getNumber2()));
					System.out.println(Integer.parseInt(String.format("%.0f", calculatorResponse.getResult())));
				} else {
					calculatorResponse.setResult(Double.parseDouble(String.format("%.5f", Double.valueOf(request.getNumber1()) / Double.valueOf(request.getNumber2()))));
					System.out.println(String.format("%.5f",calculatorResponse.getResult()));
				}
				return Response.ok().entity(calculatorResponse).build();
			}
		} else {
			return Response.status(HttpServletResponse.SC_BAD_REQUEST).entity("Invalid Operator").type(MediaType.TEXT_PLAIN).build();
		}
	}

}