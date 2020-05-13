package com.demo.serviceb;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import com.demo.serviceb.base.config.FeignConfiguration;
import com.demo.serviceb.base.config.FeignHystrixConcurrencyStrategy;
import feign.RequestInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextListener;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.demo.serviceb.mapper")
@EnableDistributedTransaction
public class ServiceBApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceBApplication.class, args);
    }

    /**
     * RequestContextListener监听器
     * @return
     */
    @Bean
    public RequestContextListener requestContextListenerBean() {
        return new RequestContextListener();
    }

    @Bean
    public FeignHystrixConcurrencyStrategy feignHystrixConcurrencyStrategy() {
        return new FeignHystrixConcurrencyStrategy();
    }
}
