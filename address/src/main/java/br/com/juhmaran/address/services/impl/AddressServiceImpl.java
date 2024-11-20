package br.com.juhmaran.address.services.impl;

import br.com.juhmaran.address.clients.ViaCepClient;
import br.com.juhmaran.address.domain.dtos.request.AddressRequest;
import br.com.juhmaran.address.domain.dtos.response.AddressResponse;
import br.com.juhmaran.address.domain.entities.AddressEntity;
import br.com.juhmaran.address.domain.model.ViaCepResponse;
import br.com.juhmaran.address.exceptions.ResourceNotFoundException;
import br.com.juhmaran.address.mapping.AddressMapper;
import br.com.juhmaran.address.repositories.AddressRepository;
import br.com.juhmaran.address.services.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final ViaCepClient viaCepClient;
    private final AddressMapper addressMapper = AddressMapper.INSTANCE;

    @Transactional(readOnly = true)
    @Override
    public List<AddressResponse> findAll() {
        return addressRepository.findAll().stream()
                .map(addressMapper::addressEntityToResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public AddressResponse findById(Long id) {
        AddressEntity addressEntity = getAddress(id);
        return addressMapper.addressEntityToResponse(addressEntity);
    }

    @Transactional
    @Override
    public AddressResponse create(AddressRequest addressRequest) {
        ViaCepResponse viaCepResponse = viaCepClient.getAddressByCep(addressRequest.getZipCode());
        AddressEntity addressEntity = addressMapper.viaCepResponseToEntity(viaCepResponse);
        addressEntity.setZipCode(addressRequest.getZipCode());
        addressEntity.setComplement(addressRequest.getComplement());
        addressEntity.setUnit(addressRequest.getUnit());
        AddressEntity savedEntity = addressRepository.save(addressEntity);
        return addressMapper.addressEntityToResponse(savedEntity);
    }

    @Transactional
    @Override
    public AddressResponse update(Long id, AddressRequest addressRequest) {
        AddressEntity existingAddress = getAddress(id);
        existingAddress.setZipCode(addressRequest.getZipCode());
        existingAddress.setStreet(addressRequest.getStreet());
        existingAddress.setComplement(addressRequest.getComplement());
        existingAddress.setUnit(addressRequest.getUnit());
        existingAddress.setNeighborhood(addressRequest.getNeighborhood());
        existingAddress.setCity(addressRequest.getCity());
        existingAddress.setStateAbbreviation(addressRequest.getStateAbbreviation());
        existingAddress.setState(addressRequest.getState());
        AddressEntity updatedEntity = addressRepository.save(existingAddress);
        return addressMapper.addressEntityToResponse(updatedEntity);
    }

    private AddressEntity getAddress(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Endereço não encontrado"));
    }

    @Transactional
    @Override
    public void delete(Long id) {
        addressRepository.deleteById(id);
    }

    @Transactional
    @Override
    public AddressResponse findByCep(String cep) {
        ViaCepResponse viaCepResponse = viaCepClient.getAddressByCep(cep);
        AddressEntity addressEntity = addressMapper.viaCepResponseToEntity(viaCepResponse);
        AddressEntity savedEntity = addressRepository.save(addressEntity);
        return addressMapper.addressEntityToResponse(savedEntity);
    }

}
