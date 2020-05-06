package cn.itcast.controller;

import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 返回String
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString方法执行了……");
        //模拟从数据库提取数据
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123");
        user.setAge(20);
        //存到request域中
        model.addAttribute("user",user);
        return "success";
    }

    /**
     * void
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid方法执行了……");
       //转发
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        //重定向
//        response.sendRedirect(request.getContextPath()+"/index.jsp");
        //直接响应
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print("你好");
        return;
    }

    /**
     * 返回ModelAndView
     * @param
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        System.out.println("testModelAndView方法执行了……");
        //创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        //模拟从数据库提取数据
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123");
        user.setAge(20);
        //把user存到mv中，也会存到request域中
        mv.addObject("user",user);
        //跳转页面
        mv.setViewName("success");
        return mv;
    }

    /**
     * forward和redirect
     * @param
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("testForwardOrRedirect执行了……");
        //转发
//        return "forward:/WEB-INF/pages/success.jsp";
        //重定向
        return "redirect:/index.jsp";

    }

    /**
     * 模拟异步请求响应
     * RequestBody获取请求体
     * ResponseBody响应请求体
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax执行了……");
        //客户端发送ajax请求，传来的是json字符串，后端把json字符串封装到user对象中
        System.out.println(user);
        //作响应，模拟数据库查询数据
        user.setUsername("haah");
        user.setAge(30);
        user.setPassword("123456");
        //响应，相当于response.getWriter().print()
        return user;
    }
}
