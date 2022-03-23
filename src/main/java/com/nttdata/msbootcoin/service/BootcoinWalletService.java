package com.nttdata.msbootcoin.service;


import com.nttdata.msbootcoin.model.BootcoinWallet;
import com.nttdata.msbootcoin.model.MessageDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BootcoinWalletService {

	public Flux<BootcoinWallet> findAll();
	public Mono<BootcoinWallet> findById(String id);
	public Mono<BootcoinWallet> findByPhoneNumber(String phoneNumber);
	public Mono<BootcoinWallet> save(BootcoinWallet wallet);
	public void deleteById(String id);
	
	public void bootcoinBuyRequest(MessageDto message);
	public void bootcoinAcceptBuyRequest(MessageDto message);
}
