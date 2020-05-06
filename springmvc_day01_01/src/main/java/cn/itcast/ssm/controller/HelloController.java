package cn.itcast.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/user")
public class HelloController {

    @RequestMapping(value="/hello")
    public String Hello(){
        System.out.println("Hello,springmvc");
        return "success";
    }

    @RequestMapping(path = "/requestMappingTest",
            method = RequestMethod.POST,params = {"username"},
            headers = {"Accept"}
    )
    public String requestMappingTest(){
        System.out.println("RequestMapping注解测试");
        return "success";
    }


}
