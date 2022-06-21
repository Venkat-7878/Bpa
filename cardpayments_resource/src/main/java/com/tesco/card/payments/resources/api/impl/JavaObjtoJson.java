package com.tesco.card.payments.resources.api.impl;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.tesco.card.payments.resources.beans.CardPaymentsReqBean;
import com.tesco.card.payments.resources.beans.ClientInfo;
import com.tesco.card.payments.resources.beans.CustomerInfo;
import com.tesco.card.payments.resources.beans.EnrollResourceRequest;
import com.tesco.card.payments.resources.beans.ServiceInfo;
import com.tesco.card.payments.resources.beans.VendorInfo;

public class JavaObjtoJson {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		//CardPaymentsReqBean request = new CardPaymentsReqBean();
         EnrollResourceRequest request=new EnrollResourceRequest();
		ClientInfo c = new ClientInfo();
		c.setClientId("er");
		c.setChannelId("online");
		c.setCorrelationId("12345678901234567891234567894562");
		c.setMessageTs("20-06-2019");

		CustomerInfo ci = new CustomerInfo();
		ci.setCardNum("987654321");
		ci.setCvv("456");
		ci.setExpDate("11-11-2050");
		ci.setNameOnCard("Venkatesh");
		
		VendorInfo vi=new VendorInfo();
		vi.setMobileNumber("65897654655");
		vi.setVendorName("O2");
		
		ServiceInfo si=new ServiceInfo();
		si.setApiName("enroll");
		si.setServiceName("billPaymentService");
		si.setVersion("2.0");

		request.setClientInfo(c);
		request.setCustomerInfo(ci);
		request.setServiceInfo(si);
		request.setVendorInfo(vi);

       ObjectMapper mapper = new ObjectMapper();
       String jsonData=mapper.defaultPrettyPrintingWriter().writeValueAsString(request);
       System.out.println("The json data is:"+jsonData);
	}

}
