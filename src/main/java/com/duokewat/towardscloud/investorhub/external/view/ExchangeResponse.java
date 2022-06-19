package com.duokewat.towardscloud.investorhub.external.view;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@Component
@ToString
public class ExchangeResponse {
	private String from;
	private String to;
	private BigDecimal value;
}
