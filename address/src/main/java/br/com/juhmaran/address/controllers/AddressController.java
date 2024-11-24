package br.com.juhmaran.address.controllers;

import br.com.juhmaran.address.domain.dtos.request.RegisterAddressRequest;
import br.com.juhmaran.address.domain.dtos.request.UpdateAddressRequest;
import br.com.juhmaran.address.domain.dtos.response.AddressResponse;
import br.com.juhmaran.address.domain.model.ViaCepResponse;
import br.com.juhmaran.address.services.AddressService;
import br.com.juhmaran.address.services.ViaCepService;
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
public class AddressController {

    private final ViaCepService viaCepService;
    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<AddressResponse> createAddress(@Valid @RequestBody RegisterAddressRequest request) {
        AddressResponse response = addressService.registerAddress(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressResponse> updateAddress(@PathVariable(value = "id") Long id,
                                                         @Valid @RequestBody UpdateAddressRequest request) {
        AddressResponse response = addressService.updateAddress(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable(value = "id") Long id) {
        addressService.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressResponse> getAddressById(@PathVariable(value = "id") Long id) {
        AddressResponse response = addressService.findAddressById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<AddressResponse>> getAllAddresses(Pageable pageable) {
        Page<AddressResponse> responses = addressService.findAllAddresses(pageable);
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/region")
    public ResponseEntity<List<ViaCepResponse>> getAddressesByRegion(
            @RequestParam(value = "state_abbreviation") String stateAbbreviation,
            @RequestParam(value = "city") String city,
            @RequestParam(value = "street") String street) {
        List<ViaCepResponse> responses = viaCepService.getAddressesByRegion(stateAbbreviation, city, street);
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AddressResponse>> getAddressesByUser(@PathVariable(value = "userId") Long userId) {
        List<AddressResponse> responses = addressService.findAddressesByUser(userId);
        return ResponseEntity.ok(responses);
    }

}
