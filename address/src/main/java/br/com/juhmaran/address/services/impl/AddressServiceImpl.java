package br.com.juhmaran.address.services.impl;

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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final ViaCepServiceImpl viaCepService;

    @Transactional
    @Override
    public AddressResponse registerAddress(RegisterAddressRequest request) {
        if (request == null || request.getZipCode() == null) {
            throw new BadRequestException("Requisição ou CEP não podem ser nulos");
        }

        Optional<AddressEntity> existingAddress = addressRepository.findByZipCode(request.getZipCode());
        if (existingAddress.isPresent()) {
            return AddressMapper.INSTANCE.addressEntityToResponse(existingAddress.get());
        }

        try {
            ViaCepResponse viaCepResponse = viaCepService.getAddressByCep(request.getZipCode());
            AddressEntity addressEntity = AddressMapper.INSTANCE.addressRequestToEntity(request);
            AddressMapper.INSTANCE.updateAddressEntity(addressEntity, viaCepResponse);

            AddressEntity savedEntity = addressRepository.save(addressEntity);
            return AddressMapper.INSTANCE.addressEntityToResponse(savedEntity);
        } catch (NotFoundException e) {
            log.error("Endereço não encontrado para o CEP: {}", request.getZipCode(), e);
            throw new NotFoundException("Endereço não encontrado para o CEP fornecido.");
        } catch (Exception e) {
            log.error("Erro ao registrar endereço", e);
            throw new InternalServerErrorException("Erro ao registrar endereço");
        }
    }

    @Transactional
    @Override
    public AddressResponse updateAddress(Long id, UpdateAddressRequest request) {
        if (id == null || request == null) {
            throw new BadRequestException("ID ou Requisição não podem ser nulos");
        }
        try {
            AddressEntity existingAddress = addressFoundById(id);
            if (request.getZipCode() != null) {
                existingAddress.setZipCode(request.getZipCode());
            }
            if (request.getStreet() != null) {
                existingAddress.setStreet(request.getStreet());
            }
            if (request.getNumber() != null) {
                existingAddress.setNumber(request.getNumber());
            }
            if (request.getComplement() != null) {
                existingAddress.setComplement(request.getComplement());
            }
            if (request.getNeighborhood() != null) {
                existingAddress.setNeighborhood(request.getNeighborhood());
            }
            if (request.getCity() != null) {
                existingAddress.setCity(request.getCity());
            }
            if (request.getStateAbbreviation() != null) {
                existingAddress.setStateAbbreviation(request.getStateAbbreviation());
            }
            if (request.getState() != null) {
                existingAddress.setState(request.getState());
            }
            if (request.getCountry() != null) {
                existingAddress.setCountry(request.getCountry());
            }
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
        if (id == null) {
            throw new BadRequestException("ID não pode ser nulo");
        }

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

    @Transactional(readOnly = true)
    @Override
    public Page<AddressResponse> findAllAddresses(Pageable pageable) {
        return addressRepository.findAll(pageable)
                .map(AddressMapper.INSTANCE::addressEntityToResponse);
    }

    @Transactional(readOnly = true)
    @Override
    public List<AddressResponse> findAddressesByUser(Long userId) {
        if (userId == null) {
            throw new BadRequestException("ID do usuário não pode ser nulo");
        }

        try {
            return addressRepository.findByUserId(userId).stream()
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
        if (id == null) {
            throw new BadRequestException("ID não pode ser nulo");
        }

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

    private AddressEntity addressFoundById(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Endereço não encontrado"));
    }

}
