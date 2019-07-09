package com.hzzl.demo.frame.hibernate;

import com.hzzl.demo.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
public class UserDao {
	/**
	 * 保存一个客户实体
	 * @param c
	 */
	public static void save(User c){
		//加载主配置文件(hibernate.cfg.xml)
		Configuration cfg=new Configuration().configure();
		//创建SessionFactory对象
		SessionFactory factory=cfg.buildSessionFactory();
		//使用SessionFactory生产一个Session
		Session session=factory.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//保存客户
		session.save(c);
		//提交事务
		tx.commit();
		//释放资源
		session.close();
		factory.close();
	}

	public static void query(){
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		/*User user = session.get(User.class, "1");
		System.out.println(user);*/
		Query query = session.createQuery("select count(1) from User where id = :id and name = :name");
		query.setString("id","1");
		query.setString("name","22");
//		List list = query.list();
		long o = (Long)query.uniqueResult();
		System.out.println(o+"条数据");
		tx.commit();//提交事务。事务提交后会自动关闭Session对象
	}

}
