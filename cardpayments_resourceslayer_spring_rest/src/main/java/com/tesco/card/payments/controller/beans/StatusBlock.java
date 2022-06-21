package com.tesco.card.payments.controller.beans;

public class StatusBlock {

	private String resCode;
	private String resMsg;
	private String enrollStatus;

	// Generated Setters and Getters for StatusBlock Fields
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
		return "StatusBlock [resCode=" + resCode + ", resMsg=" + resMsg + ", enrollStatus=" + enrollStatus + "]";
	}
}
