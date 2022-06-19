package com.duokewat.towardscloud.investorhub.manager;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.duokewat.towardscloud.investorhub.external.view.PriceRequestView;
import com.duokewat.towardscloud.investorhub.external.view.PriceResponseView;
import com.duokewat.towardscloud.investorhub.view.InvestmentRequest;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class StockServiceManager {
	
	@Value("${stock.service.url}")
	private String stockServiceUrl;
	
	@Autowired
	PriceRequestView priceRequestView;
	public BigDecimal getMarketPrice(InvestmentRequest investmentRequest) {
		log.debug("Inside getMarketPrice()");
		log.debug("stockServiceUrl '{}'",stockServiceUrl);
		
		RestTemplate restTemplate = new RestTemplate();
		
		priceRequestView.setStock(investmentRequest.getStockCode());
		priceRequestView.setMarket(investmentRequest.getMarketCode());
		
		HttpEntity<PriceRequestView> request = new HttpEntity<>(priceRequestView);
		PriceResponseView response = restTemplate.postForObject(stockServiceUrl, request, PriceResponseView.class);
		log.debug(response.toString());
		
		return response.getRegularMarketPrice();
	}
}