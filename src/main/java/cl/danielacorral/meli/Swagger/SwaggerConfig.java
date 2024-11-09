package cl.danielacorral.meli.Swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SwaggerConfig {

    @Bean
    public OpenAPI api(){
        return new OpenAPI()
                .info(new Info().title("API Urlshortener")
                        .version("v0.0.1")
                        .contact(new Contact().name("Daniela Corral").email("corral.daniela.s@gmail.com"))
                        .description("API para crear url más cortas"));
    }
}
