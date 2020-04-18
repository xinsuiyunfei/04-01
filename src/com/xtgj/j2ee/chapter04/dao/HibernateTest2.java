package com.xtgj.j2ee.chapter04.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.xtgj.j2ee.chapter04.entity.TblUser;

public class HibernateTest2 {

	private SessionFactory sf = new Configuration().configure()
			.buildSessionFactory();

	public static void main(String[] args) throws Exception {

		new HibernateTest2().testLoad();
	}

	public TblUser get(Integer id) {
		Session session = sf.openSession();
		TblUser user = (TblUser) session.get(TblUser.class, id);
		session.close();
		return user;
	}

	public void testLoad() throws Exception {

		TblUser user = this.get(1);
		System.out.println(user.getUname() + "," + user.getUpass());
	}

}

