package br.com.juhmaran.customer.api.services.impl;

import br.com.juhmaran.customer.api.domain.dtos.CustomerRequest;
import br.com.juhmaran.customer.api.domain.dtos.CustomerResponse;
import br.com.juhmaran.customer.api.domain.entities.Customer;
import br.com.juhmaran.customer.api.mapping.CustomerMapper;
import br.com.juhmaran.customer.api.repositories.CustomerRepository;
import br.com.juhmaran.customer.api.services.CustomerService;
import br.com.juhmaran.customer.api.specifications.CustomerSpecifications;
import br.com.juhmaran.customer.api.util.CustomerValidationService;
import br.com.juhmaran.customer.core.exceptions.runtimes.InternalServerErrorException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerValidationService customerValidationService;

    @Transactional
    @Override
    public CustomerResponse registerCustomer(CustomerRequest customerRequest) {
        try {
            customerValidationService.validateCustomerRequest(customerRequest);
            Customer customer = CustomerMapper.INSTANCE.customerRequestToCustomer(customerRequest);
            customer.setActive(true);
            customer = customerRepository.save(customer);
            return CustomerMapper.INSTANCE.customerToCustomerResponse(customer);
        } catch (Exception e) {
            throw new InternalServerErrorException("Erro ao registrar cliente", e);
        }
    }

    @Transactional
    @Override
    public CustomerResponse updateCustomer(Long id, CustomerRequest customerRequest) {
        try {
            customerValidationService.validateCustomerId(id);
            Customer existingCustomer = customerValidationService.findCustomerById(id);
            customerValidationService.validateCustomerUpdate(id, customerRequest, existingCustomer);
            Customer updatedCustomer = customerValidationService.updateCustomerData(id, customerRequest);
            return CustomerMapper.INSTANCE.customerToCustomerResponse(updatedCustomer);
        } catch (Exception e) {
            throw new InternalServerErrorException("Erro ao atualizar cliente", e);
        }
    }

    @Transactional
    @Override
    public void deleteCustomer(Long id) {
        try {
            customerValidationService.validateCustomerId(id);
            Customer customer = customerValidationService.findCustomerById(id);
            customerRepository.delete(customer);
        } catch (Exception e) {
            throw new InternalServerErrorException("Erro ao deletar cliente", e);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public CustomerResponse getCustomerById(Long id) {
        try {
            customerValidationService.validateCustomerId(id);
            Customer customer = customerValidationService.findCustomerById(id);
            return CustomerMapper.INSTANCE.customerToCustomerResponse(customer);
        } catch (Exception e) {
            throw new InternalServerErrorException("Erro ao buscar cliente", e);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Page<CustomerResponse> listCustomers(String fullName, String email, String phoneNumber,
                                                String documentNumber, Boolean active, String sortBy,
                                                String sortDirection, int page, int size) {

        try {
            Pageable pageable = PageRequest.of(page, size, Sort.Direction.fromString(sortDirection), sortBy);
            Specification<Customer> spec = CustomerSpecifications
                    .buildCustomerSpecification(fullName, email, phoneNumber, documentNumber, active);

            Page<Customer> customers = customerRepository.findAll(spec, pageable);
            return customers.map(CustomerMapper.INSTANCE::customerToCustomerResponse);
        } catch (Exception e) {
            throw new InternalServerErrorException("Erro ao listar clientes", e);
        }
    }

}
