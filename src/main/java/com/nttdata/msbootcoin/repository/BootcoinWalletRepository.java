package com.nttdata.msbootcoin.repository;


import com.nttdata.msbootcoin.model.BootcoinWallet;
import reactor.core.publisher.Mono;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BootcoinWalletRepository extends ReactiveMongoRepository<BootcoinWallet, String> {
	public Mono<BootcoinWallet> findByPhoneNumber(String phoneNumber);
}
