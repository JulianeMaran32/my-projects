package br.com.juhmaran.address.services.impl;

import br.com.juhmaran.address.clients.ViaCepClient;
import br.com.juhmaran.address.domain.dtos.request.RegisterAddressRequest;
import br.com.juhmaran.address.domain.dtos.request.UpdateAddressRequest;
import br.com.juhmaran.address.domain.dtos.response.AddressResponse;
import br.com.juhmaran.address.domain.entities.AddressEntity;
import br.com.juhmaran.address.domain.model.ViaCepResponse;
import br.com.juhmaran.address.mapping.AddressMapper;
import br.com.juhmaran.address.repositories.AddressRepository;
import br.com.juhmaran.address.services.AddressService;
import br.com.juhmaran.exceptionhandling.runtimes.BadRequestException;
import br.com.juhmaran.exceptionhandling.runtimes.InternalServerErrorException;
import br.com.juhmaran.exceptionhandling.runtimes.NotFoundException;
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

    @Transactional(readOnly = true)
    @Override
    public List<AddressResponse> findAllAddresses() {
        try {
            return addressRepository.findAll().stream()
                    .map(AddressMapper.INSTANCE::addressEntityToResponse)
                    .toList();
        } catch (Exception e) {
            log.error("Erro ao listar endereços", e);
            throw new InternalServerErrorException("Erro ao listar endereços");
        }
    }

    @Transactional(readOnly = true)
    @Override
    public AddressResponse findAddressById(Long id) {
        try {
            AddressEntity addressEntity = addressFoundById(id);
            return AddressMapper.INSTANCE.addressEntityToResponse(addressEntity);
        } catch (NotFoundException e) {
            log.error("Endereço não encontrado para o id: {}", id, e);
            throw new NotFoundException("Endereço não encontrado");
        } catch (Exception e) {
            log.error("Erro ao encontrar endereço pelo id: {}", id, e);
            throw new InternalServerErrorException("Erro ao encontrar endereço pelo id");
        }
    }

    @Transactional
    @Override
    public AddressResponse registerAddress(RegisterAddressRequest registerAddressRequest) {
        try {
            AddressEntity addressEntity = AddressMapper.INSTANCE.addressRequestToEntity(registerAddressRequest);
            AddressEntity savedEntity = addressRepository.save(addressEntity);
            return AddressMapper.INSTANCE.addressEntityToResponse(savedEntity);
        } catch (Exception e) {
            log.error("Erro ao cadastrar endereço", e);
            throw new InternalServerErrorException("Erro ao cadastrar endereço");
        }
    }

    @Transactional
    @Override
    public AddressResponse updateAddress(Long id, UpdateAddressRequest updateAddressRequest) {
        try {
            AddressEntity existingAddress = addressFoundById(id);
            AddressMapper.INSTANCE.updateAddressEntity(existingAddress, updateAddressRequest);
            AddressEntity updatedEntity = addressRepository.save(existingAddress);
            return AddressMapper.INSTANCE.addressEntityToResponse(updatedEntity);
        } catch (NotFoundException e) {
            log.error("Endereço não encontrado para o id: {}", id, e);
            throw new NotFoundException("Endereço não encontrado");
        } catch (Exception e) {
            log.error("Erro ao atualizar endereço", e);
            throw new InternalServerErrorException("Erro ao atualizar endereço");
        }
    }

    @Transactional
    @Override
    public void deleteAddress(Long id) {
        try {
            AddressEntity existingAddress = addressFoundById(id);
            addressRepository.deleteById(existingAddress.getId());
        } catch (NotFoundException e) {
            log.error("Endereço não encontrado para o id: {}", id, e);
            throw new NotFoundException("Endereço não encontrado");
        } catch (Exception e) {
            log.error("Erro ao excluir endereço", e);
            throw new InternalServerErrorException("Erro ao excluir endereço");
        }
    }

    @Transactional
    @Override
    public AddressResponse searchAddressByZipCode(String cep) {
        try {
            ViaCepResponse viaCepResponse = viaCepClient.getAddressByCep(cep);
            AddressEntity addressEntity = AddressMapper.INSTANCE.viaCepResponseToEntity(viaCepResponse);
            return AddressMapper.INSTANCE.addressEntityToResponse(addressEntity);
        } catch (Exception e) {
            log.error("Erro ao buscar endereço", e);
            throw new InternalServerErrorException("Erro ao buscar endereço");
        }
    }

    @Transactional
    @Override
    public AddressResponse saveAddress(UpdateAddressRequest updateAddressRequest) {
        try {
            AddressEntity addressEntity = AddressMapper.INSTANCE.updateAddressRequestToEntity(updateAddressRequest);
            AddressEntity savedEntity = addressRepository.save(addressEntity);
            return AddressMapper.INSTANCE.addressEntityToResponse(savedEntity);
        } catch (Exception e) {
            log.error("Erro ao salvar endereço", e);
            throw new InternalServerErrorException("Erro ao salvar endereço");
        }
    }

    private AddressEntity addressFoundById(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Endereço não encontrado"));
    }

}
