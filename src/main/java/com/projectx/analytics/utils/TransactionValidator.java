package com.projectx.analytics.utils;

import com.projectx.analytics.model.Accounts;
import com.projectx.analytics.model.Transfer;
import com.projectx.analytics.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class TransactionValidator {

    private  final AccountService accountService;

    public  boolean isValidTransaction(Transfer transfer) {
        if(transfer !=null) {
            log.info("Transaction is valid");
            Accounts accounts=accountService.getAccountsByAccountId(transfer.getAccount_id());
            if(accounts!=null){
                log.info("account_id is valid {}", accounts.getAccountId());
                return true;
            }
        }
        return false;
    }
}
