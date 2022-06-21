package com.tesco.card.payments.exception;

public class BuisnessException extends Exception{

	private String respCode;
	private String respMsg;
	
	public BuisnessException(String respCode, String respMsg) {
		this.respCode = respCode;
		this.respMsg = respMsg;
	}

	public String getRespCode() {
		return respCode;
	}

	public String getRespMsg() {
		return respMsg;
	}

	

	
	
}
