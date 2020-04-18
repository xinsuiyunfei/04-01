package com.xiaowang.lianxi;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SelStudy{
    public static void main(String[]args){
        Configuration conf =new Configuration().configure();
        SessionFactory sf= conf.buildSessionFactory();
        Session se= sf.openSession();

        StudyEntity sty=(StudyEntity)se.get(StudyEntity.class,2);
        System.out.println(sty.getName()+" "+sty.getLesson());

        sty.setLesson("paython");
        sty.setName("spring");

        Transaction tx=se.beginTransaction();
        se.update(sty);
        tx.commit();;

        tx=se.beginTransaction();
        se.delete(sty);
        tx.commit();
        sty=(StudyEntity)se.get(StudyEntity.class,2);
        System.out.println(sty.getName()+" "+sty.getLesson());

        se.close();
    }
}