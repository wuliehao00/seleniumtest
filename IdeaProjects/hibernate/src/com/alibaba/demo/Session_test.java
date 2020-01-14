package com.alibaba.demo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class Session_test {
    @Test
    public void fun2(){
        Configuration configuration = new Configuration().configure();

        SessionFactory sf = configuration.buildSessionFactory();

        Session session = sf.openSession();

        //增加数据库记录
        User user = new User();
        user.setName("聆芸");
        user.setPassword("1111111");

        session.save(user);

        //提交事务
        Transaction ts = session.beginTransaction();
        //查询数据
        User u = (User)session.get(User.class, 4);
        //System.out.println(u+"%%%%%%%%%");
        /**
         * get 方法被调用立马发送sql语句查询
         * load 调用时并没有查询数据库,当我们需要使用该对象的时候,才发送sql语句查询
         */
        //User user1 =(User)session.load(User.class,4);

        //System.out.println(user1+"---------------->");
        //修改数据
       // user1.setName("雨停");
        //session.update(user1);

        //提交事务
        ts.commit();

        //删除数据
        //session.delete(u);

        System.out.println("查询所有的list集合");
        //查询所有集合
        Query query = session.createQuery("from User");
        //分页
        query.setFirstResult(2);
        query.setMaxResults(4);
        System.out.println(query.list());
        //关闭资源
        session.close();


        sf.close();
    }
}
