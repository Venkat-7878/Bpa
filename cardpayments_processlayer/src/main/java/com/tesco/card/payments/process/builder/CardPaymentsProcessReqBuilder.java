/**@CopyRight 2019 tesco ,All Rights are reserved .
 * We should not disclose the information outside ,
   otherwise terms and conditions will apply.
 */
package com.tesco.card.payments.process.builder;

import com.card.o2.service.svcclient.beans.O2SvcClientResponse;
import com.tesco.card.creditscore.client.beans.CreditCheckServiceRequest;
import com.tesco.card.payments.dao.beans.CardPaymentsDAOReq;
import com.tesco.card.payments.dao.beans.EnrollDAORequest;
import com.tesco.card.payments.dao.beans.EnrollO2DAORequest;
import com.tesco.card.payments.process.beans.CardPaymentsProcessReqBean;
import com.tesco.card.payments.process.beans.EnrollO2_ServiceClientRequest;
import com.tesco.card.payments.process.beans.EnrollProcessRequest;

/**
 * @author : Venkatesh
 * @Date   :Apr 30, 2019
 * @Description:
 * 
 */
public class CardPaymentsProcessReqBuilder {
    //TODO:Build the DAO request with the help of process Request
	public CardPaymentsDAOReq buildDAORequest(CardPaymentsProcessReqBean processRequest){
		System.out.println("Entered into Process Request Builder");
		CardPaymentsDAOReq daoRequest= new CardPaymentsDAOReq();
		System.out.println("created the daoreq");
		daoRequest.setClientId(processRequest.getClientId());
		daoRequest.setChannelId(processRequest.getChannelId());
		daoRequest.setCardNum(processRequest.getCardNum());
		daoRequest.setCvv(processRequest.getCvv());
		daoRequest.setExpDate(processRequest.getExpDate());
		daoRequest.setNameOnCard(processRequest.getNameOnCard());
		System.out.println("Exit from Process Request Builder"+daoRequest);
		return daoRequest;
	}

	public EnrollDAORequest buildEnrollDAORequest(EnrollProcessRequest enrollPReq ) {
		EnrollDAORequest daoRequest =new EnrollDAORequest();
		System.out.println("Entered into Process Request Builder"+enrollPReq);
		System.out.println("created the daoreq");
		daoRequest.setClientId(enrollPReq.getClientId());
		daoRequest.setChannelId(enrollPReq.getChannelId());
		daoRequest.setCardNum(enrollPReq.getCardNum());
		daoRequest.setCvv(enrollPReq.getCvv());
		daoRequest.setExpDate(enrollPReq.getExpDate());
		daoRequest.setNameOnCard(enrollPReq.getNameOnCard());
		daoRequest.setMobilenumber(enrollPReq.getMobileNumber());
		System.out.println("Exit from Process Request Builder"+daoRequest);
		return daoRequest;
	}
	public CreditCheckServiceRequest buildCreditCheckSvcRequest(EnrollProcessRequest enrollPReq ) {
		System.out.println("Entered into Process CreditCheck Request Builder"+enrollPReq);
		CreditCheckServiceRequest ccsRequest =new CreditCheckServiceRequest();
		ccsRequest.setCardNum(enrollPReq.getCardNum());
		ccsRequest.setCvv(enrollPReq.getCvv());
		ccsRequest.setNameOnCard(enrollPReq.getNameOnCard());
		ccsRequest.setExpDate(enrollPReq.getExpDate());
		System.out.println("Exit from Process CreditCheck Request Builder"+ccsRequest);
		return ccsRequest;
	}

	public EnrollO2DAORequest buildO2EnrollDAORequest(EnrollO2_ServiceClientRequest request) {
		EnrollO2DAORequest daoRequest =new EnrollO2DAORequest();
		System.out.println("Entered into Process Request Builder"+request);
		System.out.println("created the daoreq");
		daoRequest.setBackNumber(request.getO2SvcClientResp().getBackNumber());
		daoRequest.setBillDate(request.getO2SvcClientResp().getBillDate());
		daoRequest.setBillPaymentDate(request.getO2SvcClientResp().getBillPaymentDate());
		daoRequest.setMobileNumber(request.getO2SvcClientResp().getMobileNumber());
		daoRequest.setSortCode(request.getO2SvcClientResp().getSortCode());
		daoRequest.setfName(request.getO2SvcClientResp().getfName());
		daoRequest.setlName(request.getO2SvcClientResp().getlName());
		System.out.println("Exit from Process Request Builder"+daoRequest);
		return daoRequest;
	}
	public EnrollO2_ServiceClientRequest buildEnrollO2_ServiceClientRequest(O2SvcClientResponse svcResp){
		EnrollO2_ServiceClientRequest request =new EnrollO2_ServiceClientRequest();
		request.setO2SvcClientResp(svcResp);
		return request;
		
	}


}
