package com.johan.chatBotIntegration.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI chatbotOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("ChatBot Management API")
                        .description("REST API for ChatBot Management System")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Johan Paul D")
                                .email("djohanpaul2006@email.com"))
                        .license(new License()
                                .name("Apache 2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("Project Documentation"));
    }
}
