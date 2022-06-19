package com.duokewat.towardscloud.investorhub.manager;

import java.math.BigDecimal;
import java.math.MathContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.duokewat.towardscloud.investorhub.view.InvestmentRequest;
import com.duokewat.towardscloud.investorhub.view.InvestmentResponse;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class InvestmentManager {

	@Autowired
	CurrencyServiceManager currencyServiceManager;
	@Autowired
	StockServiceManager stockServiceManager;

	@Autowired
	InvestmentResponse investmentResponse;

	public InvestmentResponse getInvestmentDetail(InvestmentRequest investmentRequest) {
		log.debug("Inside Manager()");
		
		investmentResponse.setCurrentMarketPrice(stockServiceManager.getMarketPrice(investmentRequest));
		investmentResponse.setCurrentMarketCurrencyValue(currencyServiceManager.getExchange(investmentRequest));
		calculateNumberOfShares(investmentRequest);
		log.debug(investmentResponse.toString());
		return investmentResponse;
	}

	private void calculateNumberOfShares(InvestmentRequest investmentRequest) {
		log.debug("Inside calculateNumberOfShares()");
		
		BigDecimal currentMarketPrice = investmentResponse.getCurrentMarketPrice();
		BigDecimal currentMarketCurrencyValue = investmentResponse.getCurrentMarketCurrencyValue();
		BigDecimal investingAmount = investmentRequest.getInvestingAmount();
		
		log.debug("investingAmount '{}'",investingAmount);
		log.debug("currentMarketCurrencyValue '{}'",currentMarketCurrencyValue);
		log.debug("currentMarketPrice '{}'",currentMarketPrice);
		
		int numberOfShares = investingAmount.divide(currentMarketCurrencyValue, MathContext.DECIMAL128).divide(currentMarketPrice, MathContext.DECIMAL128).intValue();
		log.debug("numberOfShares '{}'",numberOfShares);
		
		investmentResponse.setNumberOfShares(numberOfShares);
	}
}