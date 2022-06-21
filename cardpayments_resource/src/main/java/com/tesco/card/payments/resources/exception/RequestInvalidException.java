package com.tesco.card.payments.resources.exception;

public class RequestInvalidException extends Exception {

	private static final long serialVersionUID = -7039758606672027325L;
  
	private String resCode;
	private String resMsg;
	
	public RequestInvalidException(String resCode,String resMsg){
		this.resCode=resCode;
		this.resMsg=resMsg;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getResCode() {
		return resCode;
	}

	public String getResMsg() {
		return resMsg;
	}
	
}
