package com.tesco.card.payments.resources.builder;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tesco.card.payments.process.beans.CardPaymentsProcessResBean;
import com.tesco.card.payments.resources.beans.CardPaymentsResBean;



public class CardPaymentsResBuilderTest {

	CardPaymentsResBuilder resBuilder;
	
	@Before
	public void setUp() throws Exception {
		resBuilder=new CardPaymentsResBuilder();
	}

	@After
	public void tearDown() throws Exception {
		resBuilder=null;
	}

	@Test
	public void testBuildResourceResponse() {
		CardPaymentsProcessResBean processResponse =new CardPaymentsProcessResBean();
		processResponse.setAmount("10000");
		processResponse.setDate("07-5-2019");
		processResponse.setDesc("The Payment is done on time");
		processResponse.setPaymentStatus("Success");
		processResponse.setResCode("0");
		processResponse.setResMsg("success");
		CardPaymentsResBean response=resBuilder.buildResourceResponse(processResponse);
		Assert.assertNotNull(response);
		Assert.assertEquals("0",response.getStatusBlock().getResCode());
		Assert.assertEquals("10000",response.getPaymentStatus().getAmount());
		Assert.assertEquals("07-5-2019",response.getPaymentStatus().getDate());
		Assert.assertEquals("The Payment is done on time",response.getPaymentStatus().getDesc());
	}
	
	@Test
	public void testBuildResourceResponse_ErrorResponse() {
		CardPaymentsProcessResBean processResponse =new CardPaymentsProcessResBean();
		processResponse.setResCode("100");
		processResponse.setResMsg("Buisness Exception");
		CardPaymentsResBean response=resBuilder.buildResourceResponse(processResponse);
		Assert.assertNotNull(response);
		Assert.assertEquals("100",response.getStatusBlock().getResCode());
		
		
	}


}
