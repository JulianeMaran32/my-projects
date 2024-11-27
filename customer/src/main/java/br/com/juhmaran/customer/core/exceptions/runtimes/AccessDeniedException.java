package br.com.juhmaran.customer.core.exceptions.runtimes;

public class AccessDeniedException extends RuntimeException {
    public AccessDeniedException(String message) {
        super(message);
    }
}
