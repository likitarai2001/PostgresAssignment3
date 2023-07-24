package com.example.onlineShopping.controller;

import com.example.onlineShopping.dto.CustomerDto;
import com.example.onlineShopping.response.GenericResponse;
import com.example.onlineShopping.service.CustomerAddressViewService;
import com.example.onlineShopping.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerAddressViewService customerAddressViewService;

    @Autowired
    public CustomerController(CustomerService customerService, CustomerAddressViewService customerAddressViewService) {
        this.customerService = customerService;
        this.customerAddressViewService = customerAddressViewService;
    }

    @GetMapping("/")
    public ResponseEntity<GenericResponse> getAllCustomers(){
        GenericResponse genericResponse = new GenericResponse(true, "Customer loaded successfully", customerService.getAllCustomers(), HttpStatus.OK.value());
        return new ResponseEntity<>(genericResponse, HttpStatus.OK);
    }

    @GetMapping("/view")
    public ResponseEntity<GenericResponse> getAllCustomersWithGivenAddress(@RequestParam("address") String address){
        GenericResponse genericResponse = new GenericResponse(true, "Customer view loaded successfully", customerAddressViewService.getAllCustomersWithGivenAddress(address), HttpStatus.OK.value());
        return new ResponseEntity<>(genericResponse, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<GenericResponse> saveCustomer(@RequestBody @Valid CustomerDto customerDto){
        GenericResponse genericResponse = new GenericResponse(true, "Customer saved successfully", customerService.saveCustomer(customerDto), HttpStatus.OK.value());
        return new ResponseEntity<>(genericResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<GenericResponse> deleteCustomer(@PathVariable int customerId){
        customerService.deleteCustomer(customerId);
        GenericResponse genericResponse = new GenericResponse(true, "Customer deleted successfully", null, HttpStatus.OK.value());
        return new ResponseEntity<>(genericResponse, HttpStatus.OK);
    }
}
