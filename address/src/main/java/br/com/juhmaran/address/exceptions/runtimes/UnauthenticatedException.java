package br.com.juhmaran.address.exceptions.runtimes;

public class UnauthenticatedException extends RuntimeException {
    public UnauthenticatedException(String message) {
        super(message);
    }
}
