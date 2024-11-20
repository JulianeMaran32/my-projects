package br.com.juhmaran.address.clients;

import br.com.juhmaran.address.config.FeignConfig;
import br.com.juhmaran.address.domain.model.ViaCepResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${via-cep.name}", url = "${via-cep.url}", configuration = FeignConfig.class)
public interface ViaCepClient {

    @GetMapping("/{cep}/json")
    ViaCepResponse getAddressByCep(@PathVariable(name = "cep") String cep);

}
