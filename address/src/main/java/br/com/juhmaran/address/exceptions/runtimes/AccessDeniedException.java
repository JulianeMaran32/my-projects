package br.com.juhmaran.address.exceptions.runtimes;

public class AccessDeniedException extends RuntimeException {
    public AccessDeniedException(String message) {
        super(message);
    }
}
