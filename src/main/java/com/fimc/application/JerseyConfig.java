package com.fimc.application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.stereotype.Component;

import com.fimc.calculator.resource.CalculatorResource;
import com.fimc.hello_world.resources.GtgResource;
import com.fimc.hello_world.resources.HelloResource;
import com.fimc.people.resource.PeopleResource;

@Component
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		register(GtgResource.class);
		register(HelloResource.class);
		register(CalculatorResource.class);
		register(PeopleResource.class);
		property(ServletProperties.FILTER_FORWARD_ON_404, true);
	}

}
