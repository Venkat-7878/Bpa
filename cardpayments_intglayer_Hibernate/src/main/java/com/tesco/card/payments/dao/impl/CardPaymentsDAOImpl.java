/**@CopyRight 2019 tesco ,All Rights are reserved .
 * We should not disclose the information outside ,
   otherwise terms and conditions will apply.
 */
package com.tesco.card.payments.dao.impl;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tesco.card.payments.dao.CardPaymentsDAO;
import com.tesco.card.payments.dao.beans.CardPaymentsDAOReq;
import com.tesco.card.payments.dao.beans.CardPaymentsDAORes;
import com.tesco.card.payments.dao.beans.EnrollDAOResponse;
import com.tesco.card.payments.dao.beans.EnrollEntity;
import com.tesco.card.payments.dao.beans.EnrollO2DAORequest;
import com.tesco.card.payments.dao.util.SessionFactoryUtility;
import com.tesco.card.payments.exception.BuisnessException;
import com.tesco.card.payments.exception.SystemException;

/**
 * @author : Venkatesh
 * @Date :Apr 30, 2019
 * @Description:
 * 
 */
public class CardPaymentsDAOImpl implements CardPaymentsDAO {

	public EnrollDAOResponse get_Enrolled(EnrollO2DAORequest enrollrequest) {

		SessionFactory sessionFactory = SessionFactoryUtility.getSessionFactory();
		Transaction tx = null;
		System.out.println("dao input request" + enrollrequest);
		EnrollDAOResponse enrollDAOResponse = new EnrollDAOResponse();
		EnrollEntity enrollEntity = new EnrollEntity();
		try {
			
			System.out.println("  "+sessionFactory);
			Session session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			enrollEntity.setBackNumber(enrollrequest.getBackNumber());
			enrollEntity.setBillDate(enrollrequest.getBillDate());
			enrollEntity.setBillPaymentDate(enrollrequest.getBillPaymentDate());
			enrollEntity.setfName(enrollrequest.getfName());
			enrollEntity.setlName(enrollrequest.getlName());
			enrollEntity.setMobileNumber(enrollrequest.getMobileNumber());
			enrollEntity.setSortCode(enrollrequest.getSortCode());
			String Id = String.valueOf(session.save(enrollEntity));
			if (Id != null && tx != null) {
				enrollDAOResponse.setResCode("0");
				enrollDAOResponse.setResMsg("Success");
				enrollDAOResponse.setEnrollStatus("Enrolled Successfully");
				tx.commit();
			} else {
				enrollDAOResponse.setResCode("100");
				enrollDAOResponse.setResMsg("failed");
				enrollDAOResponse.setEnrollStatus("enrolled failed");
			}
		} catch (HibernateException e) {
			tx.rollback();
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

	public static void main(String[] args) throws FileNotFoundException, IOException {
		CardPaymentsDAOImpl impl = new CardPaymentsDAOImpl();
	/*	EnrollO2DAORequest enrollrequest = new EnrollO2DAORequest();
		enrollrequest.setBackNumber("123456");
		enrollrequest.setBillDate("11-11-2019");
		enrollrequest.setBillPaymentDate("22-11-2019");
		enrollrequest.setfName("verra babu");
		impl.get_Enrolled(enrollrequest);*/
	}
}
