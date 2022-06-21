package com.tesco.card.payments.process.beans;

public class EnrollProcessResponse {
	private String resCode;
	private String resMsg;
	private String enrollStatus;
	
	public String getResCode() {
		return resCode;
	}
	public void setResCode(String resCode) {
		this.resCode = resCode;
	}
	public String getResMsg() {
		return resMsg;
	}
	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}
	public String getEnrollStatus() {
		return enrollStatus;
	}
	public void setEnrollStatus(String enrollStatus) {
		this.enrollStatus = enrollStatus;
	}
	@Override
	public String toString() {
		return "EnrollProcessResponse [resCode=" + resCode + ", resMsg=" + resMsg + ", enrollStatus=" + enrollStatus
				+ "]";
	}
}
