/**@CopyRight 2019 tesco ,All Rights are reserved .
 * We should not disclose the information outside ,
   otherwise terms and conditions will apply.
 */
package com.tesco.card.payments.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.tesco.card.payments.controller.beans.ClientInfo;
import com.tesco.card.payments.controller.beans.CustomerInfo;
import com.tesco.card.payments.controller.beans.EnrollResourceRequest;
import com.tesco.card.payments.controller.beans.EnrollResourceResponse;
import com.tesco.card.payments.controller.beans.VendorInfo;
import com.tesco.card.payments.controller.builder.CardPaymentsReqBuilder;
import com.tesco.card.payments.controller.builder.CardPaymentsResBuilder;
import com.tesco.card.payments.controller.validator.CardPaymentsRequestValidator;
import com.tesco.card.payments.process.api.CardPaymentsProcess;
import com.tesco.card.payments.process.api.impl.CardPaymentsProcessImpl;
import com.tesco.card.payments.process.beans.EnrollProcessRequest;
import com.tesco.card.payments.process.beans.EnrollProcessResponse;

/**
 * @author : Venkatesh
 * @Date :Apr 30, 2019
 * @Description:
 * 
 */
@RestController
@RequestMapping("/card")
public class CardPaymentsController {

	private Logger logger = Logger.getLogger(CardPaymentsController.class);

	// TODO:To enroll the User
	@RequestMapping(value = "/getEnroll", method = RequestMethod.GET, produces = "Application/json")
	@ResponseBody
	public EnrollResourceResponse get_Enrolled(@RequestHeader(required = false, value = "Client_Id") String Client_Id,
			@RequestHeader("Channel_Id") String Channel_Id, @RequestHeader("Correlation_Id") String Correlation_Id,
			@RequestHeader("message_Ts") String message_Ts, @RequestParam("CardNumber") String CardNumber,
			@RequestParam("Cvv") String Cvv, @RequestParam("ExpDate") String ExpDate,
			@RequestParam("NameOnCard") String NameOnCard, @RequestParam("MobileNumber") String MobileNumber,
			@RequestParam("VendorName") String VendorName) throws FileNotFoundException, IOException {
		EnrollResourceResponse enrollResourceResp = new EnrollResourceResponse();
		try {
			EnrollResourceRequest request = new EnrollResourceRequest();
			ClientInfo c = new ClientInfo();
			c.setClientId(Client_Id);
			c.setChannelId(Channel_Id);
			c.setCorrelationId(Correlation_Id);
			c.setMessageTs(message_Ts);

			CustomerInfo ci = new CustomerInfo();
			ci.setCardNum(CardNumber);
			ci.setCvv(Cvv);
			ci.setExpDate(ExpDate);
			ci.setNameOnCard(NameOnCard);

			VendorInfo vi = new VendorInfo();
			vi.setMobileNumber(MobileNumber);
			vi.setVendorName(VendorName);
			request.setClientInfo(c);
			request.setCustomerInfo(ci);
			request.setVendorInfo(vi);
			
			CardPaymentsRequestValidator requestVaildator = new CardPaymentsRequestValidator();
			requestVaildator.validateEnrollRequest(request);

			// TODO:To prepare the process enroll request with the help of
			// resource enroll request
			CardPaymentsReqBuilder reqBuilder = new CardPaymentsReqBuilder();
			EnrollProcessRequest enrollPReq = reqBuilder.buildEnrollProcessRequest(request);

			// TODO:To call the process layer
			CardPaymentsProcess process = new CardPaymentsProcessImpl();
			EnrollProcessResponse enrollPResp = process.get_Enrolled(enrollPReq);

			// TODO:To create resource response with the help of process
			// response
			CardPaymentsResBuilder resBuilder = new CardPaymentsResBuilder();
			enrollResourceResp = resBuilder.buildEnrollResourceResponse(enrollPResp);
			System.out.println("Response Code:" + enrollResourceResp.getStatusBlock().getResCode());
			System.out.println("Response Message:" + enrollResourceResp.getStatusBlock().getResMsg());
			System.out.println("Enrollment Status:" + enrollResourceResp.getStatusBlock().getEnrollStatus());

		} catch (Exception e) {
			logger.fatal("Entered in catch block", e);
			// e.printStackTrace();
		}
		return enrollResourceResp;
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		System.setProperty("env", "dev");
		CardPaymentsController resource = new CardPaymentsController();
		EnrollResourceResponse response = resource.get_Enrolled("web", "online", "12345678901234567891234567894562",
				"20-11-2019", "123456789", "456", "24-11-2019", "Srinivas", "9906854566", "idea");
	}
}
