package br.com.juhmaran.address.config;

import br.com.juhmaran.address.exceptions.ViaCepException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return (methodKey, response) -> switch (response.status()) {
            case 400 -> new ViaCepException("Bad Request to ViaCep API");
            case 404 -> new ViaCepException("Address not found in ViaCep API");
            default -> new ViaCepException("Unexpected error from ViaCep API");
        };
    }

}