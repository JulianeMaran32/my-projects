package br.com.juhmaran.exception_handling.runtimes;

/**
 * 409 Conflict
 *
 * @author Juliane Maran
 * @since 2024-11-20
 */
public class ConflictException extends RuntimeException {
    public ConflictException(String message) {
        super(message);
    }
}
