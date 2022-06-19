package com.duokewat.towardscloud.investorhub.external.view;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@Component
@ToString
public class PriceResponseView {
	private String stock;
	private String market;
	private long regularMarketPrice;
}