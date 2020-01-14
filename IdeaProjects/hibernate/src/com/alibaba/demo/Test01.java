package com.alibaba.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;



public class Test01 {
    @Test
    public void fun1(){
        //1读取配置文件
        Configuration conf = new Configuration().configure();
        //根据配置创建Factory
        SessionFactory sessionFactory = conf.buildSessionFactory();
        //通过获得操作数据库的session对象
        Session session = sessionFactory.openSession();
        //操作数据库
        User user = new User();
        user.setName("吴列皓");
        user.setPassword("xxxxxaaaa");
        session.save(user);
        //关闭数据库
        session.close();
        sessionFactory.close();
    }
}
