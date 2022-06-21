/**@CopyRight 2019 tesco ,All Rights are reserved .
 * We should not disclose the information outside ,
   otherwise terms and conditions will apply.
 */
package com.tesco.card.payments.controller.builder;

import com.tesco.card.payments.controller.beans.CardPaymentsResBean;
import com.tesco.card.payments.controller.beans.EnrollResourceResponse;
import com.tesco.card.payments.controller.beans.PaymentStatus;
import com.tesco.card.payments.controller.beans.StatusBlock;
import com.tesco.card.payments.process.beans.CardPaymentsProcessResBean;
import com.tesco.card.payments.process.beans.EnrollProcessResponse;

/**
 * @author : Venkatesh
 * @Date :Apr 30, 2019
 * @Description:
 * 
 */
public class CardPaymentsResBuilder {

	public CardPaymentsResBean buildResourceResponse(CardPaymentsProcessResBean processResponse) {
		// TODO:To build resource response with the help of process response
		System.out.println("Entered into Resource response builder");
		CardPaymentsResBean resourceResponse = new CardPaymentsResBean();
		
		//TODO:Create Object of Status Block and set the Field values
		StatusBlock stBlock = new StatusBlock();
		stBlock.setResCode(processResponse.getResCode());
		stBlock.setResMsg(processResponse.getResMsg());
		
		//TODO:Create Object of PaymentStatus and set the Field values
		PaymentStatus pStatus = new PaymentStatus();
		pStatus.setAmount(processResponse.getAmount());
		pStatus.setPaymentStatus(processResponse.getPaymentStatus());
		pStatus.setDate(processResponse.getDate());
		pStatus.setDesc(processResponse.getDesc());
		
		resourceResponse.setPaymentStatus(pStatus);
		resourceResponse.setStatusBlock(stBlock);
		
		System.out.println("Exit from Resource response builder"+resourceResponse);
		return resourceResponse;

	}

	public EnrollResourceResponse buildEnrollResourceResponse(EnrollProcessResponse enrollPResp) {
		
		EnrollResourceResponse enrollResponse =new EnrollResourceResponse();
		// TODO:To build resource response with the help of process response
				System.out.println("Entered into Resource response builder");
				//TODO:Create Object of Status Block and set the Field values
				StatusBlock stBlock = new StatusBlock();
				stBlock.setResCode(enrollPResp.getResCode());
				stBlock.setResMsg(enrollPResp.getResMsg());
				stBlock.setEnrollStatus(enrollPResp.getEnrollStatus());
				enrollResponse.setStatusBlock(stBlock);
				
				System.out.println("Exit from Resource response builder"+enrollResponse);
		return enrollResponse;
	}

}
