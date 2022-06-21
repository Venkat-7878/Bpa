/**@CopyRight 2019 tesco ,All Rights are reserved .
 * We should not disclose the information outside ,
   otherwise terms and conditions will apply.
 */
package com.tesco.card.payments.resources.api;

import com.tesco.card.payments.resources.beans.CardPaymentsReqBean;
import com.tesco.card.payments.resources.beans.CardPaymentsResBean;

/**
 * @author : Venkatesh
 * @Date   :Apr 30, 2019
 * @Description:
 * 
 */
public interface CardPaymentsResources {

	CardPaymentsResBean doPayments(CardPaymentsReqBean request);
}
