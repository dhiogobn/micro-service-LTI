package br.edu.unifacisa.lti.configuration;

import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;

@OpenAPIDefinition(info = 
@Info(title = "User service Api", 
		version = "v1", 
		description = "Documentation of user service API"))
public class OpenApiConfiguration {
	
	private static final String API_SWAGGER_VERSION = "v1";
	private static final String LICENCE_URL = "http://springdoc.org";
	private static final String LICENCE_NAME = "Apache 2.0";
	private static final String API_TITLE = "User service API";

	@Bean
	public OpenAPI customOpenApi() {
		return new OpenAPI().components(new Components()).info( new io.swagger.v3.oas.models.info.Info()
				.title(API_TITLE)
				.version(API_SWAGGER_VERSION)
				.license(new License().name(LICENCE_NAME).url(LICENCE_URL)));

		
	}

}
