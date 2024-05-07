package com.projectx.analytics.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Setter
@Getter
@ToString
@Document(collection = "customers")
@TypeAlias("Customers")
public class Customers {
    private String username;
    private String name;
    private String address;
    private long birthdate;
    private String email;
    private List<Integer> accounts;
    private Map<String, TierDetails> tier_and_details;

}
