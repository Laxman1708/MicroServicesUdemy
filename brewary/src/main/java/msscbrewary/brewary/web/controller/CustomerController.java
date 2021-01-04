package msscbrewary.brewary.web.controller;

import msscbrewary.brewary.services.CustomerService;
import msscbrewary.brewary.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{custId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("custId") UUID custId) {
        return new ResponseEntity<>(customerService.getCustomerById(custId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto customerDto1 = customerService.saveCustomer(customerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/"+customerDto.getId().toString());
        return  new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{custId}")
    public ResponseEntity updateCustomer(@PathVariable("custId") UUID custId, @RequestBody CustomerDto customerDto){
        customerService.updateCustomer(custId, customerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{custId}")
    public ResponseEntity deleteCustomer(@PathVariable("custId") UUID custId){
        customerService.deleteCusomer(custId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
