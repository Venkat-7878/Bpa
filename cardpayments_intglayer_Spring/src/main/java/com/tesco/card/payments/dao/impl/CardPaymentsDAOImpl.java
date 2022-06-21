/**@CopyRight 2019 tesco ,All Rights are reserved .
 * We should not disclose the information outside ,
   otherwise terms and conditions will apply.
 */
package com.tesco.card.payments.dao.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.object.StoredProcedure;

import com.tesco.card.payments.dao.CardPaymentsDAO;
import com.tesco.card.payments.dao.beans.CardPaymentsDAOReq;
import com.tesco.card.payments.dao.beans.CardPaymentsDAORes;
import com.tesco.card.payments.dao.beans.EnrollDAORequest;
import com.tesco.card.payments.dao.beans.EnrollDAOResponse;
import com.tesco.card.payments.exception.BuisnessException;
import com.tesco.card.payments.exception.SystemException;



/**
 * @author : Venkatesh
 * @Date :Apr 30, 2019
 * @Description:
 * 
 */
public class CardPaymentsDAOImpl extends StoredProcedure implements CardPaymentsDAO {
	private Logger logger=Logger.getLogger(CardPaymentsDAOImpl.class);
	public CardPaymentsDAOImpl() throws FileNotFoundException, IOException {
		super(prepareJdbcTemplate(), "Get_Enrollment");
		registerSPParams();
	}

	private static JdbcTemplate prepareJdbcTemplate() throws FileNotFoundException, IOException {
		
		//loading properties from respective db environments
				String env =System.getProperty("env");
				String file="enroll_"+env+"_db.properties";
				System.out.println("loading db properties from:"+file+" file");
				Properties props=new Properties();
				props.load(new FileInputStream("D:\\stsoft\\64bit\\eclipse-jee-neon-3-win32-x86_64\\eclipse\\RTP4510\\RTP4510\\bpa\\branches\\cardpayments_intglayer\\src\\main\\resources\\Properties\\"+file));
				
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(props.getProperty("_driver"));
		ds.setUrl(props.getProperty("_url"));
		ds.setUsername(props.getProperty("_uname"));
		ds.setPassword(props.getProperty("_password"));
		JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
		return jdbcTemplate;
	}

	// It verifies the store procedure params against their datatypes
	private void registerSPParams() {
		System.out.println("entered into sp param");
		// declareParameter(new SqlReturnResultSet("enrollResultSet"this));
		// Input params
		declareParameter(new SqlParameter("Client_Id", Types.VARCHAR));
		declareParameter(new SqlParameter("Channel_Id", Types.VARCHAR));
		declareParameter(new SqlParameter("Card_Num", Types.VARCHAR));
		declareParameter(new SqlParameter("Cvv_Num", Types.VARCHAR));
		declareParameter(new SqlParameter("Expiry_Date", Types.VARCHAR));
		declareParameter(new SqlParameter("Name_On_Card", Types.VARCHAR));
		declareParameter(new SqlParameter("Mobile_Num", Types.VARCHAR));
		// output params
		declareParameter(new SqlOutParameter("RESPCODE", Types.VARCHAR));
		declareParameter(new SqlOutParameter("RESPMSG", Types.VARCHAR));
		compile();
	}

	public EnrollDAOResponse get_Enrolled(EnrollDAORequest enrollrequest) throws SQLException, ClassNotFoundException{
		EnrollDAOResponse enrollDAOResponse = new EnrollDAOResponse();
		System.out.println("entered into get enrolled");
		try {
			// prepare the store procedure request

			Map<String, Object> inputmap = new HashMap<String, Object>();
			inputmap.put("Client_Id", enrollrequest.getClientId());
			inputmap.put("Channel_Id", enrollrequest.getChannelId());
			inputmap.put("Card_Num", enrollrequest.getCardNum());
			inputmap.put("Cvv_Num", enrollrequest.getCvv());
			inputmap.put("Expiry_Date", enrollrequest.getExpDate());
			inputmap.put("Name_On_Card", enrollrequest.getNameOnCard());
			inputmap.put("Mobile_Num", enrollrequest.getMobilenumber());

			// execute the stored procedure
			Map<String, Object> resmap = super.execute(inputmap);
			String dbRespCode = null;
			String dbRespMsg = null;
			// get the output params
			if (resmap != null) {
				dbRespCode = resmap.get("RESPCODE").toString();
				dbRespMsg = resmap.get("RESPMSG").toString();
			}
			if ("0".equals(dbRespCode)) {
				enrollDAOResponse.setResCode(dbRespCode);
				enrollDAOResponse.setResMsg(dbRespMsg);
			} else if ("100".equals(dbRespCode) || "101".equals(dbRespCode) || "102".equals(dbRespCode)) {
				throw new BuisnessException(dbRespCode, dbRespMsg);
			} else if ("200".equals(dbRespCode) || "201".equals(dbRespCode) || "202".equals(dbRespCode)) {
				throw new SystemException(dbRespCode, dbRespMsg);
			} else {
				throw new SystemException("8888", "unknown error from db");
			}
		} catch (SystemException e) {
			System.out.println(e.getRespCode());
			System.out.println(e.getRespMsg());
			e.printStackTrace();
		} catch (BuisnessException e) {
			System.out.println(e.getRespCode());
			System.out.println(e.getRespMsg());
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

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.setProperty("env","dev");
		CardPaymentsDAOImpl impl = new CardPaymentsDAOImpl();
		EnrollDAORequest enrollrequest = new EnrollDAORequest();
		enrollrequest.setClientId("web");
		enrollrequest.setChannelId("online");
		enrollrequest.setCardNum("987654321");
		enrollrequest.setCvv("456");
		enrollrequest.setExpDate("11-11-2050");
		enrollrequest.setNameOnCard("Venkatesh");
		enrollrequest.setMobilenumber("8522011220");
		EnrollDAOResponse enrollDAOResponse = new EnrollDAOResponse();
		
		enrollDAOResponse =impl.get_Enrolled(enrollrequest);
			System.out.println(enrollDAOResponse);
		
	}
}
