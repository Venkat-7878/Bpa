package com.tesco.card.payments.process.beans;

public class EnrollProcessRequest {
	private String clientId;
	private String channelId;
	private String cardNum;
	private String cvv;
	private String nameOnCard;
	private String expDate;
	private String mobileNumber;
	private String vendorName;

	
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	@Override
	public String toString() {
		return "EnrollProcessRequest [clientId=" + clientId + ", channelId=" + channelId + ", cardNum=" + cardNum
				+ ", cvv=" + cvv + ", nameOnCard=" + nameOnCard + ", expDate=" + expDate + ", mobileNumber="
				+ mobileNumber + ", vendorName=" + vendorName + "]";
	}
	
	
}
