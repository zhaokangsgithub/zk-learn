package com.hzzl.demo.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * ClassName:  <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date:   <br/>
 *
 * @author
 * @since JDK 1.6
 */
public class HibernateUtil {

	public static SessionFactory factory;

	static {
		Configuration configure = new Configuration().configure();
		factory = configure.buildSessionFactory();
	}

	public static Session openSession(){

		return factory.openSession();
	}
}
