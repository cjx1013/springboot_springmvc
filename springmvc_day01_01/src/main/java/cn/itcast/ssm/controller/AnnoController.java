package cn.itcast.ssm.controller;

import cn.itcast.ssm.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping(path = "/anno")
@SessionAttributes(value = "msg")//将msg=哈哈存入session域中
public class AnnoController {

    @RequestMapping(path = "/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name") String username) {
        System.out.println("执行了……");
        System.out.println(username);
        return "success";
    }

    /**
     * 获取请求体
     */
    @RequestMapping(path = "/testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println("执行了……");
        System.out.println(body);
        return "success";
    }

    /**
     * PathVariable注解
     */
    @RequestMapping(path = "/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name = "sid") String id) {
        System.out.println("执行了……");
        System.out.println(id);
        return "success";
    }

    /**
     * 获取请求头的值
     * 例如获取Accpet的请求头的值
     */
    @RequestMapping(path = "/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String header) {
        System.out.println("执行了……");
        System.out.println(header);
        return "success";
    }

    /**
     * 获取Cookie的值
     */
    @RequestMapping(path = "/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue) {
        System.out.println("执行了……");
        System.out.println(cookieValue);
        return "success";
    }

    /**
     * ModelAttribute注解
     * 带有ModelAttribute注解的方法会被先执行，有返回值和无返回值两种形式
     */
    @RequestMapping(path = "/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User user) {
        System.out.println("执行了……");
        System.out.println(user);
        return "success";
    }

    //无返回值
    @ModelAttribute
    public void showUser(String uname, Map<String,User> map) {
        System.out.println("showUser执行了……");
//        模拟数据库根据id返回user
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        map.put("abc",user);
    }

    //有返回值
   /* @ModelAttribute
    public User showUser(String uname) {
        System.out.println("showUser执行了……");
//        模拟数据库根据id返回user
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        return user;
    }*/

    /**
     * SessionAttribute注解
     */
    @RequestMapping(path = "/testSessionAttributes")
    public String testSessionAttributes(Model model) {
        //底层会存储到request域中
        System.out.println("执行了……");
        model.addAttribute("msg","哈哈");
        return "success";
    }

    /**
     * SessionAttribute注解
     * 获取session中的值
     */
    @RequestMapping(path = "/getSessionAttributes")
    public String setSessionAttributes(ModelMap modelMap) {
        System.out.println("执行了……");
        String msg = (String) modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    /**
     * SessionAttribute注解
     * 删除session中的值
     */
    @RequestMapping(path = "/deleteSessionAttributes")
    public String deleteSessionAttributes(SessionStatus status) {
        System.out.println("执行了……");
        status.setComplete();
        return "success";
    }
}
