package br.com.juhmaran.address.services.impl;

import br.com.juhmaran.address.clients.ViaCepClient;
import br.com.juhmaran.address.domain.dtos.request.AddressRequest;
import br.com.juhmaran.address.domain.dtos.response.AddressResponse;
import br.com.juhmaran.address.domain.entities.AddressEntity;
import br.com.juhmaran.address.domain.model.ViaCepResponse;
import br.com.juhmaran.address.mapping.AddressMapper;
import br.com.juhmaran.address.repositories.AddressRepository;
import br.com.juhmaran.address.services.AddressService;
import br.com.juhmaran.exception_handling.runtimes.InternalServerErrorException;
import br.com.juhmaran.exception_handling.runtimes.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        try {
            return addressRepository.findAll().stream()
                    .map(addressMapper::addressEntityToResponse)
                    .toList();
        } catch (Exception e) {
            log.error("Erro ao buscar endereços", e);
            throw new InternalServerErrorException("Erro ao buscar endereços");
        }
    }

    @Transactional(readOnly = true)
    @Override
    public AddressResponse findById(Long id) {
        try {
            AddressEntity addressEntity = getAddress(id);
            return addressMapper.addressEntityToResponse(addressEntity);
        } catch (NotFoundException e) {
            log.error("ID não encontrado", e);
            throw new NotFoundException("ID não encontrado");
        } catch (Exception e) {
            log.error("Erro ao buscar endereço por ID", e);
            throw new InternalServerErrorException("Erro ao buscar endereço por ID");
        }
    }

    @Transactional
    @Override
    public AddressResponse create(AddressRequest addressRequest) {
        try {
            ViaCepResponse viaCepResponse = viaCepClient.getAddressByCep(addressRequest.getZipCode());
            AddressEntity addressEntity = addressMapper.viaCepResponseToEntity(viaCepResponse);
            addressEntity.setZipCode(addressRequest.getZipCode());
            addressEntity.setComplement(addressRequest.getComplement());
            addressEntity.setUnit(addressRequest.getUnit());
            AddressEntity savedEntity = addressRepository.save(addressEntity);
            return addressMapper.addressEntityToResponse(savedEntity);
        } catch (Exception e) {
            log.error("Erro ao cadastar endereço.", e);
            throw new InternalServerErrorException("Erro ao cadastrar endereço.");
        }
    }

    @Transactional
    @Override
    public AddressResponse update(Long id, AddressRequest addressRequest) {
        try {
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
        } catch (Exception e) {
            log.error("Erro ao atualizar endereço.", e);
            throw new InternalServerErrorException("Erro ao atualizar endereço.");
        }
    }

    private AddressEntity getAddress(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Endereço não encontrado"));
    }

    @Transactional
    @Override
    public void delete(Long id) {
        AddressEntity addressEntity = getAddress(id);
        addressRepository.deleteById(addressEntity.getId());
    }

    @Transactional
    @Override
    public AddressResponse findByCepAndSave(String cep) {
        ViaCepResponse viaCepResponse = viaCepClient.getAddressByCep(cep);
        AddressEntity addressEntity = addressMapper.viaCepResponseToEntity(viaCepResponse);
        AddressEntity savedEntity = addressRepository.save(addressEntity);
        return addressMapper.addressEntityToResponse(savedEntity);
    }

    @Transactional(readOnly = true)
    @Override
    public AddressResponse findByCep(String cep) {
        ViaCepResponse viaCepResponse = viaCepClient.getAddressByCep(cep);
        AddressEntity addressEntity = addressMapper.viaCepResponseToEntity(viaCepResponse);
        return addressMapper.addressEntityToResponse(addressEntity);
    }
}
