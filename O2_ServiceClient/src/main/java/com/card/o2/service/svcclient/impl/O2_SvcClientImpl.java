package com.card.o2.service.svcclient.impl;

import org.springframework.stereotype.Component;

import com.card.o2.service.svcclient.O2_SvcClientApi;
import com.card.o2.service.svcclient.beans.O2SvcClientRequest;
import com.card.o2.service.svcclient.beans.O2SvcClientResponse;
@Component
public class O2_SvcClientImpl implements O2_SvcClientApi {
	public O2SvcClientResponse verify(O2SvcClientRequest request){
		O2SvcClientResponse response =new O2SvcClientResponse();
		response.setBackNumber("998884500");
		response.setBillDate("21-06-2019");
		response.setBillPaymentDate("24-06-2019");
		response.setMobileNumber("7893219190");
		response.setSortCode("ts00789");
		response.setfName("venkatesh");
		response.setlName("itkal");
		return response;
		
	}
}
