package br.com.juhmaran.exception_handling.runtimes;

/**
 * 500 Internal Server Error
 *
 * @author Juliane Maran
 * @since 2024-11-20
 */
public class InternalServerErrorException extends RuntimeException {
    public InternalServerErrorException(String message) {
        super(message);
    }
}
