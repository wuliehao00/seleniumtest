package com.alibaba.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * 完成Hibernate工具类
 * 封装配置文件读取操作
 * 封装SessionFactory创建操作
 */
public class HibernateUtils {
    static SessionFactory sf;
    static{
        //读取配置文件hibernate.cfg.xml
        Configuration configuration = new Configuration().configure();
        //获取sessionFactory对象
        sf = configuration.buildSessionFactory();
        //
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                sf.close();
            }
        }));
    }
    public static Session getSession(){

        //获取全新的session
        Session session = sf.openSession();
        return session;

    }

}
