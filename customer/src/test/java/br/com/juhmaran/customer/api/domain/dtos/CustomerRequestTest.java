package br.com.juhmaran.customer.api.domain.dtos;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class CustomerRequestTest {

    private static Validator validator;

    @BeforeAll
    static void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void deveRetornarErroQuandoNomeForInvalido() {
        CustomerRequest request = CustomerRequest.builder()
                .name("   ") // Nome inválido
                .email("email@valido.com")
                .cpf("123.456.789-00")
                .build();

        Set<ConstraintViolation<CustomerRequest>> violations = validator.validate(request);
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    void deveRetornarErroQuandoCpfForInvalido() {
        CustomerRequest request = CustomerRequest.builder()
                .name("João da Silva")
                .email("email@valido.com")
                .cpf("12345678900") // CPF inválido
                .build();

        Set<ConstraintViolation<CustomerRequest>> violations = validator.validate(request);
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    void devePassarComDadosValidos() {
        CustomerRequest request = CustomerRequest.builder()
                .name("João da Silva")
                .email("joao@email.com")
                .cpf("123.456.789-09") // CPF válido
                .build();

        Set<ConstraintViolation<CustomerRequest>> violations = validator.validate(request);
        Assertions.assertTrue(violations.isEmpty());
    }

}
