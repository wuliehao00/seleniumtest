package com.alibaba.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class SessionFactory_test {
    @Test
    public void fun1(){
        //读取配置文件hibernate.cfg.xml
        Configuration configuration = new Configuration().configure();
        //获取sessionFactory对象
        SessionFactory sf = configuration.buildSessionFactory();
        //获取全新的session
        Session session = sf.openSession();
        //sf.getCurrentSession()    获取当前线程绑定的session对象
    }
}
