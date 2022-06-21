package com.tesco.card.payments.dao.beans;

public class EnrollDAOResponse {
	private String resCode;
	private String resMsg;
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
	@Override
	public String toString() {
		return "EnrollDAOResponse [resCode=" + resCode + ", resMsg=" + resMsg + "]";
	}
}
