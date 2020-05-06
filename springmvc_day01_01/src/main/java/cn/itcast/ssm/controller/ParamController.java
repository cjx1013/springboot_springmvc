package cn.itcast.ssm.controller;

import cn.itcast.ssm.domain.Account;
import cn.itcast.ssm.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(path = "/param")
public class ParamController {
    @RequestMapping(path = "/paramTest")
    public String paramTest(String username,String password){
        System.out.println("请求参数绑定测试");
        System.out.println("username:"+username+"password:"+password);
        return "success";
    }

    @RequestMapping(path = "/saveAccount")
    public String saveAccount(Account account){
        System.out.println("请求参数绑定把数据封装到JavaBean的类中");
        System.out.println(account);
        return "success";
    }

    @RequestMapping(path = "/saveUser")
    public String saveUser(User user){
        System.out.println("请求自定义类型转换");
        System.out.println(user);
        return "success";
    }

    @RequestMapping(path = "/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response){
//        想要获取什么就加上什么样的参数
        System.out.println("获取servlet原生API");
        System.out.println(request);
        System.out.println(response);
        return "success";
    }



}
