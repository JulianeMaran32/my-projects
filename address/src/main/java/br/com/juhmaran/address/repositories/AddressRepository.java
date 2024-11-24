package br.com.juhmaran.address.repositories;

import br.com.juhmaran.address.domain.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    Optional<AddressEntity> findByZipCode(String zipCode);

    List<AddressEntity> findByUserId(Long userId);

}
