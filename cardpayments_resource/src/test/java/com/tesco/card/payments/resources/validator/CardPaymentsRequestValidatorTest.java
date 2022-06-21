package com.tesco.card.payments.resources.validator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tesco.card.payments.resources.beans.CardPaymentsReqBean;
import com.tesco.card.payments.resources.beans.ClientInfo;
import com.tesco.card.payments.resources.beans.CustomerInfo;
import com.tesco.card.payments.resources.exception.RequestInvalidException;

public class CardPaymentsRequestValidatorTest {
     
	CardPaymentsRequestValidator validator ;
	CardPaymentsReqBean request;
	@Before
	public void setUp() throws Exception {
		validator=new CardPaymentsRequestValidator();
		request=buildResourceRequest();
		}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testValidateRequest_Null_Scenario() {
		try {
			validator.validateRequest(null);
		} catch (RequestInvalidException re) {
			Assert.assertEquals("bpa001", re.getResCode());
		}
	}
	
	@Test
	public void testClientInfo_reqObj_Null_Scenario() {
		try {
			request.setClientInfo(null);
			validator.validateRequest(null);
		} catch (RequestInvalidException re) {
			Assert.assertEquals("bpa001", re.getResCode());
		}
	}
	
	@Test
	public void testCustomerInfo_reqObj_Null_Scenario() {
		try {
			request.setCustomerInfo(null);
			validator.validateRequest(null);
		} catch (RequestInvalidException re) {
			Assert.assertEquals("bpa001", re.getResCode());
		}
	}
	@Test
	public void testClientIdInvalid_Scenario() {
		try {
			request.getClientInfo().setClientId(null);
			validator.validateRequest(request);
		} catch (RequestInvalidException re) {
			Assert.assertEquals("bpa002", re.getResCode());
		}
	}
	@Test
	public void testClientId_Empty_Scenario() {
		try {
			request.getClientInfo().setClientId(" ");
			validator.validateRequest(request);
		} catch (RequestInvalidException re) {
			Assert.assertEquals("bpa002", re.getResCode());
		}
	}
	@Test
	public void testChannelIdInvalid_Scenario() {
		try {
			request.getClientInfo().setChannelId(null);
			validator.validateRequest(request);
		} catch (RequestInvalidException re) {
			Assert.assertEquals("bpa003", re.getResCode());
		}
	}
	@Test
	public void testChannelId_Empty_Scenario() {
		try {
			request.getClientInfo().setChannelId(" ");
			validator.validateRequest(request);
		} catch (RequestInvalidException re) {
			Assert.assertEquals("bpa003", re.getResCode());
		}
	}
	@Test
	public void testCorrelationIdInvalid_Scenario() {
		try {
			request.getClientInfo().setCorrelationId(null);
			validator.validateRequest(request);
		} catch (RequestInvalidException re) {
			Assert.assertEquals("bpa004", re.getResCode());
		}
	}
	@Test
	public void testCorrelationId_Empty_Scenario() {
		try {
			request.getClientInfo().setCorrelationId(null);
			validator.validateRequest(request);
		} catch (RequestInvalidException re) {
			Assert.assertEquals("bpa004", re.getResCode());
		}
	}
	
	private CardPaymentsReqBean buildResourceRequest() {
		CardPaymentsReqBean request = new CardPaymentsReqBean();

		ClientInfo c = new ClientInfo();
		c.setClientId("er");
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
