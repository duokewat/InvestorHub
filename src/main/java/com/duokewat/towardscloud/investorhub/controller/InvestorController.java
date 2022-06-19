package com.duokewat.towardscloud.investorhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duokewat.towardscloud.investorhub.manager.InvestmentManager;
import com.duokewat.towardscloud.investorhub.view.InvestmentRequest;
import com.duokewat.towardscloud.investorhub.view.InvestmentResponse;

@RestController
@RequestMapping("/investment")
public class InvestorController {
	
	@Autowired
	InvestmentManager investmentManager;
	
	@PostMapping("/detail")
	public InvestmentResponse getInvestmentDetail(@RequestBody InvestmentRequest InvestmentRequest) {
		return investmentManager.getInvestmentDetail(InvestmentRequest);
	}
}