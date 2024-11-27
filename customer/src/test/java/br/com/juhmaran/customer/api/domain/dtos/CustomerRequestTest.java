package br.com.juhmaran.customer.api.domain.dtos;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("Should return error when name is null")
    void shouldReturnErrorWhenNameIsInvalid() {
        CustomerRequest request = CustomerRequest.builder()
                .fullName("   ") // Nome inválido
                .email("email@valido.com")
                .documentNumber("123.456.789-00")
                .phoneNumber("+1234567890")
                .build();

        Set<ConstraintViolation<CustomerRequest>> violations = validator.validate(request);
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    @DisplayName("Should return error when email is invalid")
    void shouldReturnErrorWhenCpfIsInvalid() {
        CustomerRequest request = CustomerRequest.builder()
                .fullName("João da Silva")
                .email("email@valido.com")
                .documentNumber("12345678900") // CPF inválido
                .phoneNumber("+1234567890")
                .build();

        Set<ConstraintViolation<CustomerRequest>> violations = validator.validate(request);
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    @DisplayName("Should pass with valid data")
    void shouldPassWithValidData() {
        CustomerRequest request = CustomerRequest.builder()
                .fullName("João da Silva")
                .email("joao@email.com")
                .documentNumber("123.456.789-09") // CPF válido
                .phoneNumber("+1234567890")
                .build();

        Set<ConstraintViolation<CustomerRequest>> violations = validator.validate(request);
        Assertions.assertTrue(violations.isEmpty());
    }

    @Test
    @DisplayName("Should return error when phone is invalid")
    void shouldReturnErrorWhenPhoneIsInvalid() {
        CustomerRequest request = CustomerRequest.builder()
                .fullName("João da Silva")
                .phoneNumber("12345")
                .build();

        Set<ConstraintViolation<CustomerRequest>> violations = validator.validate(request);
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    @DisplayName("Should pass with valid phone")
    void shouldPassWithValidPhone() {
        CustomerRequest request = CustomerRequest.builder()
                .fullName("João da Silva")
                .email("joao@email.com")
                .documentNumber("123.456.789-09")
                .phoneNumber("+5511998765432")
                .build();

        Set<ConstraintViolation<CustomerRequest>> violations = validator.validate(request);
        Assertions.assertTrue(violations.isEmpty());
    }

}
