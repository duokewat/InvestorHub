package com.duokewat.towardscloud.investorhub.view;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
@Component
public class InvestmentResponse {
	private int numberOfShares;
	private BigDecimal currentMarketPrice;
	private BigDecimal currentMarketCurrencyValue;
}
