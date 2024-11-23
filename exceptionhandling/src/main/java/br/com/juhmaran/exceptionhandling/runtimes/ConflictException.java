package br.com.juhmaran.exceptionhandling.runtimes;

public class ConflictException extends RuntimeException {
    public ConflictException(String message) {
        super(message);
    }
}
