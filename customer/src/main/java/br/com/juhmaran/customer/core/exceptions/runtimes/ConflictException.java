package br.com.juhmaran.customer.core.exceptions.runtimes;

public class ConflictException extends RuntimeException {
    public ConflictException(String message) {
        super(message);
    }
}
