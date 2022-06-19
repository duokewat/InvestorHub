package com.duokewat.towardscloud.investorhub.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.duokewat.towardscloud.investorhub.external.view.PriceRequestView;
import com.duokewat.towardscloud.investorhub.external.view.PriceResponseView;
import com.duokewat.towardscloud.investorhub.view.InvestmentRequest;

@Component
public class StockServiceManager {
	
	@Autowired
	PriceRequestView priceRequestView;
	public long getMarketPrice(InvestmentRequest investmentRequest) {
		
		RestTemplate restTemplate = new RestTemplate();
		String requestUrl = "http://localhost:9081/market/price";
		
		priceRequestView.setStock(investmentRequest.getStockCode());
		priceRequestView.setMarket(investmentRequest.getMarketCode());
		
		HttpEntity<PriceRequestView> request = new HttpEntity<>(priceRequestView);
		PriceResponseView response = restTemplate.postForObject(requestUrl, request, PriceResponseView.class);
		System.out.println(response);
		return response.getRegularMarketPrice();
	}
}