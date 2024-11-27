package br.com.juhmaran.customer.core.exceptions.runtimes;

public class NotFoundException extends RuntimeException {
  public NotFoundException(String message) {
    super(message);
  }
}
