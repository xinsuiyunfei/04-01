package com.xtgj.j2ee.chapter04.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xtgj.j2ee.chapter04.entity.TblUser;

public class HibernateTest3 {

	private SessionFactory sf = new Configuration().configure()
			.buildSessionFactory();

	public static void main(String[] args) throws Exception {

		new HibernateTest3().testUpdate();
	}

	public TblUser get(Integer id) {
		Session session = sf.openSession();
		TblUser user = (TblUser) session.get(TblUser.class, id);
		session.close();
		return user;
	}

	public void testUpdate() throws Exception {

		Session session = sf.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction(); // 增删改操作一定能够要开启事务
			TblUser user = this.get(1); // 先加载，再修改
			user.setUname("new Name");
			session.update(user); // 执行修改的代码
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}
}

