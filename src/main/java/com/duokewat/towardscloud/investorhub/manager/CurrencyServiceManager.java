package com.duokewat.towardscloud.investorhub.manager;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.duokewat.towardscloud.investorhub.external.view.ExchangeRequest;
import com.duokewat.towardscloud.investorhub.external.view.ExchangeResponse;
import com.duokewat.towardscloud.investorhub.view.InvestmentRequest;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CurrencyServiceManager {
	
	@Autowired
	ExchangeRequest exchangeRequest;
	
	@Value("${currency.service.url}")
	private String currencyServiceUrl;
	
	public BigDecimal getExchange(InvestmentRequest investmentRequest) {
		log.debug("Inside getExchange()");
		log.debug("currencyServiceUrl '{}'",currencyServiceUrl);
		
		RestTemplate restTemplate = new RestTemplate();
		
		exchangeRequest.setTo(investmentRequest.getInvestingCurrency());
		exchangeRequest.setFrom("USD");
		
		HttpEntity<ExchangeRequest> request = new HttpEntity<>(exchangeRequest);
		ExchangeResponse response = restTemplate.postForObject(currencyServiceUrl, request, ExchangeResponse.class);
		log.debug(response.toString());
		return response.getValue();
	}
}
