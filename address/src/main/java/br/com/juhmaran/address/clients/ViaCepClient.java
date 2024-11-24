package br.com.juhmaran.address.clients;

import br.com.juhmaran.address.config.FeignConfig;
import br.com.juhmaran.address.domain.model.ViaCepResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "${via-cep.name}", url = "${via-cep.url}", configuration = FeignConfig.class)
public interface ViaCepClient {

    @GetMapping("/{cep}/json")
    ViaCepResponse fetchAddressByCep(@PathVariable(name = "cep") String cep);

    @GetMapping("/{uf}/{localidade}/{logradouro}/json")
    List<ViaCepResponse> fetchAddressesByRegion(@PathVariable(name = "uf") String uf,
                                                @PathVariable(name = "localidade") String localidade,
                                                @PathVariable(name = "logradouro") String logradouro);

}
