/**@CopyRight 2019 tesco ,All Rights are reserved .
 * We should not disclose the information outside ,
   otherwise terms and conditions will apply.
 */
package com.tesco.card.payments.resources.builder;

import org.apache.log4j.Logger;

import com.tesco.card.payments.process.beans.CardPaymentsProcessReqBean;
import com.tesco.card.payments.process.beans.EnrollProcessRequest;
import com.tesco.card.payments.resources.beans.CardPaymentsReqBean;
import com.tesco.card.payments.resources.beans.EnrollResourceRequest;
import com.tesco.card.payments.resources.beans.EnrollResourceResponse;

/**
 * @author : Venkatesh
 * @Date   :Apr 30, 2019
 * @Description:
 * 
 */
public class CardPaymentsReqBuilder {
	//TODO: Get the Process request 
	private Logger logger=Logger.getLogger(CardPaymentsReqBuilder.class);
	public CardPaymentsProcessReqBean buildProcessRequest(CardPaymentsReqBean request){
		logger.info("Entered into Resource Request Builder"+request);
		CardPaymentsProcessReqBean processReq = new CardPaymentsProcessReqBean();
		logger.debug("created the process req");
		processReq.setClientId(request.getClientInfo().getClientId());
		processReq.setChannelId(request.getClientInfo().getChannelId());
		processReq.setCardNum(request.getCustomerInfo().getCardNum());
		processReq.setCvv(request.getCustomerInfo().getCvv());
		processReq.setExpDate(request.getCustomerInfo().getExpDate());
		processReq.setNameOnCard(request.getCustomerInfo().getNameOnCard());
		
		logger.debug("Exit from Resource Request Builder");
		return processReq;

   }
	public EnrollProcessRequest buildEnrollProcessRequest(EnrollResourceRequest enrollrequest) {
		EnrollProcessRequest enrollPRequest =new EnrollProcessRequest();
		logger.info("Entered into Resource Request Builder"+enrollrequest);
		logger.debug("created the process req");
		enrollPRequest.setClientId(enrollrequest.getClientInfo().getClientId());
		enrollPRequest.setChannelId(enrollrequest.getClientInfo().getChannelId());
		enrollPRequest.setCardNum(enrollrequest.getCustomerInfo().getCardNum());
		enrollPRequest.setCvv(enrollrequest.getCustomerInfo().getCvv());
		enrollPRequest.setExpDate(enrollrequest.getCustomerInfo().getExpDate());
		enrollPRequest.setNameOnCard(enrollrequest.getCustomerInfo().getNameOnCard());
		enrollPRequest.setMobileNumber(enrollrequest.getVendorInfo().getMobileNumber());
		enrollPRequest.setVendorName(enrollrequest.getVendorInfo().getVendorName());
		
		logger.debug("Exit from Resource Request Builder"+enrollPRequest);
		return enrollPRequest;
	}
}