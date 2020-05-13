package com.demo.servicea.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "service-b")
public interface ServiceB {

    @RequestMapping(value = "/test-b/query")
    String queryServiceB();


}
