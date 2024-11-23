package br.com.juhmaran.exceptionhandling.runtimes;

public class AccessDeniedException extends RuntimeException {
    public AccessDeniedException(String message) {
        super(message);
    }
}
