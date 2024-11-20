package br.com.juhmaran.address.repositories;

import br.com.juhmaran.address.domain.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}
