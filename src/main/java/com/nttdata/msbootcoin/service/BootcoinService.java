package com.nttdata.msbootcoin.service;


import com.nttdata.msbootcoin.model.Bootcoin;
import reactor.core.publisher.Mono;

public interface BootcoinService {

	public Mono<Bootcoin> findCoin();
	public Mono<Boolean> save(Bootcoin bootcoin);
	
}
