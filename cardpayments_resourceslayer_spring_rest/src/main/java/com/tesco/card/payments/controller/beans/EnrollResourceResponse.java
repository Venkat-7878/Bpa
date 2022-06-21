package com.tesco.card.payments.controller.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EnrollResourceResponse {
	private StatusBlock statusBlock;
	private AccountDetails accountdtls;

	public StatusBlock getStatusBlock() {
		return statusBlock;
	}
	public void setStatusBlock(StatusBlock statusBlock) {
		this.statusBlock = statusBlock;
	}
	public AccountDetails getAccountdtls() {
		return accountdtls;
	}
	public void setAccountdtls(AccountDetails accountdtls) {
		this.accountdtls = accountdtls;
	}
	@Override
	public String toString() {
		return "EnrollResourceResponse [statusBlock=" + statusBlock + ", accountdtls=" + accountdtls + "]";
	}

	
}
