package com.tesco.card.creditscore.client.impl;

import org.springframework.stereotype.Component;

import com.tesco.card.creditscore.client.CreditCheckServiceClient;
import com.tesco.card.creditscore.client.beans.CreditCheckServiceRequest;
import com.tesco.card.creditscore.client.beans.CreditCheckServiceResponse;
@Component
public class CreditCheckServiceClientImpl implements CreditCheckServiceClient {

	public CreditCheckServiceResponse getCreditScore(CreditCheckServiceRequest request) {
		// prepare the request for Credit Check Service
		// call the service and get the response
		CreditCheckServiceResponse response = new CreditCheckServiceResponse();
		Float scorePercent=70f;
		response.setScorePercent(scorePercent);
		if(response!=null && response.getScorePercent()>=65){
		response.setRespCode("0");
		response.setRespMsg("success");
		}else{
			response.setRespCode("300");
			response.setRespMsg("Score Percent is not upto mark");	
		}

		return response;
	}

}
