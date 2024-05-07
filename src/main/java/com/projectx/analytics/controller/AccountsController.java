package com.projectx.analytics.controller;

import com.projectx.analytics.model.Accounts;
import com.projectx.analytics.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projectx")
@Slf4j
@RequiredArgsConstructor
public class AccountsController {

    private final AccountService accountService;

    @GetMapping("/account_Id/{account_Id}")
    public ResponseEntity<Accounts> getAccountDetails(@RequestHeader("Content-Type") String contentType,
                                                      @RequestHeader("Accept-Encoding") String encoding,
                                                      @RequestHeader("Authorization") String authToken,
                                                      @PathVariable("account_Id") int account_id) {
        Accounts account=accountService.getAccountsByAccountId(account_id);
        if(account==null) {
             log.error("could not find account with id {}", account_id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            // log.info("Found account {}", account.toString());
            return new ResponseEntity<>(account, HttpStatus.OK);
        }
    }



}
