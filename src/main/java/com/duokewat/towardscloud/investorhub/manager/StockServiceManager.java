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

@Component
public class StockServiceManager {
	
	@Value("${stock.service.url}")
	private String stockServiceUrl;
	
	@Autowired
	PriceRequestView priceRequestView;
	public BigDecimal getMarketPrice(InvestmentRequest investmentRequest) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		priceRequestView.setStock(investmentRequest.getStockCode());
		priceRequestView.setMarket(investmentRequest.getMarketCode());
		
		HttpEntity<PriceRequestView> request = new HttpEntity<>(priceRequestView);
		PriceResponseView response = restTemplate.postForObject(stockServiceUrl, request, PriceResponseView.class);
		System.out.println(response);
		return response.getRegularMarketPrice();
	}
}