package com.alibaba.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class Transcation_test {

    @Test
    public void fun1(){
        Configuration configuration = new Configuration().configure();

        SessionFactory sf = configuration.buildSessionFactory();

        Session session = sf.openSession();

        //事务关闭时,会自动把与当前线程关联的session关闭并删除
        //开启事务
        Transaction ts = session.beginTransaction();


        //提交事务
        ts.commit();

        //回滚
        //ts.rollback();


        session.close();
        sf.close();
    }
}
