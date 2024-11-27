package br.com.juhmaran.customer.api.repositories;

import br.com.juhmaran.customer.api.domain.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);

    boolean existsByDocumentNumber(String documentNumber);

    Page<Customer> findAll(Specification<Customer> spec, Pageable pageable);

}
