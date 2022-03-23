package com.nttdata.msbootcoin.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bootcoin {

	Double priceConversionBuy;
	Double priceConversionSell;
}
