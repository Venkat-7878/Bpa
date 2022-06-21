
package com.tesco.card.payments.resources.builder;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tesco.card.payments.process.beans.CardPaymentsProcessReqBean;
import com.tesco.card.payments.resources.beans.CardPaymentsReqBean;
import com.tesco.card.payments.resources.beans.ClientInfo;
import com.tesco.card.payments.resources.beans.CustomerInfo;

public class CardPaymentsReqBuilderTest {

	CardPaymentsReqBean request;

	@Before
	public void setUp() throws Exception {
		request=buildResourceRequest();
	}

	@After
	public void tearDown() throws Exception {
		request=null;
	}

	@Test
	public void testBuildProcessRequest() {
		CardPaymentsReqBuilder reqbuilder=new CardPaymentsReqBuilder();
		CardPaymentsProcessReqBean processRequest=reqbuilder.buildProcessRequest(request);
		System.out.println(processRequest);
		Assert.assertNotNull(processRequest);
		Assert.assertEquals("987654321", processRequest.getCardNum());
		Assert.assertEquals("456", processRequest.getCvv());
		Assert.assertEquals("web", processRequest.getClientId());
		Assert.assertEquals("online", processRequest.getChannelId());
		
	}
	private CardPaymentsReqBean buildResourceRequest() {
		CardPaymentsReqBean request = new CardPaymentsReqBean();

		ClientInfo c = new ClientInfo();
		c.setClientId("web");
		c.setChannelId("online");
		c.setCorrelationId("12345678901234567891234567894562");

		CustomerInfo ci = new CustomerInfo();
		ci.setCardNum("987654321");
		ci.setCvv("456");
		ci.setExpDate("11-11-2050");
		ci.setNameOnCard("Venkatesh");

		request.setClientInfo(c);
		request.setCustomerInfo(ci);

		
		return request;
	}
}
