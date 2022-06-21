package com.tesco.card.payments.resources.beans;

public class AccountDetails {
   private String backNumber;
   private String sortCode;
   private String billDate;
   private String billPaymentDate;
   private String mobileNumber;
   private String fName;
   private String lName;
   
public String getBackNumber() {
	return backNumber;
}
public void setBackNumber(String backNumber) {
	this.backNumber = backNumber;
}
public String getSortCode() {
	return sortCode;
}
public void setSortCode(String sortCode) {
	this.sortCode = sortCode;
}
public String getBillDate() {
	return billDate;
}
public void setBillDate(String billDate) {
	this.billDate = billDate;
}
public String getBillPaymentDate() {
	return billPaymentDate;
}
public void setBillPaymentDate(String billPaymentDate) {
	this.billPaymentDate = billPaymentDate;
}
public String getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
}
public String getfName() {
	return fName;
}
public void setfName(String fName) {
	this.fName = fName;
}
public String getlName() {
	return lName;
}
public void setlName(String lName) {
	this.lName = lName;
}
@Override
public String toString() {
	return "AccountDetails [backNumber=" + backNumber + ", sortCode=" + sortCode + ", billDate=" + billDate
			+ ", billPaymentDate=" + billPaymentDate + ", mobileNumber=" + mobileNumber + ", fName=" + fName
			+ ", lName=" + lName + "]";
}

}
