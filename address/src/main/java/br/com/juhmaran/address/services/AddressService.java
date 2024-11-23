package br.com.juhmaran.address.services;

import br.com.juhmaran.address.domain.dtos.request.RegisterAddressRequest;
import br.com.juhmaran.address.domain.dtos.request.UpdateAddressRequest;
import br.com.juhmaran.address.domain.dtos.response.AddressResponse;

import java.util.List;

public interface AddressService {

    List<AddressResponse> findAllAddresses();

    AddressResponse findAddressById(Long id);

    AddressResponse registerAddress(RegisterAddressRequest registerAddressRequest);

    AddressResponse updateAddress(Long id, UpdateAddressRequest updateAddressRequest);

    void deleteAddress(Long id);

    AddressResponse searchAddressByZipCode(String cep);

    AddressResponse saveAddress(UpdateAddressRequest updateAddressRequest);

}
