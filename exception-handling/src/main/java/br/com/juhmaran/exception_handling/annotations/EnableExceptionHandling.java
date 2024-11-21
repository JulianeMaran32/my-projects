package br.com.juhmaran.exception_handling.annotations;

import br.com.juhmaran.exception_handling.handler.GlobalExceptionHandler;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Anotação para habilitar o tratamento global de exceções.
 * <p>
 * Esta anotação deve ser usada em classes de configuração para importar o `GlobalExceptionHandler`
 * e habilitar o tratamento centralizado de exceções em uma aplicação Spring Boot.
 * </p>
 *
 * <p><b>Exemplo de uso:</b></p>
 * <pre>
 * &#064;SpringBootApplication
 * &#064;EnableExceptionHandling
 * public class MyApplication {
 *     public static void main(String[] args) {
 *         SpringApplication.run(MyApplication.class, args);
 *     }
 * }
 * </pre>
 *
 * @author Juliane Maran
 * @since 2024-11-20
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(value = {GlobalExceptionHandler.class})
public @interface EnableExceptionHandling {
}