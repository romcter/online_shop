package com.design.userservice;

import com.design.userservice.rest.feignClient.OrderClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableFeignClients
@EnableWebMvc
@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(UserServiceApplication.class, args);
        OrderClient oc = context.getBean(OrderClient.class);
        System.out.println(oc.getOrders());
    }

}
