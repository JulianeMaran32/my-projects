package br.com.juhmaran.exceptionhandling.annotations;

import br.com.juhmaran.exceptionhandling.handler.GlobalExceptionHandler;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR})
@Import(value = {GlobalExceptionHandler.class})
public @interface EnableExceptionHandling {
}
