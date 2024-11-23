package br.com.juhmaran.exceptionhandling.runtimes;

public class InternalServerErrorException extends RuntimeException {
    public InternalServerErrorException(String message) {
        super(message);
    }
}
