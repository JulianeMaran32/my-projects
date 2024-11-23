package br.com.juhmaran.exceptionhandling.runtimes;

public class UnauthenticatedException extends RuntimeException {
    public UnauthenticatedException(String message) {
        super(message);
    }
}
