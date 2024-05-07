package com.projectx.analytics.service;

import com.projectx.analytics.model.Accounts;
import com.projectx.analytics.repository.AccountsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AccountService {

    private final AccountsRepository accountsRepository;



    public Accounts getAccountsByAccountId(int account_id){
        return accountsRepository.findByAccountId(account_id);


    }
}
