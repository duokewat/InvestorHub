package com.duokewat.towardscloud.investorhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duokewat.towardscloud.investorhub.manager.InvestmentManager;
import com.duokewat.towardscloud.investorhub.view.InvestmentRequest;
import com.duokewat.towardscloud.investorhub.view.InvestmentResponse;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1/investment")
@Slf4j
public class InvestorController {
	
	@Autowired
	InvestmentManager investmentManager;
	
	@PostMapping("/detail")
	public InvestmentResponse getInvestmentDetail(@RequestBody InvestmentRequest investmentRequest) {
		log.debug("Inside getInvestmentDetail()");
		log.debug(investmentRequest.toString());
		return investmentManager.getInvestmentDetail(investmentRequest);
	}
	
	@RequestMapping("/ruok")
    public String ruok() {
        return "Yes, I am Okay !";
    }  
}