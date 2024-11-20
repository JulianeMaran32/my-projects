package br.com.juhmaran.exception_handling.runtimes;

/**
 * 401 Unauthorized
 *
 * @author Juliane Maran
 * @since 2024-11-20
 */
public class UnauthenticatedException extends RuntimeException {
    public UnauthenticatedException(String message) {
        super(message);
    }
}
