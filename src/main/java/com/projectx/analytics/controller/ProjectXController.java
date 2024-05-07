package com.projectx.analytics.controller;

import com.projectx.analytics.model.Accounts;
import com.projectx.analytics.model.Customers;
import com.projectx.analytics.service.AccountService;
import com.projectx.analytics.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1/projectx")
@Slf4j
public class ProjectXController {
    @Autowired
    CustomerService customerService;

    @Autowired
    AccountService accountService;


    @PostMapping("/createCustomer")
    public ResponseEntity<String> createNewCustomer(@RequestHeader("Content-Type") String contentType,
                                                    @RequestHeader("Accept-Encoding") String encoding,
                                                    @RequestHeader("Authorization") String authToken,
                                                    @RequestBody Customers customer) {
        if (customerService.createNewCustomer(customer) != null) {
            log.info("New customer created "+customer.toString());
            return new ResponseEntity<>("Customer added succesfully", HttpStatus.CREATED);
        } else {
            log.error("could not create new customer");
            return new ResponseEntity<>("Customer could not be added", HttpStatus.CONFLICT);
        }

    }
    @GetMapping("/username/{username}")
    public ResponseEntity<Customers> getCustomers(@RequestHeader("Content-Type") String contentType,
                                                        @RequestHeader("Accept-Encoding") String encoding,
                                                        @RequestHeader("Authorization") String authToken,
                                                        @PathVariable("username") String username) {
        Customers customer=customerService.findCustomerByUsername(username);
        if(customer==null) {
            log.error("could not find customer with username "+username);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            log.info("Found customer "+customer.toString());
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
    }
    @PatchMapping("/username/{username}")
    public ResponseEntity<Customers> updateCustomerUserName(@RequestHeader("Content-Type") String contentType,
                                                            @RequestHeader("Accept-Encoding") String encoding,
                                                            @RequestHeader("Authorization") String authToken,
                                                            @PathVariable("username") String username){
        Customers customer=customerService.updateUsername(username);
        if(customer!=null){
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }else{
            log.error("could not find customer with username "+username);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
