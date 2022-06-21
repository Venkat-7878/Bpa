package com.card.o2.service.svcclient.beans;

public class O2SvcClientRequest {
         private String mobileNumber;

		public String getMobileNumber() {
			return mobileNumber;
		}

		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}

		@Override
		public String toString() {
			return "O2SvcClientRequest [mobileNumber=" + mobileNumber + "]";
		}
}
