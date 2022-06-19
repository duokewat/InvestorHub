package com.duokewat.towardscloud.investorhub.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.duokewat.towardscloud.investorhub.view.InvestmentRequest;
import com.duokewat.towardscloud.investorhub.view.InvestmentResponse;

@Component
public class InvestmentManager {
	
	@Autowired
	CurrencyServiceManager currencyServiceManager;
	@Autowired
	StockServiceManager stockServiceManager;
	
	@Autowired
	InvestmentResponse investmentResponse;
	
	public InvestmentResponse getInvestmentDetail(InvestmentRequest investmentRequest) {
		investmentResponse.setCurrentMarketPrice(stockServiceManager.getMarketPrice(investmentRequest));
		investmentResponse.setCurrentMarketCurrencyValue(currencyServiceManager.getExchange(investmentRequest));
		calculateNumberOfShares(investmentRequest);
		return investmentResponse;
	}
	
	private void calculateNumberOfShares(InvestmentRequest investmentRequest) {
		long currentMarketPrice = investmentResponse.getCurrentMarketPrice();
		String currentMarketCurrencyValue = investmentResponse.getCurrentMarketCurrencyValue();
		int investingAmount = investmentRequest.getInvestingAmount();
		
		int numberOfShares = (int) ((investingAmount/ Float.parseFloat(currentMarketCurrencyValue)) / currentMarketPrice) ;
		
		System.out.println(numberOfShares);
		investmentResponse.setNumberOfShares(numberOfShares);
	}
}
