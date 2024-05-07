package com.projectx.analytics.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Setter
@Getter
@ToString
@Document(collection = "transactions")
@TypeAlias("Transaction")
public class Transaction {
    private int accountId;
    private int transactionCount;
    private Date bucketStartDate;
    private Date bucketEndDate;
    private List<Transactions> transactions;
}
