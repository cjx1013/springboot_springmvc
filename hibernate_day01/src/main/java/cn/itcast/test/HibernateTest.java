package cn.itcast.test;

import cn.itcast.entity.User;
import cn.itcast.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

public class HibernateTest {
    @Test
    public void testAdd() {
        //1、加载hibernate核心配置文件
        //到src下找到hibernate.cfg.xml
//        Configuration configuration = new Configuration();
//        configuration.configure();

        //2、创建SessionFactory对象
        //读取核心配置文件内容，创建SessionFactory对象
        //在过程中，根据映射关系，在数据库配置中把表创建
//        SessionFactory sessionFactory = configuration.buildSessionFactory();
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        //3、使用SessionFactory创建Session对象
        //类似于连接
        Session session = sessionFactory.openSession();

        //4、开启事务
        Transaction transaction = session.beginTransaction();

        //5、写具体逻辑，进行crud操作
        //实现增加功能
        User user = new User();
        user.setUsername("王五");
        user.setPassword("456");
        user.setAddress("北京");
        session.save(user);

        //6、提交事务
        transaction.commit();

        //7、关闭资源
        session.close();
        sessionFactory.close();
    }

    @Test
    public void testGet() {
        //1、加载核心配置文件，创建SessionFactory对象
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        //2、创建session对象
        Session session = sessionFactory.openSession();
        //3、开启事务
        Transaction transaction = session.beginTransaction();
        //4、根据id查询
        User user = (User) session.get(User.class, 1);
        System.out.println(user);
        //5、提交事务
        transaction.commit();
        //6、关闭资源
        session.close();
        sessionFactory.close();
    }

    @Test
    public void testUpdate() {
        //1、加载核心配置文件，创建SessionFactory对象
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        //2、创建session对象
        Session session = sessionFactory.openSession();
        //3、开启事务
        Transaction transaction = session.beginTransaction();
        //4、测试update
        // 根据id查询
        User user = (User) session.get(User.class, 1);
        //返回的user对象中设置修改之后的值
        user.setUsername("王二麻子");
        //调用session的update方法
        //执行过程：先到user对象uid，根据uid进行修改
        session.update(user);
        //5、提交事务
        transaction.commit();
        //6、关闭资源
        session.close();
        sessionFactory.close();
    }

    @Test
    public void testDelete() {
        //1、加载核心配置文件，创建SessionFactory对象
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        //2、创建session对象
        Session session = sessionFactory.openSession();
        //3、开启事务
        Transaction transaction = session.beginTransaction();
        //4、测试delete
        // 第一种：根据id查询，再删除
//        User user = (User) session.get(User.class, 1);
//        session.delete(user);
        //第二种：
        User user = new User();
        user.setUid(1);
        session.delete(user);
        //5、提交事务
        transaction.commit();
        //6、关闭资源
        session.close();
        sessionFactory.close();
    }

    @Test
    public void testSaveOrUpdate() {
        //1、加载核心配置文件，创建SessionFactory对象
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        //2、创建session对象
        Session session = sessionFactory.openSession();
        //3、开启事务
        Transaction transaction = session.beginTransaction();
        //4、实现功能
        //(1)瞬时态（无id，与session无关联），做添加操作
//        User user = new User();
//        user.setUsername("tom");
//        user.setPassword("1314");
//        user.setAddress("武汉");
//        session.saveOrUpdate(user);
        //(2)持久态（无id，与session有关联），做修改操作
//            User user = (User) session.get(User.class,2);
//            session.saveOrUpdate(user);
        //（3）托管态（有id，与session无关联），做修改操作
        User user = new User();
        user.setUid(2);
        user.setUsername("anna");
        user.setPassword("520");
        user.setAddress("东北");
        session.saveOrUpdate(user);
        //5、提交事务
        transaction.commit();
        //6、关闭资源
        session.close();
        sessionFactory.close();
    }
}
