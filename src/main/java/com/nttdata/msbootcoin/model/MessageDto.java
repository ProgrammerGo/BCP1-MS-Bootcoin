package com.nttdata.msbootcoin.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageDto{

	String message;
	String phoneNumber;
	Double amount;
}
