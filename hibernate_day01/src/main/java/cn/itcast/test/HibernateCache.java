package cn.itcast.test;

import cn.itcast.entity.User;
import cn.itcast.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

public class HibernateCache {
    //事务管理标准写法
    @Test
    public void testTx(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        try {
            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            //开启事务
            transaction = session.beginTransaction();
            //添加
            User user = new User();
            user.setUsername("小马");
            user.setPassword("250");
            user.setAddress("美国");

            session.save(user);
            //演示异常
            int a = 10/0;
            //提交事务
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            //事务回滚
            transaction.rollback();
        } finally {
            //关闭资源
//            session.close();
//            sessionFactory.close();
        }
    }


    //测试一级缓存
    @Test
    public void testCache(){
        //1、加载核心配置文件，创建SessionFactory对象
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        //2、创建session对象
        Session session = sessionFactory.openSession();
        //3、开启事务
        Transaction transaction = session.beginTransaction();
        //4、测试
        //根据uid=2查询
        User user1 = (User) session.get(User.class, 2);
        System.out.println(user1);

        User user2 = (User) session.get(User.class,2);
        System.out.println(user2);
        //5、提交事务
        transaction.commit();
        //6、关闭资源
        session.close();
        sessionFactory.close();
    }
}
