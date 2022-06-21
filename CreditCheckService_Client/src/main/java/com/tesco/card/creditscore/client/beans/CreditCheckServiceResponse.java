package com.tesco.card.creditscore.client.beans;

public class CreditCheckServiceResponse {

	private String respCode;
	private String respMsg;
	private float scorePercent;
	
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getRespMsg() {
		return respMsg;
	}
	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
	public float getScorePercent() {
		return scorePercent;
	}
	public void setScorePercent(float scorePercent) {
		this.scorePercent = scorePercent;
	}
	@Override
	public String toString() {
		return "CreditCheckServiceResponse [respCode=" + respCode + ", respMsg=" + respMsg + ", scorePercent="
				+ scorePercent + "]";
	}
}
