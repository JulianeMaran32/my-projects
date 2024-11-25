package br.com.juhmaran.customer.core.exceptions.runtimes;

public class InternalServerErrorException extends RuntimeException {
    public InternalServerErrorException(String message) {
        super(message);
    }
}
