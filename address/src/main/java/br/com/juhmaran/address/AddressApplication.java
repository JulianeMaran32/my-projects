package br.com.juhmaran.address;

import br.com.juhmaran.address.config.FeignConfig;
import br.com.juhmaran.exceptionhandling.annotations.EnableExceptionHandling;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

@OpenAPIDefinition(
        info = @Info(
                title = "Petshop API", version = "1.0",
                description = "API para gerenciamento de petshops.",
                contact = @Contact(
                        name = "Juliane Maran",
                        email = "juliane.vmaran@gmail.com")),
        externalDocs = @ExternalDocumentation(
                description = "Documentação da API",
                url = "http://localhost:8081/api/v1/swagger-ui/index.html#/"),
        servers = {
                @Server(url = "http://localhost:8081/api/v1", description = "Local")
        })
@EnableExceptionHandling
@EnableCaching(proxyTargetClass = true)
@EnableFeignClients(basePackages = "br.com.juhmaran.address.clients", defaultConfiguration = FeignConfig.class)
@SpringBootApplication
public class AddressApplication {

    public static void main(String[] args) {
        SpringApplication.run(AddressApplication.class, args);
    }

}
