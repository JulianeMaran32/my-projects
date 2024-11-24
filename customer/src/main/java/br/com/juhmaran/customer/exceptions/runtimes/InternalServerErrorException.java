package br.com.juhmaran.customer.exceptions.runtimes;

public class InternalServerErrorException extends RuntimeException {
    public InternalServerErrorException(String message) {
        super(message);
    }
}
