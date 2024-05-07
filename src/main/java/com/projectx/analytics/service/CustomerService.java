package com.projectx.analytics.service;

import com.projectx.analytics.model.Customers;
import com.projectx.analytics.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customers createNewCustomer(Customers customer){

        return customerRepository.save(customer);
    }

    public Customers findCustomerByUsername(String username){
        return customerRepository.findByUsername(username);
    }
    public Customers updateUsername(String username){
        Optional<Customers> optionalCustomer = Optional.ofNullable(customerRepository.findByUsername(username));

        if(!optionalCustomer.isPresent()){
            return null;
        }
        Customers reqCustomer = optionalCustomer.get();
        reqCustomer.setUsername(username);
        return customerRepository.save(reqCustomer);
    }
}
