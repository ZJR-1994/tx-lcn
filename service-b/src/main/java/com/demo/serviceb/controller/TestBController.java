package com.demo.serviceb.controller;


import com.alibaba.fastjson.JSON;
import com.demo.serviceb.feign.ServiceA;
import com.demo.serviceb.service.TestBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Jingran.Zhang
 * @since 2020-05-09
 */
@RestController
@RequestMapping("/test-b")
public class TestBController {


    @Autowired
    ServiceA serviceA;

    @Autowired
    TestBService testBService;

    @ResponseBody
    @RequestMapping("/callA")
    public String callServiceA(){
        return serviceA.callServiceA();
    }

    @ResponseBody
    @RequestMapping("/lcnTest")
    public String lcnTest(){
        return testBService.lcnTest();
    }

    @ResponseBody
    @RequestMapping("/query")
    public String query(){
        return JSON.toJSONString(testBService.list());
    }

}
