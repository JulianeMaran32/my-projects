package br.com.juhmaran.address.config;

import br.com.juhmaran.exception_handling.runtimes.BadRequestException;
import br.com.juhmaran.exception_handling.runtimes.InternalServerErrorException;
import br.com.juhmaran.exception_handling.runtimes.NotFoundException;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return (methodKey, response) -> switch (response.status()) {
            case 400 -> new BadRequestException("Requisição inválida para a API ViaCep");
            case 404 -> new NotFoundException("Endereço não encontrado na API ViaCep");
            default -> new InternalServerErrorException("Erro inesperado da API ViaCep");
        };
    }

}