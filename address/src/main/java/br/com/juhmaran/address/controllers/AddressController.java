package br.com.juhmaran.address.controllers;

import br.com.juhmaran.address.domain.dtos.request.RegisterAddressRequest;
import br.com.juhmaran.address.domain.dtos.request.UpdateAddressRequest;
import br.com.juhmaran.address.domain.dtos.response.AddressResponse;
import br.com.juhmaran.address.domain.model.ViaCepResponse;
import br.com.juhmaran.address.services.AddressService;
import br.com.juhmaran.address.services.ViaCepService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
@Tag(name = "Address", description = "Address API")
@CrossOrigin(origins = "*")
public class AddressController {

    private final ViaCepService viaCepService;
    private final AddressService addressService;

    @Operation(summary = "Cadastrar um novo endereço", description = "Cadastrar um novo Endereço",
            tags = {"Address"}, responses = {
            @ApiResponse(responseCode = "201", description = "Endereço criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PostMapping
    public ResponseEntity<AddressResponse> createAddress(@Valid @RequestBody RegisterAddressRequest request) {
        AddressResponse response = addressService.registerAddress(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Atualizar endereço", description = "Atualizar um endereço por ID já cadastrado",
            operationId = "updateAddress", tags = {"Address"}, responses = {
            @ApiResponse(responseCode = "200", description = "Endereço atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "404", description = "Endereço não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PutMapping("/{id}")
    public ResponseEntity<AddressResponse> updateAddress(@PathVariable(value = "id") Long id,
                                                         @Valid @RequestBody UpdateAddressRequest request) {
        AddressResponse response = addressService.updateAddress(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(summary = "Excluir endereço", description = "Excluir um endereço por ID já cadastrado",
            operationId = "deleteAddress", tags = {"Address"}, responses = {
            @ApiResponse(responseCode = "204", description = "Endereço excluído com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "404", description = "Endereço não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable(value = "id") Long id) {
        addressService.deleteAddress(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(summary = "Obter endereço por ID", description = "Endereço por ID já cadastrado",
            operationId = "getAddressById", tags = {"Address"}, responses = {
            @ApiResponse(responseCode = "200", description = "Endereço encontrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "404", description = "Endereço não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping("/{id}")
    public ResponseEntity<AddressResponse> getAddressById(@PathVariable(value = "id") Long id) {
        AddressResponse response = addressService.findAddressById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(summary = "Listar todos os endereços cadastrados", description = "",
            operationId = "getAllAddresses", tags = {"Address"}, responses = {
            @ApiResponse(responseCode = "200", description = "Lista de endereços encontrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping
    public ResponseEntity<Page<AddressResponse>> getAllAddresses(Pageable pageable) {
        Page<AddressResponse> responses = addressService.findAllAddresses(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(responses);
    }

    @Operation(summary = "Obter endereço", description = "Obter endereço por UF, Localidade e Logradouro",
            operationId = "getAddressesByRegion", tags = {"Address"}, responses = {
            @ApiResponse(responseCode = "200", description = "Endereço encontrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "404", description = "Endereço não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping("/region")
    public ResponseEntity<List<ViaCepResponse>> getAddressesByRegion(
            @RequestParam(value = "state_abbreviation") String stateAbbreviation,
            @RequestParam(value = "city") String city,
            @RequestParam(value = "street") String street) {
        List<ViaCepResponse> responses = viaCepService.getAddressesByRegion(stateAbbreviation, city, street);
        return ResponseEntity.status(HttpStatus.OK).body(responses);
    }

    @Operation(summary = "Obter endereço por Usuário", description = "Endereço por ID de Usuário",
            operationId = "getAddressesByUser", tags = {"Address"}, responses = {
            @ApiResponse(responseCode = "200", description = "Endereço encontrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "404", description = "Endereço não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AddressResponse>> getAddressesByUser(@PathVariable(value = "userId") Long userId) {
        List<AddressResponse> responses = addressService.findAddressesByUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(responses);
    }

}
