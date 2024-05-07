package com.projectx.analytics.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class Transactions {
    private Date date;
    private int amount;
    private String transaction_code;
    private String symbol;
    private String price;
    private String total;

}
