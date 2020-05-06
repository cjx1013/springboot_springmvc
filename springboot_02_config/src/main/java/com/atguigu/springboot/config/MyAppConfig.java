package com.atguigu.springboot.config;

import com.atguigu.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration指明当前类是一个配置类，就是来替代之前的spring配置文件
@Configuration
public class MyAppConfig {
    //@Bean：将方法的返回值添加到容器中，容器中这个组件默认的id就是方法名
    @Bean
    public HelloService helloService(){
        System.out.println("配置类@bean给容器添加组件了");
        return new HelloService();
    }

}
