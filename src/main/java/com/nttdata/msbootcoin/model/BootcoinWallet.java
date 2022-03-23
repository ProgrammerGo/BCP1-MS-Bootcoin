package com.nttdata.msbootcoin.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("bootcoinWallet")
public class BootcoinWallet {

	@Id
	String id;
	String documentNumber;
    String phoneNumber;
    String phoneIMEI;
    String email;
    Double balance;

}
