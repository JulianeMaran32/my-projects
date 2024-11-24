package br.com.juhmaran.address;

import br.com.juhmaran.address.config.FeignConfig;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

@OpenAPIDefinition(
        info = @Info(
                title = "Address API", version = "v1", description = "Address API",
                contact = @Contact(name = "Juliana Maran", email = "julianemaran@gmail.com"),
                license = @License(name = "MIT License", url = "https://opensource.org/licenses/MIT"),
                termsOfService = "https://opensource.org/licenses/MIT"),
        externalDocs = @ExternalDocumentation(description = "GitHub", url = "https://github.com/JulianeMaran32/my-projects"),
        servers = {@Server(url = "http://localhost:8081/api/v1", description = "Local server")})
@EnableCaching(proxyTargetClass = true)
@EnableFeignClients(basePackages = "br.com.juhmaran.address.clients", defaultConfiguration = FeignConfig.class)
@SpringBootApplication
public class AddressApplication {

    public static void main(String[] args) {
        SpringApplication.run(AddressApplication.class, args);
    }

}
