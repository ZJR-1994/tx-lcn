package com.demo.serviceb.feign;

import com.demo.serviceb.base.config.FeignConfiguration;
import com.demo.serviceb.feign.impl.ServiceAImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "service-a",fallback = ServiceAImpl.class,configuration= FeignConfiguration.class)
public interface ServiceA {

    @RequestMapping(value = "/test-a/callMe")
    String callServiceA();

    @RequestMapping(value = "/test-a/callMeForLCN")
    String callServiceAForLCN();
}
