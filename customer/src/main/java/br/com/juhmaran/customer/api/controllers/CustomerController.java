package br.com.juhmaran.customer.api.controllers;

import br.com.juhmaran.customer.api.domain.dtos.CustomerRequest;
import br.com.juhmaran.customer.api.domain.dtos.CustomerResponse;
import br.com.juhmaran.customer.api.services.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "Customer", description = "Customer API")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponse> registerCustomer(@RequestBody @Valid CustomerRequest customerRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.registerCustomer(customerRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable(name = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getCustomerById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable(name = "id") Long id,
                                                           @RequestBody @Valid CustomerRequest customerRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.updateCustomer(id, customerRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable(name = "id") Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<Page<CustomerResponse>> listCustomers(
            @RequestParam(required = false, name = "full_name") String fullName,
            @RequestParam(required = false, name = "email") String email,
            @RequestParam(required = false, name = "phone_number") String phoneNumber,
            @RequestParam(required = false, name = "document_number") String documentNumber,
            @RequestParam(required = false) Boolean active,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<CustomerResponse> customers = customerService
                .listCustomers(fullName, email, phoneNumber, documentNumber, active, sortBy, sortDirection, page, size);
        return ResponseEntity.status(HttpStatus.OK).body(customers);
    }

}
