/**
 * 
 */
package com.tesco.card.payments.dao.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author @VeeraBabu
 *
 *         Jul 3, 2019
 */
public class SessionFactoryUtility {

	private static SessionFactory sessionfactory = null;

	public static SessionFactory buildSessionFactory() {
		// TODO Auto-generated method stub
		try {
			if (sessionfactory == null) {
				Configuration config = new Configuration();
				config.configure("hibernate.cfg.xml");
				StandardServiceRegistryBuilder serviceregisbuilder = new StandardServiceRegistryBuilder();
				serviceregisbuilder.applySettings(config.getProperties());
				System.out.println("ser " + serviceregisbuilder);
				ServiceRegistry serviceRegistry = serviceregisbuilder.build();
				System.out.println("ser " + serviceRegistry);
				sessionfactory = config.buildSessionFactory(serviceRegistry);
				System.out.println("ser " + sessionfactory);

				/*
				 * StandardServiceRegistry ssr= new
				 * StandardServiceRegistryBuilder().configure(
				 * "/hibernate.cfg.xml").build(); Metadata meta=new
				 * MetadataSources(ssr).getMetadataBuilder().build();
				 * sessionfactory=meta.getSessionFactoryBuilder().build();
				 */
				/*
				 * Configuration configuration=new
				 * Configuration().configure("/hibernate.cfg.xml");
				 * ServiceRegistry serviceRegistry = new
				 * StandardServiceRegistryBuilder()
				 * .applySettings(configuration.getProperties()).build();
				 * sessionfactory = configuration.buildSessionFactory();
				 */

			}

			return sessionfactory;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return buildSessionFactory();
	}

	public static void shutdown() {
		getSessionFactory().close();
	}

}
