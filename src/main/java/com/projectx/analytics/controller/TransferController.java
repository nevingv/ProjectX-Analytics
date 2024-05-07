package com.projectx.analytics.controller;

import com.projectx.analytics.model.Transfer;
import com.projectx.analytics.service.TransferService;
import com.projectx.analytics.exceptions.InvalidAccountIdException;
import com.projectx.analytics.utils.TransactionValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/projectx")
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;
    private final TransactionValidator transactionValidator;

    @PostMapping("/newtransfer")
    public ResponseEntity<Transfer> initiateNewTransfer(@RequestHeader("Content-Type") String contentType,
                                                        @RequestHeader("Accept-Encoding") String encoding,
                                                        @RequestHeader("Authorization") String authToken,
                                                        @RequestBody Transfer transfer) {

        boolean flag= transactionValidator.isValidTransaction(transfer);
        if(!flag){
            throw new InvalidAccountIdException("Invalid account id: "+transfer.getAccount_id());
        }
        Transfer newTransfer= transferService.initiateNewTransfer(transfer);
        if(newTransfer!=null){
            return new ResponseEntity<>(newTransfer, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


}
