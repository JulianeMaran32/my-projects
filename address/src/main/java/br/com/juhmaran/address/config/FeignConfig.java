package br.com.juhmaran.address.config;

import br.com.juhmaran.exceptionhandling.runtimes.BadRequestException;
import br.com.juhmaran.exceptionhandling.runtimes.InternalServerErrorException;
import br.com.juhmaran.exceptionhandling.runtimes.NotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }

    public static class CustomErrorDecoder implements ErrorDecoder {
        @Override
        public Exception decode(String methodKey, Response response) {
            return switch (response.status()) {
                case 400 -> new BadRequestException("Requisição inválida para a API ViaCep");
                case 404 -> new NotFoundException("Endereço não encontrado na API ViaCep");
                case 500 -> new InternalServerErrorException("Erro interno da API ViaCep");
                default -> new Exception("Erro inesperado da API ViaCep");
            };
        }
    }

}