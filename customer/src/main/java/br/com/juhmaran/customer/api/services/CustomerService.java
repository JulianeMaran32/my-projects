package br.com.juhmaran.customer.api.services;

import br.com.juhmaran.customer.api.domain.dtos.CustomerRequest;
import br.com.juhmaran.customer.api.domain.dtos.CustomerResponse;
import org.springframework.data.domain.Page;

public interface CustomerService {

    CustomerResponse registerCustomer(CustomerRequest customerRequest);

    CustomerResponse updateCustomer(Long id, CustomerRequest customerRequest);

    void deleteCustomer(Long id);

    Page<CustomerResponse> listCustomers(String fullName, String email, String phoneNumber, String documentNumber, Boolean active,
                                         String sortBy, String sortDirection, int page, int size);

    CustomerResponse getCustomerById(Long id);

}
