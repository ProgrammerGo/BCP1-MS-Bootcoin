package com.nttdata.msbootcoin.service.impl;

import com.nttdata.msbootcoin.model.BootcoinTransaction;
import com.nttdata.msbootcoin.model.BootcoinWallet;
import com.nttdata.msbootcoin.model.MessageDto;
import com.nttdata.msbootcoin.repository.BootcoinTransactionRepository;
import com.nttdata.msbootcoin.repository.BootcoinWalletRepository;
import com.nttdata.msbootcoin.service.BootcoinWalletService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BootcoinWalletServiceImpl implements BootcoinWalletService {
	
	private final BootcoinWalletRepository walletRepo;
	private final BootcoinTransactionRepository transactionRepo;
	private final KafkaTemplate<String, MessageDto> kafkaTemplate;
	
	@Override
	public Flux<BootcoinWallet> findAll() {
		return walletRepo.findAll();
	}

	@Override
	public Mono<BootcoinWallet> findById(String id) {
		return walletRepo.findById(id);
	}

	@Override
	public Mono<BootcoinWallet> findByPhoneNumber(String phoneNumber) {
		return walletRepo.findByPhoneNumber(phoneNumber);
	}

	@Override
	public Mono<BootcoinWallet> save(BootcoinWallet wallet) {
		return walletRepo.save(wallet);
	}

	@Override
	public void deleteById(String id) {
		walletRepo.deleteById(id).subscribe();
	}

	@Override
	public void bootcoinBuyRequest(MessageDto message) {
		kafkaTemplate.send("bootcoinBuyRequest", message);
	}

	@Override
	@KafkaListener(topics="bootcoinBuyRequest", groupId="groupId")
	public void bootcoinAcceptBuyRequest(MessageDto message) {
		//El numero hardcodeado representa un usuario que acepto el buy request ya que no hay un UI para que reciba la notificacion y le de aceptar al request
		
		generateTransaction(message.getPhoneNumber(), "94351684", message.getAmount()).doOnNext(System.out::println);
	}
	
	//UTIL METHODS
	public Mono<BootcoinTransaction> generateTransaction(String from, String to, Double amount) {
		
		return transactionRepo.save(BootcoinTransaction.builder().status("pending").from(from).to(to).amount(amount).build());
	}
	
	public void validTransaction(BootcoinTransaction transaction) {
		
	}
	
	public void validWallet(BootcoinTransaction transaction) {
		
	}

}
