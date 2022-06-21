package com.tesco.card.payments.process.beans;

import com.card.o2.service.svcclient.beans.O2SvcClientResponse;

public class EnrollO2_ServiceClientRequest {
	private O2SvcClientResponse o2SvcClientResp;

	public O2SvcClientResponse getO2SvcClientResp() {
		return o2SvcClientResp;
	}

	public void setO2SvcClientResp(O2SvcClientResponse o2SvcClientResp) {
		this.o2SvcClientResp = o2SvcClientResp;
	}

	@Override
	public String toString() {
		return "EnrollO2_ServiceClientRequest [o2SvcClientResp=" + o2SvcClientResp + "]";
	}
	
}
