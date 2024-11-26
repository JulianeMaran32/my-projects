package br.com.juhmaran.customer.api.specifications;

import br.com.juhmaran.customer.api.domain.entities.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;

/**
 * Class responsible for building customer specifications.
 *
 * @author Juliane Maran
 * @version 1.0.0
 * @since 2024-11-25
 */
@Slf4j
public class CustomerSpecifications {

    public static Specification<Customer> buildCustomerSpecification(String fullName, String email, String phoneNumber,
                                                                     String documentNumber, Boolean active) {
        log.debug("Building customer specification with parameters: fullName={}, email={}, phoneNumber={}, documentNumber={}, active={}",
                fullName, email, phoneNumber, documentNumber, active);
        Specification<Customer> spec = Specification.where(null);

        if (fullName != null && !fullName.isEmpty()) {
            spec = spec.and(nameContainsIgnoreCase(fullName));
        }
        if (email != null && !email.isEmpty()) {
            spec = spec.and(emailContainsIgnoreCase(email));
        }
        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            spec = spec.and(phoneContainsIgnoreCase(phoneNumber));
        }
        if (documentNumber != null && !documentNumber.isEmpty()) {
            spec = spec.and(cpfContainsIgnoreCase(documentNumber));
        }
        if (active != null) {
            spec = spec.and(isActive(active));
        }

        log.debug("Customer specification built successfully");
        return spec;
    }

    private static Specification<Customer> nameContainsIgnoreCase(String fullName) {
        log.debug("Creating specification for fullName contains ignore case: {}", fullName);
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("fullName")), "%" + fullName.toLowerCase() + "%");
    }

    private static Specification<Customer> emailContainsIgnoreCase(String email) {
        log.debug("Creating specification for email contains ignore case: {}", email);
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("email")), "%" + email.toLowerCase() + "%");
    }

    private static Specification<Customer> phoneContainsIgnoreCase(String phoneNumber) {
        log.debug("Creating specification for phoneNumber contains ignore case: {}", phoneNumber);
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("phoneNumber")), "%" + phoneNumber.toLowerCase() + "%");
    }

    private static Specification<Customer> cpfContainsIgnoreCase(String documentNumber) {
        log.debug("Creating specification for documentNumber contains ignore case: {}", documentNumber);
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("documentNumber")), "%" + documentNumber.toLowerCase() + "%");
    }

    private static Specification<Customer> isActive(Boolean active) {
        log.debug("Creating specification for active: {}", active);
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("active"), active);
    }

}