package com.petconnect.registration_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Registration Service API - PetConnect")
                        .version("1.0.0")
                        .description("API para el registro de usuarios en PetConnect")
                        .contact(new Contact()
                                .name("Equipo PetConnect")
                                .email("soporte@petconnect.com")
                                .url("https://petconnect.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")));
    }
}
