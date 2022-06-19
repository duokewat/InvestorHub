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
public class InvestmentRequest {
	private String stockCode;
	private String marketCode;
	private BigDecimal investingAmount;
	private String investingCurrency;
}