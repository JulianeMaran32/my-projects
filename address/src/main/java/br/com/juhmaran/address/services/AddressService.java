package br.com.juhmaran.address.services;

import br.com.juhmaran.address.domain.dtos.request.AddressRequest;
import br.com.juhmaran.address.domain.dtos.response.AddressResponse;

import java.util.List;

public interface AddressService {

    List<AddressResponse> findAll();

    AddressResponse findById(Long id);

    AddressResponse create(AddressRequest addressRequest);

    AddressResponse update(Long id, AddressRequest addressRequest);

    void delete(Long id);

    AddressResponse findByCepAndSave(String cep);

    AddressResponse findByCep(String cep);

}
