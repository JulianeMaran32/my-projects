package br.com.juhmaran.address.services;

import br.com.juhmaran.address.domain.model.ViaCepResponse;

import java.util.List;

public interface ViaCepService {

    ViaCepResponse getAddressByCep(String cep);

    List<ViaCepResponse> getAddressesByRegion(String stateAbbreviation, String city, String street);

}
