package com.nttdata.msbootcoin.service.impl;

import com.nttdata.msbootcoin.model.Bootcoin;
import com.nttdata.msbootcoin.service.BootcoinService;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BootcoinServiceImpl implements BootcoinService {

	private final ReactiveRedisOperations<String, Bootcoin> bootcoinOpps;
	
	@Override
	public Mono<Bootcoin> findCoin() {
		return bootcoinOpps.opsForValue().get("1");
	}

	@Override
	public Mono<Boolean> save(Bootcoin bootcoin) {
		return bootcoinOpps.opsForValue().set("1", bootcoin);
	}


}
