/**@CopyRight 2019 tesco ,All Rights are reserved .
 * We should not disclose the information outside ,
   otherwise terms and conditions will apply.
 */
package com.tesco.card.payments.resources.api.impl;


import java.io.FileNotFoundException;
import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.tesco.card.payments.exception.BuisnessException;
import com.tesco.card.payments.exception.SystemException;
import com.tesco.card.payments.process.api.CardPaymentsProcess;
import com.tesco.card.payments.process.api.impl.CardPaymentsProcessImpl;
import com.tesco.card.payments.process.beans.CardPaymentsProcessReqBean;
import com.tesco.card.payments.process.beans.CardPaymentsProcessResBean;
import com.tesco.card.payments.process.beans.EnrollProcessRequest;
import com.tesco.card.payments.process.beans.EnrollProcessResponse;
import com.tesco.card.payments.resources.api.CardPaymentsResources;
import com.tesco.card.payments.resources.beans.CardPaymentsReqBean;
import com.tesco.card.payments.resources.beans.CardPaymentsResBean;
import com.tesco.card.payments.resources.beans.ClientInfo;
import com.tesco.card.payments.resources.beans.CustomerInfo;
import com.tesco.card.payments.resources.beans.EnrollResourceRequest;
import com.tesco.card.payments.resources.beans.EnrollResourceResponse;
import com.tesco.card.payments.resources.beans.ServiceInfo;
import com.tesco.card.payments.resources.beans.StatusBlock;
import com.tesco.card.payments.resources.beans.VendorInfo;
import com.tesco.card.payments.resources.builder.CardPaymentsReqBuilder;
import com.tesco.card.payments.resources.builder.CardPaymentsResBuilder;
import com.tesco.card.payments.resources.exception.RequestInvalidException;
import com.tesco.card.payments.resources.validator.CardPaymentsRequestValidator;

/**
 * @author : Venkatesh
 * @Date :Apr 30, 2019
 * @Description:
 * 
 */
@Path("/card")
public class CardPaymentsResourcesImpl implements CardPaymentsResources {
     
	private Logger logger=Logger.getLogger(CardPaymentsResourcesImpl.class);
	// TODO:To enroll the User
	@Path("/enroll")
	@POST
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public EnrollResourceResponse get_Enrolled(@HeaderParam("Client_Id") String Client_Id,@HeaderParam("Channel_Id") String Channel_Id,@HeaderParam("Correlation_Id") String Correlation_Id,@HeaderParam("message_Ts") String message_Ts , EnrollResourceRequest enrollrequest) throws FileNotFoundException, IOException {
		EnrollResourceResponse enrollResourceResp =new EnrollResourceResponse();;
		try {
			CardPaymentsRequestValidator requestVaildator = new CardPaymentsRequestValidator();
			requestVaildator.validateEnrollRequest(enrollrequest);

			// TODO:To prepare the process enroll request with the help of resource enroll request
			CardPaymentsReqBuilder reqBuilder = new CardPaymentsReqBuilder();
			EnrollProcessRequest enrollPReq = reqBuilder.buildEnrollProcessRequest(enrollrequest);

			// TODO:To call the process layer
			CardPaymentsProcess process = new CardPaymentsProcessImpl();
			 EnrollProcessResponse enrollPResp= process.get_Enrolled(enrollPReq);
			 
			// TODO:To create resource response with the help of process
		    // response
			 CardPaymentsResBuilder resBuilder = new CardPaymentsResBuilder();
			enrollResourceResp = resBuilder.buildEnrollResourceResponse(enrollPResp);
			System.out.println("Response Code:"+enrollResourceResp.getStatusBlock().getResCode());
			System.out.println("Response Message:"+enrollResourceResp.getStatusBlock().getResMsg());
			System.out.println("Enrollment Status:"+enrollResourceResp.getStatusBlock().getEnrollStatus());
			
		 } catch (Exception e) {
			logger.fatal("Entered in catch block" ,e);
			//e.printStackTrace();
		}
		return enrollResourceResp;
	}
	@Path("/payments")
	@POST
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public CardPaymentsResBean doPayments(CardPaymentsReqBean request) {

		logger.debug("Entered into resource layer dopayments");
		// TODO: To get the request from the User and Validate the request
		CardPaymentsResBean resourceResponse = null;
		CardPaymentsProcessResBean processResponse = null;
		try {
			CardPaymentsRequestValidator requestVaildator = new CardPaymentsRequestValidator();
			requestVaildator.validateRequest(request);

			// TODO:To prepare the process request with the help of resource
			// request
			CardPaymentsReqBuilder reqBuilder = new CardPaymentsReqBuilder();
			CardPaymentsProcessReqBean processRequest = reqBuilder.buildProcessRequest(request);

			// TODO:To call the process layer
			CardPaymentsProcessImpl process = new CardPaymentsProcessImpl();
			 processResponse = process.doPayments(processRequest);
			 if("300".equals(processResponse.getResCode())){
				 System.out.println("score percent is less");
			 }
			// TODO:To create resource response with the help of process
		    // response
			 CardPaymentsResBuilder resBuilder = new CardPaymentsResBuilder();
			 resourceResponse = resBuilder.buildResourceResponse(processResponse);
			
		 } catch (RequestInvalidException e) {
			resourceResponse = new CardPaymentsResBean();
			StatusBlock statusBlock = new StatusBlock();
			statusBlock.setResCode(e.getResCode());
			statusBlock.setResMsg(e.getResMsg());
			resourceResponse.setStatusBlock(statusBlock);
			logger.error("Entered in catch block" ,e);
			//e.printStackTrace();

		} catch (BuisnessException be) {
			resourceResponse = new CardPaymentsResBean();
			StatusBlock statusBlock = new StatusBlock();
			statusBlock.setResCode(be.getRespCode());
			statusBlock.setResMsg(be.getRespMsg());
			resourceResponse.setStatusBlock(statusBlock);
			logger.error("Entered in catch block" ,be);
			//be.printStackTrace();
		} catch (SystemException se) {
			resourceResponse = new CardPaymentsResBean();
			StatusBlock statusBlock = new StatusBlock();
			statusBlock.setResCode(se.getRespCode());
			statusBlock.setResMsg(se.getRespMsg());
			resourceResponse.setStatusBlock(statusBlock);
			logger.error("Entered in catch block" ,se);
			//se.printStackTrace();
		} catch (Exception e) {
			logger.fatal("Entered in catch block" ,e);
			//e.printStackTrace();
		}

		return resourceResponse;
	}
	@GET
	@Produces(javax.ws.rs.core.MediaType.TEXT_HTML)
	@Path("/HeathCheck")
	public String servicesStatus(){
		return "Services are Up and Running";
	}

	public static void main(String[] args) throws Exception, IOException {
		System.setProperty("env","dev");
		CardPaymentsResourcesImpl resource = new CardPaymentsResourcesImpl();
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
		
		 VendorInfo vi=new VendorInfo();
	        vi.setMobileNumber("7893219190");
	        vi.setVendorName("Vodafone");
	        
	        ServiceInfo si=new ServiceInfo();
	        si.setServiceName("BPA service");
	        si.setApiName("enroll");
	        si.setVersion("1.0");

		request.setClientInfo(c);
		//request.setCustomerInfo(ci); 
		//request.setServiceInfo(si);
		//resource.doPayments(request);
		
		EnrollResourceRequest enrollrequest = new EnrollResourceRequest();
		enrollrequest.setClientInfo(c);
		enrollrequest.setCustomerInfo(ci);
		enrollrequest.setVendorInfo(vi);
		enrollrequest.setServiceInfo(si);
		EnrollResourceResponse response =resource.get_Enrolled("web", "online","12345678901234567891234567894562","20-11-2019", enrollrequest);
		System.out.println("Response Code:"+response.getStatusBlock().getResCode());
		System.out.println("Response Message:"+response.getStatusBlock().getResMsg());
		System.out.println("Enrollment Status:"+response.getStatusBlock().getEnrollStatus());
	}

}
