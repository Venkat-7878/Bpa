/**
 * 
 */
package com.tesco.card.payments.dao.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author @VeeraBabu
 *
 *         Jul 3, 2019
 */
@Entity
@Table(name = "enroll")
public class EnrollEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="enroll_Id")
	private Long enrollID;
	@Column
	private String backNumber;
	@Column
	private String sortCode;
	@Column
	private String billDate;
	@Column
	private String billPaymentDate;
	@Column
	private String mobileNumber;
	@Column
	private String fName;
	@Column
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
}
