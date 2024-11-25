package br.com.juhmaran.customer.core.exceptions.runtimes;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
