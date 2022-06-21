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
public class CardPaymentsReqBean {
      
	private ClientInfo clientInfo;
	private CustomerInfo customerInfo;
	private ServiceInfo serviceInfo;
	
	
	public ClientInfo getClientInfo() {
		return clientInfo;
	}
	public void setClientInfo(ClientInfo clientInfo) {
		this.clientInfo = clientInfo;
	}
	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}
	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}
	public ServiceInfo getServiceInfo() {
		return serviceInfo;
	}
	public void setServiceInfo(ServiceInfo serviceInfo) {
		this.serviceInfo = serviceInfo;
	}
	
	@Override
	public String toString() {
		return "CardPaymentsReqBean [clientInfo=" + clientInfo + ", customerInfo=" + customerInfo + ", serviceInfo="
				+ serviceInfo + "]";
	}
}
