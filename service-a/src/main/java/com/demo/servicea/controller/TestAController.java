package com.demo.servicea.controller;


import com.alibaba.fastjson.JSON;
import com.demo.servicea.service.TestAService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/test-a")
public class TestAController {

    @Autowired
    TestAService testAService;

    @RequestMapping("/callMe")
    @ResponseBody
    public String callMe(){
        return JSON.toJSONString(testAService.list());
    }

    @RequestMapping("/callMeForLCN")
    @ResponseBody
    public String callMeForLCN(){
        return JSON.toJSONString(testAService.LCNTest());
    }

}
