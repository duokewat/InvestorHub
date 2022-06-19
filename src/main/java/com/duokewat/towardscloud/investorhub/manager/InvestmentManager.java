package com.duokewat.towardscloud.investorhub.manager;

import java.math.BigDecimal;
import java.math.MathContext;

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
		BigDecimal currentMarketPrice = investmentResponse.getCurrentMarketPrice();
		BigDecimal currentMarketCurrencyValue = investmentResponse.getCurrentMarketCurrencyValue();
		BigDecimal investingAmount = investmentRequest.getInvestingAmount();
		
		System.out.println(investingAmount);
		System.out.println(currentMarketCurrencyValue);
		System.out.println(currentMarketPrice);
		
		int numberOfShares = investingAmount.divide(currentMarketCurrencyValue, MathContext.DECIMAL128).divide(currentMarketPrice, MathContext.DECIMAL128).intValue();
		System.out.println(numberOfShares);
		investmentResponse.setNumberOfShares(numberOfShares);
	}
}