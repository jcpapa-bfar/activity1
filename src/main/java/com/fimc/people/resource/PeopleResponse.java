package com.fimc.people.resource;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PeopleResponse implements Serializable {
	private String firstName;
	private String lastName;
	private String birthDate;
	
	 public PeopleResponse(String firstName, String lastName, String birthDate) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.birthDate = birthDate;
	    }
}
