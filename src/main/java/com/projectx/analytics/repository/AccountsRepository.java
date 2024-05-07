package com.projectx.analytics.repository;

import com.projectx.analytics.model.Accounts;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public  interface AccountsRepository extends MongoRepository<Accounts, String> {

        Accounts findByAccountId(int account_id);
}
