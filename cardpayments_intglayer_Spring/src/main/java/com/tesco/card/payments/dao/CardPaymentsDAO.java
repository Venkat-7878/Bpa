/**@CopyRight 2019 tesco ,All Rights are reserved .
 * We should not disclose the information outside ,
   otherwise terms and conditions will apply.
 */
package com.tesco.card.payments.dao;

import com.tesco.card.payments.dao.beans.CardPaymentsDAOReq;
import com.tesco.card.payments.dao.beans.CardPaymentsDAORes;
import com.tesco.card.payments.exception.BuisnessException;
import com.tesco.card.payments.exception.SystemException;



/**
 * @author : Venkatesh
 * @Date   :Apr 30, 2019
 * @Description:
 * 
 */
public interface CardPaymentsDAO {

	CardPaymentsDAORes doPayments(CardPaymentsDAOReq daoRequest) throws BuisnessException, SystemException;

}
