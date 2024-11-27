package br.com.juhmaran.customer.core.exceptions.runtimes;

public class UnauthenticatedException extends RuntimeException {
    public UnauthenticatedException(String message) {
        super(message);
    }
}
