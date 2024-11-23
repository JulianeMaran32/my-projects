package br.com.juhmaran.address.controllers;

import br.com.juhmaran.address.domain.dtos.request.RegisterAddressRequest;
import br.com.juhmaran.address.domain.dtos.request.UpdateAddressRequest;
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
        List<AddressResponse> addresses = addressService.findAllAddresses();
        return ResponseEntity.status(HttpStatus.OK).body(addresses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressResponse> getAddressById(@PathVariable(name = "id") Long id) {
        AddressResponse address = addressService.findAddressById(id);
        return ResponseEntity.status(HttpStatus.OK).body(address);
    }

    @PostMapping
    public ResponseEntity<AddressResponse> createAddress(@RequestBody @Valid RegisterAddressRequest registerAddressRequest) {
        AddressResponse createdAddress = addressService.registerAddress(registerAddressRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAddress);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressResponse> updateAddress(@PathVariable(name = "id") Long id,
                                                         @RequestBody @Valid UpdateAddressRequest updateAddressRequest) {
        AddressResponse updatedAddress = addressService.updateAddress(id, updateAddressRequest);
        return ResponseEntity.status(HttpStatus.OK).body(updatedAddress);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable(name = "id") Long id) {
        addressService.deleteAddress(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/search")
    public ResponseEntity<AddressResponse> searchAddressByZipCode(@RequestParam String cep) {
        AddressResponse addressResponse = addressService.searchAddressByZipCode(cep);
        return ResponseEntity.ok(addressResponse);
    }

    @PostMapping("/save")
    public ResponseEntity<AddressResponse> saveAddress(@RequestBody @Valid UpdateAddressRequest updateAddressRequest) {
        AddressResponse addressResponse = addressService.saveAddress(updateAddressRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(addressResponse);
    }

}
