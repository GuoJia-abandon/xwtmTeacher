package com.guo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class XwtmGatewayStarter {
	public static void main(String[] args) {
		SpringApplication.run(XwtmGatewayStarter.class,args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("user",r -> r.path("/user/**").uri("http://localhost:22288"))
				.route("login",r -> r.path("/#/login/**").uri(""))
				.build();
	}
}
