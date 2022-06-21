/**@CopyRight 2019 tesco ,All Rights are reserved .
 * We should not disclose the information outside ,
   otherwise terms and conditions will apply.
 */
package com.tesco.card.payments.resources.validator;

import com.tesco.card.payments.resources.beans.CardPaymentsReqBean;
import com.tesco.card.payments.resources.beans.ClientInfo;
import com.tesco.card.payments.resources.beans.CustomerInfo;
import com.tesco.card.payments.resources.beans.EnrollResourceRequest;
import com.tesco.card.payments.resources.exception.RequestInvalidException;

/**
 * @author : Venkatesh
 * @Date   :Apr 30, 2019
 * @Description:
 * 
 */
public class CardPaymentsRequestValidator {

	public void validateRequest(CardPaymentsReqBean request) throws RequestInvalidException {
		// TODO :Validate the resource request
		System.out.println("Entered into the resource validator"+request);
		if(request==null||request.getClientInfo()==null||request.getCustomerInfo()==null){
			throw new RequestInvalidException("bpa001","The Request is not Valid");
		}
		
		if(request.getClientInfo().getClientId()==null||" ".equals(request.getClientInfo().getClientId())){
			throw new RequestInvalidException("bpa002","The Client Request is not Valid");
		}
		if(request.getClientInfo().getChannelId()==null||" ".equals(request.getClientInfo().getChannelId())){
			throw new RequestInvalidException("bpa003","The ChannelID is not Valid");
		}
		if(request.getClientInfo().getCorrelationId()==null||" ".equals(request.getClientInfo().getCorrelationId().length()==32)){
			throw new RequestInvalidException("bpa004","The Correlation Id  is not Valid");
		}
		if(request.getCustomerInfo().getCardNum()==null||" ".equals((request.getCustomerInfo().getCardNum().length()==17))){
			throw new RequestInvalidException("bpa005","The Card Number is not Valid");
		}
		if(request.getCustomerInfo().getCvv()==null||" ".equals(request.getCustomerInfo().getCvv().length()<4)){
			throw new RequestInvalidException("bpa006","The Cvv no is not Valid");
		}
		if(request.getCustomerInfo().getNameOnCard()==null||" ".equals(request.getCustomerInfo().getNameOnCard())){
			throw new RequestInvalidException("bpa007","The Name on Card is not Valid");
		}
		if(request.getCustomerInfo().getExpDate()==null||" ".equals(request.getCustomerInfo().getExpDate())){
			throw new RequestInvalidException("bpa008","The Expiry Date is not Valid");
		}
		
		System.out.println("Done the validation"+request);
	}

	public void validateEnrollRequest(EnrollResourceRequest enrollrequest) {
		
		System.out.println("Done the enroll validation"+enrollrequest);
	}

}
