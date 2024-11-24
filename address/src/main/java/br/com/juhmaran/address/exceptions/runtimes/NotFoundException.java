package br.com.juhmaran.address.exceptions.runtimes;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
