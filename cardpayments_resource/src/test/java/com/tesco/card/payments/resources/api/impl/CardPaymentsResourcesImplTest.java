package com.tesco.card.payments.resources.api.impl;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.tesco.card.payments.process.api.CardPaymentsProcess;
import com.tesco.card.payments.process.api.impl.CardPaymentsProcessImpl;
import com.tesco.card.payments.process.beans.EnrollProcessRequest;
import com.tesco.card.payments.process.beans.EnrollProcessResponse;
import com.tesco.card.payments.resources.beans.ClientInfo;
import com.tesco.card.payments.resources.beans.CustomerInfo;
import com.tesco.card.payments.resources.beans.EnrollResourceRequest;
import com.tesco.card.payments.resources.beans.EnrollResourceResponse;

@RunWith(PowerMockRunner.class)
@PrepareForTest({CardPaymentsResourcesImpl.class,CardPaymentsProcess.class,CardPaymentsProcessImpl.class})
public class CardPaymentsResourcesImplTest {
    
	CardPaymentsResourcesImpl resourceImpl;
	CardPaymentsProcess mockProcess;
	CardPaymentsProcessImpl mockProcessImpl;
	@Before
	public void setUp() throws Exception {
		resourceImpl=new CardPaymentsResourcesImpl();
		mockProcessImpl=PowerMockito.mock(CardPaymentsProcessImpl.class);
		PowerMockito.whenNew(CardPaymentsProcessImpl.class).withNoArguments().thenReturn(mockProcessImpl);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGet_Enrolled() throws IOException, Exception {
		PowerMockito.when(mockProcessImpl.get_Enrolled(Matchers.any(EnrollProcessRequest.class))).thenReturn(buildEnrollProcessResponse());
		EnrollResourceRequest request =buildEnrollResourceRequest();
		EnrollResourceResponse response=resourceImpl.get_Enrolled(request);
		assertNotNull(response);
		assertEquals("0", response.getStatusBlock().getResCode());
		assertEquals("Success", response.getStatusBlock().getResMsg());
		assertEquals("Enrolled Succesfully", response.getStatusBlock().getEnrollStatus());
	}

	private EnrollResourceRequest buildEnrollResourceRequest() {
		EnrollResourceRequest request =new EnrollResourceRequest();
		ClientInfo c = new ClientInfo();
		c.setClientId("web");
		c.setChannelId("online");
		c.setCorrelationId("12345678901234567891234567894562");

		CustomerInfo ci = new CustomerInfo();
		ci.setCardNum("987654321");
		ci.setCvv("456");
		ci.setExpDate("11-11-2050");
		ci.setNameOnCard("Venkatesh");
		ci.setMobileNumber("8522022118");
		ci.setBillDate("05-06-2019");

		request.setClientInfo(c);
		request.setCustomerInfo(ci); 
		
		request.setClientInfo(c);
		request.setCustomerInfo(ci);
		return request;
	}
	
	private EnrollProcessResponse buildEnrollProcessResponse() {
		EnrollProcessResponse processResponse=new EnrollProcessResponse();
		processResponse.setResCode("0");
		processResponse.setResMsg("Success");
		processResponse.setEnrollStatus("Enrolled Succesfully");
		return processResponse;
	}

}
