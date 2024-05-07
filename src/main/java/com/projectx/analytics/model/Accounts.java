package com.projectx.analytics.model;

import lombok.*;import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Document(collection = "accounts")
@TypeAlias("Accounts")
public class Accounts {

    @Id
    private String _id;
    @Field("account_id")
    private int accountId;
    private int limit;
    private List<String> products;
}
