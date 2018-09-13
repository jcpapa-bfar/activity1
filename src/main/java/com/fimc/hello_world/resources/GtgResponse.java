package com.fimc.hello_world.resources;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GtgResponse {
	public static final String OK = "ok";
	public static final String NOT_OK = "not_ok";
	
	private final String mode;
	private final String status;
	
	public GtgResponse(String mode, String status) {
		this.mode = mode;
		this.status = status;
	}

}
