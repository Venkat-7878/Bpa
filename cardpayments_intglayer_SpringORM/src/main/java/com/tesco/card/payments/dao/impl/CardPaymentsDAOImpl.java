/**@CopyRight 2019 tesco ,All Rights are reserved .
 * We should not disclose the information outside ,
   otherwise terms and conditions will apply.
 */
package com.tesco.card.payments.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.tesco.card.payments.dao.CardPaymentsDAO;
import com.tesco.card.payments.dao.beans.CardPaymentsDAOReq;
import com.tesco.card.payments.dao.beans.CardPaymentsDAORes;
import com.tesco.card.payments.dao.beans.EnrollDAOResponse;
import com.tesco.card.payments.dao.beans.EnrollEntity;
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

	private HibernateTemplate hibernateTemplate;

	public CardPaymentsDAOImpl() {
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringContext.xml");
		hibernateTemplate = (HibernateTemplate) context.getBean("hibernateTemplate");
	}

	public EnrollDAOResponse getEnrolled(EnrollO2DAORequest enrollrequest) {

		System.out.println("dao input request" + enrollrequest);
		EnrollDAOResponse enrollDAOResponse = new EnrollDAOResponse();
		EnrollEntity enrollEntity = getEnrollEntity(enrollrequest);
		Long l = (Long) hibernateTemplate.save(enrollEntity);
		if (l != 0) {
			enrollDAOResponse.setResCode("0");
			enrollDAOResponse.setResMsg("Success");
			enrollDAOResponse.setEnrollStatus("Enrolled Successfully");
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

	public EnrollEntity getEnrollEntity(EnrollO2DAORequest enrollrequest) {
		EnrollEntity enrollEntity = new EnrollEntity();
		enrollEntity.setBackNumber(enrollrequest.getBackNumber());
		enrollEntity.setBillDate(enrollrequest.getBillDate());
		enrollEntity.setBillPaymentDate(enrollrequest.getBillPaymentDate());
		enrollEntity.setfName(enrollrequest.getfName());
		enrollEntity.setlName(enrollrequest.getMobileNumber());
		enrollEntity.setSortCode(enrollrequest.getSortCode());
		return enrollEntity;
	}
}
