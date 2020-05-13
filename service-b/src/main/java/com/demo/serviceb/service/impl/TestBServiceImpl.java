package com.demo.serviceb.service.impl;

import com.alibaba.fastjson.JSON;
import com.codingapi.txlcn.logger.DefaultTxLogger;
import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tc.aspect.DTXInfo;
import com.codingapi.txlcn.tc.support.DTXUserControls;
import com.codingapi.txlcn.tc.txmsg.transaction.LcnNotifiedUnitService;
import com.codingapi.txlcn.tracing.TracingContext;
import com.demo.serviceb.entity.TestB;
import com.demo.serviceb.feign.ServiceA;
import com.demo.serviceb.mapper.TestBMapper;
import com.demo.serviceb.service.TestBService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jingran.Zhang
 * @since 2020-05-09
 */
@Service
public class TestBServiceImpl extends ServiceImpl<TestBMapper, TestB> implements TestBService {


    @Autowired
    ServiceA serviceA;

    @Override
    @LcnTransaction(propagation = DTXPropagation.REQUIRED) //分布式事务注解
    @Transactional //本地事务注解
    public String lcnTest() {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);

        TestB b = new TestB();
        b.setTestCol("service-b插入"+uuid);
        save(b);
        System.out.println(list());
        serviceA.callServiceAForLCN();
//        DTXUserControls.rollbackGroup(TracingContext.tracing().groupId());


        return JSON.toJSONString(list());
    }
}
