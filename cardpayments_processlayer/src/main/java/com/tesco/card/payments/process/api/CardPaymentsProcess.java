/**@CopyRight 2019 tesco ,All Rights are reserved .
 * We should not disclose the information outside ,
   otherwise terms and conditions will apply.
 */
package com.tesco.card.payments.process.api;

import java.io.IOException;

import com.tesco.card.payments.exception.BuisnessException;
import com.tesco.card.payments.exception.SystemException;
import com.tesco.card.payments.process.beans.CardPaymentsProcessReqBean;
import com.tesco.card.payments.process.beans.CardPaymentsProcessResBean;
import com.tesco.card.payments.process.beans.EnrollProcessRequest;
import com.tesco.card.payments.process.beans.EnrollProcessResponse;

/**
 * @author : Venkatesh
 * @Date   :Apr 30, 2019
 * @Description:
 * 
 */
public interface CardPaymentsProcess {
	
	CardPaymentsProcessResBean doPayments(CardPaymentsProcessReqBean processRequest) throws BuisnessException, SystemException;

	public EnrollProcessResponse get_Enrolled(EnrollProcessRequest enrollPReq) throws IOException, Exception;

}
