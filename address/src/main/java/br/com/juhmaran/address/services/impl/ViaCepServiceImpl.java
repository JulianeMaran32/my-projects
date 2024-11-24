package br.com.juhmaran.address.services.impl;

import br.com.juhmaran.address.clients.ViaCepClient;
import br.com.juhmaran.address.domain.model.ViaCepResponse;
import br.com.juhmaran.address.exceptions.runtimes.InternalServerErrorException;
import br.com.juhmaran.address.exceptions.runtimes.NotFoundException;
import br.com.juhmaran.address.services.ViaCepService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ViaCepServiceImpl implements ViaCepService {

    private final ViaCepClient viaCepClient;

    @Transactional(readOnly = true)
    @Override
    public ViaCepResponse getAddressByCep(String cep) {
        try {
            log.info("Buscando endereço para o CEP: {}", cep);
            ViaCepResponse response = viaCepClient.fetchAddressByCep(cep);
            if (response == null || response.getCep() == null) {
                log.error("Endereço não encontrado para o CEP: {}", cep);
                throw new NotFoundException("Endereço não encontrado para o CEP fornecido.");
            }
            log.info("Endereço encontrado para o CEP: {}", cep);
            return response;
        } catch (NotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Erro ao buscar endereço para o CEP: {}", cep, e);
            throw new InternalServerErrorException("Erro ao buscar endereço para o CEP fornecido.");
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<ViaCepResponse> getAddressesByRegion(String stateAbbreviation, String city, String street) {
        try {
            log.info("Buscando endereços para a região - Estado: {}, Cidade: {}, Rua: {}", stateAbbreviation, city, street);
            List<ViaCepResponse> responses = viaCepClient.fetchAddressesByRegion(stateAbbreviation, city, street);
            if (responses == null || responses.isEmpty()) {
                log.error("Nenhum endereço encontrado para os critérios - Estado: {}, Cidade: {}, Rua: {}", stateAbbreviation, city, street);
                throw new NotFoundException("Nenhum endereço encontrado para os critérios fornecidos.");
            }
            log.info("Endereços encontrados para a região - Estado: {}, Cidade: {}, Rua: {}", stateAbbreviation, city, street);
            return responses;
        } catch (NotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Erro ao buscar endereços para a região - Estado: {}, Cidade: {}, Rua: {}", stateAbbreviation, city, street, e);
            throw new InternalServerErrorException("Erro ao buscar endereços para a região fornecida.");
        }
    }

}
