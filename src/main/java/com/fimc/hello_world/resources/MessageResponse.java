package com.fimc.hello_world.resources;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class MessageResponse implements Serializable {
	private String message;
}
