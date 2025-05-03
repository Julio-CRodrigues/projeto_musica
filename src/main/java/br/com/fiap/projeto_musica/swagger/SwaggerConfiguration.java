package br.com.fiap.projeto_musica.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfiguration {
	
	@Bean
	OpenAPI configurarSwagger() {
		return new OpenAPI().info(new Info()
											.title("Projeto de Gestão Musical - FIAP")
											.description("Este projeto visa gerenciar as relações e "
											+ "as principais funcionalidades referentes aos relacionamentos"
											+ " entre os elementos "
											+ "artista, música e integrante em uma aplicação de alto nível de "
											+ "maturidade utilizando de recursos do framework SpringBoot")
											.summary("Este projeto visa gerenciar um sistema musical")
											.version("v1.0.0")
											.termsOfService("Termos de Serviço")
											.license(new License().url("www.fiap.com.br")
																  .name("Projeto de Gestão Musical - FIAP "
																  		+ "- Planos de Adesão")));
	}

}