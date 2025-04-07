package oliveiradev.pets.DearPet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {
    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("REST API's RESTful, Spring Boot - DEAR PET")
                .version("v1")
                .description("REST API's RESTful, Spring Boot - DEAR PET")
                .termsOfService("https://github.com/rodrgo7")
                .license(new License()
                    .name("Apache 2.0")
                    .url("https://github.com/rodrgo7")
                )
            );
    }
}