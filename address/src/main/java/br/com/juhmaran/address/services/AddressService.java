package br.com.juhmaran.address.services;

import br.com.juhmaran.address.domain.dtos.request.RegisterAddressRequest;
import br.com.juhmaran.address.domain.dtos.request.UpdateAddressRequest;
import br.com.juhmaran.address.domain.dtos.response.AddressResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AddressService {

    AddressResponse registerAddress(RegisterAddressRequest request);

    AddressResponse updateAddress(Long id, UpdateAddressRequest request);

    void deleteAddress(Long id);

    Page<AddressResponse> findAllAddresses(Pageable pageable);

    List<AddressResponse> findAddressesByUser(Long userId);

    AddressResponse findAddressById(Long id);

}
