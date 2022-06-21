package com.tesco.card.payments.resources.beans;

public class PaymentStatus {
	
	private String paymentStatus;
	private String amount;
	private String date;
	private String desc;
	
	//Generated Setters and Getters for Payment Status fields
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return "PaymentStatus [paymentStatus=" + paymentStatus + ", amount=" + amount + ", date=" + date + ", desc="
				+ desc + "]";
	}
}
