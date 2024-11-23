package br.com.juhmaran.exceptionhandling.runtimes;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
