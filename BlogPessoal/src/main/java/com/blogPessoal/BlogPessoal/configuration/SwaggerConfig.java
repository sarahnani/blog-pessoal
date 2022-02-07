package com.blogPessoal.BlogPessoal.configuration;

import javax.sound.midi.MidiDevice.Info;

import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;


@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI springBlogPessoalOpenAPI() {
		return new OpenAPI()
			.info(new Info()
				.title("Blog Pessoal")
				.description("Blog Pessoal proposto pela Generation")
				.version("v0.0.1")
				.license(new License()
					.name("Gees Brazil")
					.url("<https://brazil.generation.org/>"))
				.contact(new Contact()
					.name("Github - @sarahnani")
					.url("<https://github.com/sarahnani>")))
			.externalDocs(new ExternalDocumentation()
				.description("Github - Projeto")
				.url("<https://github.com/sarahnani/blog-pessoal>"));
	}

	@Bean
	public OpenApiCustomiser customerGlobalHeaderOpenApiCustomiser() {

		return openApi -> {
			openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {

				ApiResponses apiResponses = operation.getResponses();

				apiResponses.addApiResponse("200", createApiResponse("Sucesso!"));
				apiResponses.addApiResponse("201", createApiResponse("Criado com sucesso!"));
				apiResponses.addApiResponse("204", createApiResponse("Não contem!"));
				apiResponses.addApiResponse("400", createApiResponse("Erro na requisição!"));
				apiResponses.addApiResponse("401", createApiResponse("Acesso não autorizado!"));
				apiResponses.addApiResponse("404", createApiResponse("Não encontramos nada!"));
				apiResponses.addApiResponse("500", createApiResponse("Erro na aplicação!"));

			}));
		};
	}

	private ApiResponse createApiResponse(String message) {

		return new ApiResponse().description(message);

	}
}
