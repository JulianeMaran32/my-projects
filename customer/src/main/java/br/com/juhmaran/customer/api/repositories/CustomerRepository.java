package br.com.juhmaran.customer.api.repositories;

import br.com.juhmaran.customer.api.domain.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByName(String name);

    Optional<Customer> findByEmail(String email);

    Optional<Customer> findByCpf(String cpf);

}
