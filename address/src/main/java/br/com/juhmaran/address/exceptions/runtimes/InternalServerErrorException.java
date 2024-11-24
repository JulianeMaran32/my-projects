package br.com.juhmaran.address.exceptions.runtimes;

public class InternalServerErrorException extends RuntimeException {
    public InternalServerErrorException(String message) {
        super(message);
    }
}
