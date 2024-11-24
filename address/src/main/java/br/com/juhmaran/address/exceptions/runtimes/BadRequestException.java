package br.com.juhmaran.address.exceptions.runtimes;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
