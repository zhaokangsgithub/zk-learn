package com.hzzl.demo.frame.hibernate;

import org.junit.jupiter.api.Test;

/**
 * ClassName:  <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date:   <br/>
 *
 * @author
 * @since JDK 1.6
 */

public class HibernateTest {
	@Test
	public void test1(){
		User user = new User();
		user.setName("zhangsan");
		user.setHeadUrl("11");
		user.setSalt("1000");
		user.setPassword("111111");
		UserDao.save(user);
	}

	@Test
	public void test2(){

		UserDao.query();
	}

}
