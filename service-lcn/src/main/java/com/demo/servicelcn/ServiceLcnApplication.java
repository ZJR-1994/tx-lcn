package com.demo.servicelcn;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableTransactionManagerServer
public class ServiceLcnApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceLcnApplication.class, args);
    }

}
