package com.tesco.card.creditscore.client;

import com.tesco.card.creditscore.client.beans.CreditCheckServiceRequest;
import com.tesco.card.creditscore.client.beans.CreditCheckServiceResponse;

public interface CreditCheckServiceClient {
	
public CreditCheckServiceResponse getCreditScore(CreditCheckServiceRequest request);
}
