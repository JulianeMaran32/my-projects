package br.com.juhmaran.customer;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@OpenAPIDefinition(
        info = @Info(
                title = "Customer API", version = "v1", description = "Customer API",
                contact = @Contact(name = "Juliane Maran", email = "julianemaran@gmail.com"),
                license = @License(name = "MIT License", url = "https://opensource.org/licenses/MIT"),
                termsOfService = "https://opensource.org/licenses/MIT"),
        externalDocs = @ExternalDocumentation(
                description = "GitHub",
                url = "https://github.com/JulianeMaran32/my-projects"),
        servers = {@Server(
                url = "http://localhost:8082/api/v1",
                description = "Local server")})
@EnableCaching(proxyTargetClass = true)
@SpringBootApplication
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

}
