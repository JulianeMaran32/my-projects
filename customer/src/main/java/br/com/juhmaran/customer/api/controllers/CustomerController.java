package br.com.juhmaran.customer.api.controllers;

import br.com.juhmaran.customer.api.domain.dtos.CustomerRequest;
import br.com.juhmaran.customer.api.domain.dtos.CustomerResponse;
import br.com.juhmaran.customer.api.services.CustomerService;
import br.com.juhmaran.customer.core.exceptions.dtos.ValidationErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "Customer", description = "Endpoints para gerenciamento de clientes")
public class CustomerController {

    private final CustomerService customerService;

    @Operation(summary = "Cadastrar um novo cliente.", description = "Cadastrar um novo cliente.",
            operationId = "registerCustomer", tags = {"Customer"}, responses = {
            @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Requisição inválida.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ValidationErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    })
    @PostMapping
    public ResponseEntity<CustomerResponse> registerCustomer(@RequestBody @Valid CustomerRequest customerRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.registerCustomer(customerRequest));
    }

    @Operation(summary = "Obter Cliente por ID.", description = "Buscar um cliente já cadastrado por ID.",
            operationId = "getCustomer", tags = {"Customer"}, responses = {
            @ApiResponse(responseCode = "200", description = "Cliente retornado com sucesso.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Requisição inválida.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ValidationErrorResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    })
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable(name = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getCustomerById(id));
    }

    @Operation(summary = "Atualizar cliente.", description = "Atualizar um cliente já cadastrado pelo ID.",
            operationId = "updateCustomer", tags = {"Customer"}, responses = {
            @ApiResponse(responseCode = "200", description = "Cliente retornado com sucesso.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Requisição inválida.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ValidationErrorResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    })
    @PatchMapping("/{id}")
    public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable(name = "id") Long id,
                                                           @RequestBody @Valid CustomerRequest customerRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.updateCustomer(id, customerRequest));
    }

    @Operation(summary = "Excluir cliente", description = "Excluir um cliente já cadastrado pelo ID.",
            operationId = "deleteCustomer", tags = {"Customer"}, responses = {
            @ApiResponse(responseCode = "204", description = "Cliente excluído com sucesso.", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Requisição inválida.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ValidationErrorResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable(name = "id") Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(summary = "Listar clientes", description = "Listar todos os clientes cadastrados ou filtrar por parâmetros.",
            operationId = "listCustomers", tags = {"Customer"}, responses = {
            @ApiResponse(responseCode = "200", description = "Lista de clientes retornada com sucesso.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Requisição inválida.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ValidationErrorResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    })
    @GetMapping
    public ResponseEntity<Page<CustomerResponse>> listCustomers(
            @RequestParam(required = false, name = "full_name") String fullName,
            @RequestParam(required = false, name = "email") String email,
            @RequestParam(required = false, name = "phone_number") String phoneNumber,
            @RequestParam(required = false, name = "document_number") String documentNumber,
            @RequestParam(required = false) Boolean active,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<CustomerResponse> customers = customerService
                .listCustomers(fullName, email, phoneNumber, documentNumber, active, sortBy, sortDirection, page, size);
        return ResponseEntity.status(HttpStatus.OK).body(customers);
    }

}
