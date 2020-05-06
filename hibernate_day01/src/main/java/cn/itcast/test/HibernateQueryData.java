package cn.itcast.test;

import cn.itcast.entity.User;
import cn.itcast.utils.HibernateUtils;
import org.hibernate.*;
import org.junit.Test;

import java.util.List;

public class HibernateQueryData {
    //Query对象查询所有记录
    @Test
    public void testQuery(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        try {
            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            //开启事务
            transaction = session.beginTransaction();
            //创建Query对象
            //参数为from+实体类名
            Query query = session.createQuery("from User");
            List<User> list = query.list();
            for (User user:list) {
                System.out.println(user);
            }
            //提交事务
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            //事务回滚
            transaction.rollback();
        } finally {
            //关闭资源
            session.close();
            sessionFactory.close();
        }
    }
}
