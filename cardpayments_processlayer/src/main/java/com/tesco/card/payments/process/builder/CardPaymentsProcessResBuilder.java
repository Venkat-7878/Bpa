/**@CopyRight 2019 tesco ,All Rights are reserved .
 * We should not disclose the information outside ,
   otherwise terms and conditions will apply.
 */
package com.tesco.card.payments.process.builder;

import com.tesco.card.payments.dao.beans.CardPaymentsDAORes;
import com.tesco.card.payments.dao.beans.EnrollDAOResponse;
import com.tesco.card.payments.process.beans.CardPaymentsProcessResBean;
import com.tesco.card.payments.process.beans.EnrollProcessResponse;

/**
 * @author : Venkatesh
 * @Date   :Apr 30, 2019
 * @Description:
 * 
 */
public class CardPaymentsProcessResBuilder {

	public CardPaymentsProcessResBean buildProcessResponse(CardPaymentsDAORes daoResponse) {
		
		System.out.println("Entered into the process response builder");
		// TODO Get the process response by using dao response
		CardPaymentsProcessResBean processResponse =new CardPaymentsProcessResBean();
		processResponse.setErrorCode(daoResponse.getErrorCode());
		processResponse.setErrorMsg(daoResponse.getErrorMsg());
		processResponse.setResCode(daoResponse.getResCode());
		processResponse.setResMsg(daoResponse.getResMsg());
		processResponse.setAmount(daoResponse.getAmount());
		processResponse.setPaymentStatus(daoResponse.getPaymentStatus());
		processResponse.setDate(daoResponse.getDate());
		processResponse.setDesc(daoResponse.getDesc());
		System.out.println("Exit from the process response builder"+processResponse);
		return processResponse;
	}

	public EnrollProcessResponse buildProcessResponse(EnrollDAOResponse daoResponse ) {
		EnrollProcessResponse processResponse =new EnrollProcessResponse();
		System.out.println("Entered into the process enroll response builder");
		// TODO Get the process enroll response by using dao enroll response
		processResponse.setResCode(daoResponse.getResCode());
		processResponse.setResMsg(daoResponse.getResMsg());
		processResponse.setEnrollStatus(daoResponse.getEnrollStatus());
		System.out.println("Exit from the process enroll response builder"+processResponse);
		return processResponse;
	}

}
