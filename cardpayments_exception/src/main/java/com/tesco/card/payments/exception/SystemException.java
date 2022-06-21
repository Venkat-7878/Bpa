/**@CopyRight 2019 tesco ,All Rights are reserved .
 * We should not disclose the information outside ,
   otherwise terms and conditions will apply.
 */
package com.tesco.card.payments.exception;
/**
 * @author : Venkatesh
 * @Date   :Apr 30, 2019
 * @Description:
 * 
 */
public class SystemException extends Exception{
     
	private String respCode;
	private String respMsg;
	
	public SystemException(String respCode, String respMsg) {
		this.respCode = respCode;
		this.respMsg = respMsg;
	}

	public String getRespCode() {
		return respCode;
	}

	public String getRespMsg() {
		return respMsg;
	}
	
	
}
