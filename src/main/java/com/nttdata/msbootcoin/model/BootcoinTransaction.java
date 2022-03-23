package com.nttdata.msbootcoin.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("bootcoinTransaction")
public class BootcoinTransaction {

	@Id
	String id;
	String status;
	String from;
	String to;
	Double amount;
}
