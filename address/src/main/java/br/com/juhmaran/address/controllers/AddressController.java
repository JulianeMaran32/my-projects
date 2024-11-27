package br.com.juhmaran.address.controllers;

import br.com.juhmaran.address.domain.dtos.request.RegisterAddressRequest;
import br.com.juhmaran.address.domain.dtos.request.UpdateAddressRequest;
import br.com.juhmaran.address.domain.dtos.response.AddressResponse;
import br.com.juhmaran.address.domain.model.ViaCepResponse;
import br.com.juhmaran.address.exceptions.dtos.ErrorResponse;
import br.com.juhmaran.address.exceptions.dtos.ValidationErrorResponse;
import br.com.juhmaran.address.services.AddressService;
import br.com.juhmaran.address.services.ViaCepService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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
@CrossOrigin(origins = "*")
@Tag(name = "Address", description = "Endpoints para gerenciamento de endereços")
public class AddressController {

    private final ViaCepService viaCepService;
    private final AddressService addressService;

    @Operation(summary = "Cadastrar um novo endereço", description = "Cadastrar um novo Endereço",
            operationId = "createAddress", tags = {"Address"}, responses = {
            @ApiResponse(responseCode = "201", description = "Endereço criado com sucesso", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = AddressResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Requisição inválida", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ValidationErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    })
    @PostMapping
    public ResponseEntity<AddressResponse> createAddress(@Valid @RequestBody RegisterAddressRequest request) {
        AddressResponse response = addressService.registerAddress(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Atualizar endereço", description = "Atualizar um endereço por ID já cadastrado",
            operationId = "updateAddress", tags = {"Address"}, responses = {
            @ApiResponse(responseCode = "200", description = "Endereço atualizado com sucesso", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = AddressResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Requisição inválida", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ValidationErrorResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Endereço não encontrado", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    })
    @PutMapping("/{id}")
    public ResponseEntity<AddressResponse> updateAddress(@PathVariable(value = "id") Long id,
                                                         @Valid @RequestBody UpdateAddressRequest request) {
        AddressResponse response = addressService.updateAddress(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(summary = "Excluir endereço", description = "Excluir um endereço por ID já cadastrado",
            operationId = "deleteAddress", tags = {"Address"}, responses = {
            @ApiResponse(responseCode = "204", description = "Endereço excluído com sucesso", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Requisição inválida", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ValidationErrorResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Endereço não encontrado", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable(value = "id") Long id) {
        addressService.deleteAddress(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(summary = "Obter endereço por ID", description = "Endereço por ID já cadastrado",
            operationId = "getAddressById", tags = {"Address"}, responses = {
            @ApiResponse(responseCode = "200", description = "Endereço encontrado com sucesso", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = AddressResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Requisição inválida", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ValidationErrorResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Endereço não encontrado", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    })
    @GetMapping("/{id}")
    public ResponseEntity<AddressResponse> getAddressById(@PathVariable(value = "id") Long id) {
        AddressResponse response = addressService.findAddressById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(summary = "Listar todos os endereços cadastrados", description = "",
            operationId = "getAllAddresses", tags = {"Address"}, responses = {
            @ApiResponse(responseCode = "200", description = "Lista de endereços encontrada com sucesso", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = AddressResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Requisição inválida", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ValidationErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    })
    @GetMapping
    public ResponseEntity<Page<AddressResponse>> getAllAddresses(Pageable pageable) {
        Page<AddressResponse> responses = addressService.findAllAddresses(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(responses);
    }

    @Operation(summary = "Obter endereço", description = "Obter endereço por UF, Localidade e Logradouro",
            operationId = "getAddressesByRegion", tags = {"Address"}, responses = {
            @ApiResponse(responseCode = "200", description = "Endereço encontrado com sucesso", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ViaCepResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Requisição inválida", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ValidationErrorResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Endereço não encontrado", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
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
            @ApiResponse(responseCode = "200", description = "Endereço encontrado com sucesso", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = AddressResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Requisição inválida", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ValidationErrorResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Endereço não encontrado", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    })
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AddressResponse>> getAddressesByUser(@PathVariable(value = "userId") Long userId) {
        List<AddressResponse> responses = addressService.findAddressesByUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(responses);
    }

}
