package br.com.juhmaran.exception_handling.runtimes;

/**
 * 404 Not Found
 *
 * @author Juliane Maran
 * @since 2024-11-20
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
