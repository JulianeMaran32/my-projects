package br.com.juhmaran.customer.exceptions.runtimes;

public class UnauthenticatedException extends RuntimeException {
    public UnauthenticatedException(String message) {
        super(message);
    }
}
