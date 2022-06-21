package com.tesco.card.payments.resources.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EnrollResourceRequest {
	private ClientInfo clientInfo;
	private CustomerInfo customerInfo;
	private VendorInfo vendorInfo;
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
	public VendorInfo getVendorInfo() {
		return vendorInfo;
	}
	public void setVendorInfo(VendorInfo vendorInfo) {
		this.vendorInfo = vendorInfo;
	}
	@Override
	public String toString() {
		return "EnrollResourceRequest [clientInfo=" + clientInfo + ", customerInfo=" + customerInfo + ", vendorInfo="
				+ vendorInfo + ", serviceInfo=" + serviceInfo + "]";
	}
	
	
}
