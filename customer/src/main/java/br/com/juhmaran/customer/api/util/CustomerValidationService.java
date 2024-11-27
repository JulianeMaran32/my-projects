package br.com.juhmaran.customer.api.util;

import br.com.juhmaran.customer.api.domain.dtos.CustomerRequest;
import br.com.juhmaran.customer.api.domain.entities.Customer;
import br.com.juhmaran.customer.api.mapping.CustomerMapper;
import br.com.juhmaran.customer.api.repositories.CustomerRepository;
import br.com.juhmaran.customer.core.exceptions.runtimes.BadRequestException;
import br.com.juhmaran.customer.core.exceptions.runtimes.ConflictException;
import br.com.juhmaran.customer.core.exceptions.runtimes.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static br.com.juhmaran.customer.api.constants.CustomerConstants.*;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomerValidationService {

    private final CustomerRepository customerRepository;

    public void validateCustomerRequest(CustomerRequest customerRequest) {
        log.debug("Validating customer request: {}", customerRequest);
        if (customerRepository.existsByEmail(customerRequest.getEmail())) {
            log.warn("[Register Customer] Email already registered: {}", customerRequest.getEmail());
            throw new ConflictException(EMAIL_ALREADY_REGISTERED);
        }
        if (customerRepository.existsByPhoneNumber(customerRequest.getPhoneNumber())) {
            log.warn("[Register Customer] Phone number already registered: {}", customerRequest.getPhoneNumber());
            throw new ConflictException(NUMBER_ALREADY_REGISTERED);
        }
        if (customerRepository.existsByDocumentNumber(customerRequest.getDocumentNumber())) {
            log.warn("[Register Customer] Document number already registered: {}", customerRequest.getDocumentNumber());
            throw new ConflictException(CPF_ALREADY_REGISTERED);
        }
    }

    public void validateCustomerUpdate(Long id, CustomerRequest customerRequest, Customer existingCustomer) {
        log.debug("Validating customer update for ID: {}, request: {}", id, customerRequest);
        if (!existingCustomer.getEmail().equals(customerRequest.getEmail()) &&
                customerRepository.existsByEmail(customerRequest.getEmail())) {
            log.warn("[Update Customer] Email already registered: {}", customerRequest.getEmail());
            throw new ConflictException(EMAIL_ALREADY_REGISTERED);
        }
        if (!existingCustomer.getPhoneNumber().equals(customerRequest.getPhoneNumber()) &&
                customerRepository.existsByPhoneNumber(customerRequest.getPhoneNumber())) {
            log.warn("[Update Customer] Phone number already registered: {}", customerRequest.getPhoneNumber());
            throw new ConflictException(NUMBER_ALREADY_REGISTERED);
        }
        if (!existingCustomer.getDocumentNumber().equals(customerRequest.getDocumentNumber()) &&
                customerRepository.existsByDocumentNumber(customerRequest.getDocumentNumber())) {
            log.warn("[Update Customer] Document number already registered: {}", customerRequest.getDocumentNumber());
            throw new ConflictException(CPF_ALREADY_REGISTERED);
        }
    }

    public void validateCustomerId(Long id) {
        log.debug("Validating customer ID: {}", id);
        if (id == null || id <= 0) {
            log.error("Invalid customer ID: {}", id);
            throw new BadRequestException(INVALID_CUSTOMER_ID);
        }
    }

    public Customer findCustomerById(Long id) {
        log.debug("Finding customer by ID: {}", id);
        return customerRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Customer not found for ID: {}", id);
                    return new NotFoundException(CUSTOMER_NOT_FOUND);
                });
    }

    public Customer updateCustomerData(Long id, CustomerRequest customerRequest) {
        log.debug("Updating customer data for ID: {}, request: {}", id, customerRequest);
        Customer updatedCustomer = CustomerMapper.INSTANCE.customerRequestToCustomer(customerRequest);
        updatedCustomer.setId(id);
        Customer savedCustomer = customerRepository.save(updatedCustomer);
        log.info("Customer data updated successfully for ID: {}", id);
        return savedCustomer;
    }

}
