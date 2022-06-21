/**@CopyRight 2019 tesco ,All Rights are reserved .
 * We should not disclose the information outside ,
   otherwise terms and conditions will apply.
 */
package com.tesco.card.payments.dao.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

import com.tesco.card.payments.dao.CardPaymentsDAO;
import com.tesco.card.payments.dao.beans.CardPaymentsDAOReq;
import com.tesco.card.payments.dao.beans.CardPaymentsDAORes;
import com.tesco.card.payments.dao.beans.EnrollDAORequest;
import com.tesco.card.payments.dao.beans.EnrollDAOResponse;
import com.tesco.card.payments.dao.beans.EnrollO2DAORequest;
import com.tesco.card.payments.exception.BuisnessException;
import com.tesco.card.payments.exception.SystemException;

/**
 * @author : Venkatesh
 * @Date :Apr 30, 2019
 * @Description:
 * 
 */
public class CardPaymentsDAOImpl implements CardPaymentsDAO {

	public  EnrollDAOResponse get_Enrolled(EnrollO2DAORequest enrollrequest) throws FileNotFoundException, IOException {
		//loading properties from respective db environments
		String env =System.getProperty("env");
		String file="enroll_"+env+"_db.properties";
		System.out.println("loading db properties from:"+file+" file");
		Properties props=new Properties();
		props.load(new FileInputStream("D:\\stsoft\\64bit\\eclipse-jee-neon-3-win32-x86_64\\eclipse\\RTP4510\\RTP4510\\bpa\\branches\\cardpayments_intglayer\\src\\main\\resources\\Properties\\"+file));
		System.out.println("dao input request"+enrollrequest);
		EnrollDAOResponse enrollDAOResponse=new EnrollDAOResponse();
		try {
			System.out.println("enter into try");
			// load the driver class
			Class.forName(props.getProperty("_driver"));
			// get the connection
			Connection con = DriverManager.getConnection(props.getProperty("_url"),props.getProperty("_uname"),props.getProperty("_password"));
			// prepare the store procedure request
			String sql = "{call EnrollmentO2(?,?,?,?,?,?,?,?,?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			// register with output parameters
			cs.registerOutParameter(8, Types.VARCHAR);
			cs.registerOutParameter(9, Types.VARCHAR);
			cs.registerOutParameter(10, Types.VARCHAR);
			// register with Input parameters
			cs.setString(1, enrollrequest.getBackNumber());
			cs.setString(2, enrollrequest.getBillDate());
			cs.setString(3, enrollrequest.getBillPaymentDate());
			cs.setString(4, enrollrequest.getMobileNumber());
			cs.setString(5,enrollrequest.getSortCode());
			cs.setString(6, enrollrequest.getfName());
			cs.setString(7, enrollrequest.getlName());
			
			
			// call stored procedure and veify the syntaxes
			System.out.println("call proc");
			// execute the stored procedure
			boolean b=cs.execute();
			ResultSet rs = cs.executeQuery();
			while (rs.next()){
				System.out.println("iterating resultset");
				System.out.println(rs.getString(1) +" "+ rs.getString(2) +" "+ rs.getString(3) +" "+ rs.getString(4)
								+" "+ rs.getString(5)+" " + rs.getString(6) +" ");
			}
			System.out.println("response");
			// retrieve the output params and adding to enroll response
		     enrollDAOResponse.setResCode(cs.getString(8));
		     enrollDAOResponse.setResMsg(cs.getString(9));
		     enrollDAOResponse.setEnrollStatus(cs.getString(10));

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return enrollDAOResponse;

	}

	public CardPaymentsDAORes doPayments(CardPaymentsDAOReq daoRequest) throws BuisnessException, SystemException {
		// TODO Get the DB request with the help of dao request
		System.out.println("Entered into DAO Layer");
		// TODO Get the ResultSet object from the DB and prepare the DAO
		// response with the
		// help of it
		CardPaymentsDAORes daoResponse = new CardPaymentsDAORes();
		daoResponse.setErrorCode("0");
		daoResponse.setErrorMsg("Success");
		// daoResponse.setResCode("0");
		// daoResponse.setResMsg("Success");
		daoResponse.setResCode("200");
		daoResponse.setResMsg("System exception");
		// daoResponse.setResCode("100");
		// daoResponse.setResMsg("business exception");
		daoResponse.setAmount("10,000");
		daoResponse.setDate("07-5-2019");
		daoResponse.setDesc("The Payment is done on time");

		if ("0".equals(daoResponse.getResCode())) {
			System.out.println("prepare the dao response with the help of resultset object");
		} else if ("100".equals(daoResponse.getResCode()) || "101".equals(daoResponse.getResCode())
				|| "102".equals(daoResponse.getResCode())) {
			throw new BuisnessException(daoResponse.getResCode(), daoResponse.getResMsg());
		} else if ("200".equals(daoResponse.getResCode()) || "201".equals(daoResponse.getResCode())
				|| "202".equals(daoResponse.getResCode())) {
			throw new SystemException(daoResponse.getResCode(), daoResponse.getResMsg());
		}
		System.out.println("Exit from DAO Layer" + daoResponse);
		return daoResponse;
	}

	public static void main(String[] args) throws FileNotFoundException, IOException{
		CardPaymentsDAOImpl impl=new CardPaymentsDAOImpl();
		System.setProperty("env","dev");
		//EnrollDAORequest enrollrequest = new EnrollDAORequest();
		//impl.get_Enrolled(enrollrequest);
	}
}
