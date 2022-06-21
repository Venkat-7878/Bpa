/**@CopyRight 2019 tesco ,All Rights are reserved .
 * We should not disclose the information outside ,
   otherwise terms and conditions will apply.
 */
package com.tesco.card.payments.process.api.impl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.card.o2.service.svcclient.O2_SvcClientApi;
import com.card.o2.service.svcclient.beans.O2SvcClientRequest;
import com.card.o2.service.svcclient.beans.O2SvcClientResponse;
import com.card.o2.service.svcclient.impl.O2_SvcClientImpl;
import com.tesco.card.creditscore.client.CreditCheckServiceClient;
import com.tesco.card.creditscore.client.beans.CreditCheckServiceRequest;
import com.tesco.card.creditscore.client.beans.CreditCheckServiceResponse;
import com.tesco.card.creditscore.client.impl.CreditCheckServiceClientImpl;
import com.tesco.card.payments.dao.CardPaymentsDAO;
import com.tesco.card.payments.dao.beans.CardPaymentsDAOReq;
import com.tesco.card.payments.dao.beans.CardPaymentsDAORes;
import com.tesco.card.payments.dao.beans.EnrollDAORequest;
import com.tesco.card.payments.dao.beans.EnrollDAOResponse;
import com.tesco.card.payments.dao.beans.EnrollO2DAORequest;
import com.tesco.card.payments.dao.impl.CardPaymentsDAOImpl;
import com.tesco.card.payments.exception.BuisnessException;
import com.tesco.card.payments.exception.SystemException;
import com.tesco.card.payments.process.api.CardPaymentsProcess;
import com.tesco.card.payments.process.beans.CardPaymentsProcessReqBean;
import com.tesco.card.payments.process.beans.CardPaymentsProcessResBean;
import com.tesco.card.payments.process.beans.EnrollO2_ServiceClientRequest;
import com.tesco.card.payments.process.beans.EnrollProcessRequest;
import com.tesco.card.payments.process.beans.EnrollProcessResponse;
import com.tesco.card.payments.process.builder.CardPaymentsProcessReqBuilder;
import com.tesco.card.payments.process.builder.CardPaymentsProcessResBuilder;


/**
 * @author : Venkatesh
 * @Date   :Apr 30, 2019
 * @Description:
 * 
 */
public class CardPaymentsProcessImpl implements CardPaymentsProcess{
	EnrollProcessResponse enrollPResp =new EnrollProcessResponse();
	public EnrollProcessResponse get_Enrolled(EnrollProcessRequest enrollPReq) throws IOException, Exception {
		//TODO:To prepare the DAO request with the help of process request
		CardPaymentsProcessReqBuilder reqProBuilder = new CardPaymentsProcessReqBuilder();
		//TODO:To call the Credit Check Service 
		CreditCheckServiceClient ccsClient =new CreditCheckServiceClientImpl();
		CreditCheckServiceRequest ccsRequest = reqProBuilder.buildCreditCheckSvcRequest(enrollPReq);
		CreditCheckServiceResponse ccsResponse= ccsClient.getCreditScore(ccsRequest);
		
		System.out.println("got credit score response"+ccsResponse);
		if(ccsResponse.getScorePercent()>=60){
			O2_SvcClientApi	scvClient=new O2_SvcClientImpl();
			O2SvcClientRequest svcReq=new O2SvcClientRequest();
			svcReq.setMobileNumber(enrollPReq.getMobileNumber());
			O2SvcClientResponse svcResp=scvClient.verify(svcReq);
              
			EnrollO2_ServiceClientRequest request=reqProBuilder.buildEnrollO2_ServiceClientRequest(svcResp);
			EnrollO2DAORequest enrollrequest= reqProBuilder.buildO2EnrollDAORequest(request);
			//TODO:To call the DAO layer
			CardPaymentsDAO dao = new CardPaymentsDAOImpl();
			  EnrollDAOResponse daoResponse=dao.getEnrolled(enrollrequest);
			//TODO: To prepare process response with the help of dao response
			CardPaymentsProcessResBuilder resBuilder =new CardPaymentsProcessResBuilder();
			enrollPResp = resBuilder.buildProcessResponse(daoResponse);
		}else{
			System.out.println("The credit score is less than 60 ,please clear the previous credits");
			enrollPResp.setResCode(ccsResponse.getRespCode());
			enrollPResp.setResMsg(ccsResponse.getRespMsg());
		}
		
		return enrollPResp;
	}

	public CardPaymentsProcessResBean doPayments(CardPaymentsProcessReqBean processRequest) throws BuisnessException, SystemException {
		
		//TODO:To prepare the process request with the help of resource request
				CardPaymentsProcessReqBuilder reqProBuilder = new CardPaymentsProcessReqBuilder();
				CardPaymentsDAOReq daoRequest= reqProBuilder.buildDAORequest(processRequest);
				//TODO:To call the DAO layer
				CardPaymentsDAO dao = new CardPaymentsDAOImpl();
				CardPaymentsDAORes daoResponse=dao.doPayments(daoRequest);
				//TODO: To prepare process response with the help of dao response
				CardPaymentsProcessResBean processResponse = new CardPaymentsProcessResBean();
				CardPaymentsProcessResBuilder resBuilder =new CardPaymentsProcessResBuilder();
				 processResponse=resBuilder.buildProcessResponse(daoResponse);
				
				
		return processResponse;
	}

	

}
