package com.xtgj.j2ee.chapter04.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xtgj.j2ee.chapter04.entity.TblUser;



public class HibernateTest1 {
	public static void main(String[] args) throws Exception{
		// 1.读取配置文件
		Configuration conf = new Configuration().configure();
		// 2.创建SessionFactory
		SessionFactory sf = conf.buildSessionFactory();
		// 3.打开session
		Session session = sf.openSession();
		Transaction tx = null;
		try {
			// 4. 开始一个事物
			tx = session.beginTransaction();
			// 5. 持久化操作
			TblUser user = new TblUser();
			user.setUname("Hibernate user");
			user.setUpass("password");
			session.save(user);
			// 6. 提交事物
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			// 7. 关闭Session
			session.close();
		}
	}
}

