package com.design.eurecaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EuricaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EuricaServerApplication.class, args);
    }

}
