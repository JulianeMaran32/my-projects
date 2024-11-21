package br.com.juhmaran.exception_handling.runtimes;

/**
 * 403 Forbidden
 *
 * @author Juliane Maran
 * @since 2024-11-20
 */
public class AccessDeniedException extends RuntimeException {
    public AccessDeniedException(String message) {
        super(message);
    }
}
