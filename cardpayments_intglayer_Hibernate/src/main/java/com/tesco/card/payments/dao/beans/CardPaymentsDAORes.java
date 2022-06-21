/**@CopyRight 2019 tesco ,All Rights are reserved .
 * We should not disclose the information outside ,
   otherwise terms and conditions will apply.
 */
package com.tesco.card.payments.dao.beans;

/**
 * @author : Venkatesh
 * @Date   :Apr 30, 2019
 * @Description:
 * 
 */
public class CardPaymentsDAORes {

	private String errorCode;
	private String errorMsg;
	private String resCode;
	private String resMsg;
	private String paymentStatus;
	private String amount;
	private String date;
	private String desc;
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
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
		return "CardPaymentsDAORes [errorCode=" + errorCode + ", errorMsg=" + errorMsg + ", resCode=" + resCode
				+ ", resMsg=" + resMsg + ", paymentStatus=" + paymentStatus + ", amount=" + amount + ", date=" + date
				+ ", desc=" + desc + "]";
	}
}
