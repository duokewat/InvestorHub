package com.duokewat.towardscloud.investorhub.view;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
@Component
public class InvestmentRequest {
	private String stockCode;
	private String marketCode;
	private int investingAmount;
	private String investingCurrency;
}