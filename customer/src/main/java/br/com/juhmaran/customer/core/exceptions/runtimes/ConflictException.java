package br.com.juhmaran.customer.exceptions.runtimes;

public class ConflictException extends RuntimeException {
    public ConflictException(String message) {
        super(message);
    }
}
