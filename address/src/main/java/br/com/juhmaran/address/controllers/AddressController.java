package br.com.juhmaran.address.controllers;

import br.com.juhmaran.address.domain.dtos.request.AddressRequest;
import br.com.juhmaran.address.domain.dtos.response.AddressResponse;
import br.com.juhmaran.address.services.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {

    // @RequestHeader(name = "Authorization", required = false) String token,
    // @RequestHeader(name = "Accept-Language", required = false) Locale locale

    private final AddressService addressService;

    @GetMapping
    public ResponseEntity<List<AddressResponse>> getAddress() {
        List<AddressResponse> addresses = addressService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(addresses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressResponse> getAddressById(@PathVariable(name = "id") Long id) {
        AddressResponse address = addressService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(address);
    }

    @PostMapping
    public ResponseEntity<AddressResponse> createAddress(@RequestBody @Valid AddressRequest addressRequest) {
        AddressResponse createdAddress = addressService.create(addressRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAddress);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressResponse> updateAddress(@PathVariable(name = "id") Long id,
                                                         @RequestBody @Valid AddressRequest addressRequest) {
        AddressResponse updatedAddress = addressService.update(id, addressRequest);
        return ResponseEntity.status(HttpStatus.OK).body(updatedAddress);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable(name = "id") Long id) {
        addressService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/cep/{cep}")
    public ResponseEntity<AddressResponse> getAddressByCep(@PathVariable(name = "cep") String cep) {
        AddressResponse address = addressService.findByCep(cep);
        return ResponseEntity.status(HttpStatus.OK).body(address);
    }

    @GetMapping("/cep/save/{cep}")
    public ResponseEntity<AddressResponse> getAddressByCepAndSave(@PathVariable(name = "cep") String cep) {
        AddressResponse address = addressService.findByCepAndSave(cep);
        return ResponseEntity.status(HttpStatus.OK).body(address);
    }

}
