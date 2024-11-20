package br.com.juhmaran.exception_handling.runtimes;

/**
 * 400 Bad Request
 *
 * @author Juliane Maran
 * @since 2024-11-20
 */
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
