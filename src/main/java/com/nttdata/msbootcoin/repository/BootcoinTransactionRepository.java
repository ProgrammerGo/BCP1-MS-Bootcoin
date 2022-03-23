package com.nttdata.msbootcoin.repository;

import com.nttdata.msbootcoin.model.BootcoinTransaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BootcoinTransactionRepository extends ReactiveMongoRepository<BootcoinTransaction, String> {
}
