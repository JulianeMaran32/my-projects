package br.com.juhmaran.customer.api.services;

import br.com.juhmaran.customer.api.domain.dtos.CustomerRequest;
import br.com.juhmaran.customer.api.domain.entities.Customer;
import br.com.juhmaran.customer.api.mapping.CustomerMapper;
import br.com.juhmaran.customer.api.repositories.CustomerRepository;
import br.com.juhmaran.customer.core.exceptions.runtimes.BadRequestException;
import br.com.juhmaran.customer.core.exceptions.runtimes.ConflictException;
import br.com.juhmaran.customer.core.exceptions.runtimes.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerValidationService {

    public static final String EMAIL_ALREADY_REGISTERED = "Email already registered.";
    public static final String NUMBER_ALREADY_REGISTERED = "Phone number already registered.";
    public static final String CPF_ALREADY_REGISTERED = "CPF already registered.";
    
    private final CustomerRepository customerRepository;

    public void validateCustomerRequest(CustomerRequest customerRequest) {
        if (customerRepository.existsByEmail(customerRequest.getEmail())) {
            throw new ConflictException(EMAIL_ALREADY_REGISTERED);
        }
        if (customerRepository.existsByPhoneNumber(customerRequest.getPhoneNumber())) {
            throw new ConflictException(NUMBER_ALREADY_REGISTERED);
        }
        if (customerRepository.existsByDocumentNumber(customerRequest.getDocumentNumber())) {
            throw new ConflictException(CPF_ALREADY_REGISTERED);
        }
    }

    public void validateCustomerUpdate(Long id, CustomerRequest customerRequest, Customer existingCustomer) {
        if (!existingCustomer.getEmail().equals(customerRequest.getEmail()) &&
                customerRepository.existsByEmail(customerRequest.getEmail())) {
            throw new ConflictException(EMAIL_ALREADY_REGISTERED);
        }
        if (!existingCustomer.getPhoneNumber().equals(customerRequest.getPhoneNumber()) &&
                customerRepository.existsByPhoneNumber(customerRequest.getPhoneNumber())) {
            throw new ConflictException(NUMBER_ALREADY_REGISTERED);
        }
        if (!existingCustomer.getDocumentNumber().equals(customerRequest.getDocumentNumber()) &&
                customerRepository.existsByDocumentNumber(customerRequest.getDocumentNumber())) {
            throw new ConflictException(CPF_ALREADY_REGISTERED);
        }
    }

    public void validateCustomerId(Long id) {
        if (id == null || id <= 0) {
            throw new BadRequestException("Invalid customer ID.");
        }
    }

    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer not found."));
    }

    public Customer updateCustomerData(Long id, CustomerRequest customerRequest) {
        Customer updatedCustomer = CustomerMapper.INSTANCE.customerRequestToCustomer(customerRequest);
        updatedCustomer.setId(id);
        return customerRepository.save(updatedCustomer);
    }

}
