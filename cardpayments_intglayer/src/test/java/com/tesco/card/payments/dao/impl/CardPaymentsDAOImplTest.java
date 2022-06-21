package com.tesco.card.payments.dao.impl;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.tesco.card.payments.dao.beans.EnrollDAORequest;
import com.tesco.card.payments.dao.beans.EnrollDAOResponse;
import com.tesco.card.payments.dao.beans.EnrollO2DAORequest;


@RunWith(PowerMockRunner.class)
@PrepareForTest({CardPaymentsDAOImpl.class,Connection.class,CallableStatement.class,ResultSet.class})
public class CardPaymentsDAOImplTest {
	CardPaymentsDAOImpl daoImpl;
	Connection mockcon;
	CallableStatement mockCstmt;
	ResultSet mockRs;
	@Before
	public void setUp() throws Exception {
		daoImpl =new CardPaymentsDAOImpl();
		//Stubbing
		PowerMockito.mockStatic(DriverManager.class);
		mockcon= PowerMockito.mock(Connection.class);
		mockCstmt =PowerMockito.mock(CallableStatement.class);
		mockRs =PowerMockito.mock(ResultSet.class);
		
		PowerMockito.when(DriverManager.getConnection(Matchers.anyString(), Matchers.anyString(), Matchers.anyString())).thenReturn(mockcon);
		PowerMockito.when(mockcon.prepareCall(Matchers.anyString())).thenReturn(mockCstmt);
		PowerMockito.when(mockCstmt.execute()).thenReturn(true);
		PowerMockito.when(mockCstmt.executeQuery()).thenReturn(mockRs);
		
	}

	@After
	public void tearDown() throws Exception {
		daoImpl=null;
	}

	@Test
	public void testGet_Enrolled() throws SQLException, FileNotFoundException, IOException {
		System.setProperty("env","dev");
		EnrollO2DAORequest daoRequest =new EnrollO2DAORequest();
		/*daoRequest.setClientId("web");
		daoRequest.setChannelId("online");
		daoRequest.setCardNum("9299978595");
		daoRequest.setCvv("544");
		daoRequest.setNameOnCard("Sriman");
		daoRequest.setExpDate("20-11-2025");
		daoRequest.setMobilenumber("7893219190");*/
		
		//Expectations
		PowerMockito.when(mockRs.getString(1)).thenReturn("web");
		PowerMockito.when(mockCstmt.getString(9)).thenReturn("0");
		PowerMockito.when(mockCstmt.getString(10)).thenReturn("success");
		
		
		EnrollDAOResponse enrollDAOResponse =daoImpl.get_Enrolled(daoRequest);
		System.out.println(enrollDAOResponse);
		//verify
		assertNotNull(enrollDAOResponse);
		assertEquals("0",enrollDAOResponse.getResCode());
		assertEquals("success",enrollDAOResponse.getResMsg());
		assertEquals("web",mockRs.getString(1));
	}

}
