package com.zufarproject.aws.dynamodb.endpoint;

import com.zufarproject.aws.dynamodb.model.Customer;
import com.zufarproject.aws.dynamodb.repository.CustomerCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CustomerEndpoint {

    private final CustomerCrudRepository customerCrudRepository;

    @PostMapping("/customer")
    public Customer saveCustomer(@RequestBody final Customer customer) {
        return customerCrudRepository.saveCustomer(customer);
    }

    @GetMapping("/customer/{id}")
    @ResponseBody
    public Customer getCustomerById(@PathVariable("id") final String customerId) {
        return customerCrudRepository.getCustomerById(customerId);
    }

    @DeleteMapping("/customer/{id}")
    public String deleteCustomerById(@PathVariable("id") final String customerId) {
        customerCrudRepository.deleteCustomerById(customerId);
        return  "";
    }

    @PutMapping("/customer/{id}")
    public String updateCustomer(@PathVariable("id") final String customerId,
                                 @RequestBody final Customer customer) {
        customerCrudRepository.updateCustomer(customerId,customer);
        return "";
    }
}