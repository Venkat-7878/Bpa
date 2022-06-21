/**@CopyRight 2019 tesco ,All Rights are reserved .
 * We should not disclose the information outside ,
   otherwise terms and conditions will apply.
 */
package com.tesco.card.payments.controller.beans;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author : Venkatesh
 * @Date   :Apr 30, 2019
 * @Description:
 * 
 */
@XmlRootElement
public class CardPaymentsResBean {
	
	private StatusBlock statusBlock;
	private PaymentStatus paymentStatus;
	
	
	public StatusBlock getStatusBlock() {
		return statusBlock;
	}
	public void setStatusBlock(StatusBlock statusBlock) {
		this.statusBlock = statusBlock;
	}
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	@Override
	public String toString() {
		return "CardPaymentsResBean [statusBlock=" + statusBlock + ", paymentStatus=" + paymentStatus + "]";
	}
	

}
