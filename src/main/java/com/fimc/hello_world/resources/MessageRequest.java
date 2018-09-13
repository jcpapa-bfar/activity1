package com.fimc.hello_world.resources;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
public class MessageRequest implements Serializable {
	private String firstName;
	private String lastName;
}
