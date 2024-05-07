package com.projectx.analytics.service;

import com.projectx.analytics.model.Transfer;
import com.projectx.analytics.repository.TransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferService {

    private final TransferRepository transferRepository;

    public Transfer initiateNewTransfer(Transfer transfer) {
        return transferRepository.save(transfer);
    }
}
