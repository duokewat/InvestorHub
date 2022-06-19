package com.duokewat.towardscloud.investorhub.external.view;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
@Component
public class ExchangeRequest {
	private String from;
	private String to;
}
