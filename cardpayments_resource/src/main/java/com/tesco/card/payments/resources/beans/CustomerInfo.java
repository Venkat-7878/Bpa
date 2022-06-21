package com.tesco.card.payments.resources.beans;

public class CustomerInfo {

private String cardNum;
private String cvv;
private String expDate;
private String nameOnCard;

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
public String getExpDate() {
	return expDate;
}
public void setExpDate(String expDate) {
	this.expDate = expDate;
}
public String getNameOnCard() {
	return nameOnCard;
}
public void setNameOnCard(String nameOnCard) {
	this.nameOnCard = nameOnCard;
}
@Override
public String toString() {
	return "CustomerInfo [cardNum=" + cardNum + ", cvv=" + cvv + ", expDate=" + expDate + ", nameOnCard=" + nameOnCard
			+ "]";
}
}
