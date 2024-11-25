package br.com.juhmaran.customer.api.controllers;

import br.com.juhmaran.customer.api.services.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "Customer", description = "Customer API")
public class CustomerController {

    private final CustomerService customerService;

}
