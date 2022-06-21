package com.tesco.card.payments.resources.beans;

public class VendorInfo {
     private String mobileNumber;
     private String vendorName;
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
		return "VendorInfo [mobileNumber=" + mobileNumber + ", vendorName=" + vendorName + "]";
	}
}
