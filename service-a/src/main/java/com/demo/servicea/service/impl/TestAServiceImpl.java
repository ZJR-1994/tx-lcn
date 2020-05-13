package com.demo.servicea.service.impl;

import com.alibaba.fastjson.JSON;
import com.codingapi.txlcn.common.util.Transactions;
import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tracing.TracingContext;
import com.demo.servicea.entity.TestA;
import com.demo.servicea.feign.ServiceB;
import com.demo.servicea.mapper.TestAMapper;
import com.demo.servicea.service.TestAService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TestAServiceImpl extends ServiceImpl<TestAMapper, TestA> implements TestAService {
    private final Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    ServiceB serviceB;

    @Override
    //事物的参与方
    @LcnTransaction(propagation = DTXPropagation.SUPPORTS)
    @Transactional
    public String LCNTest() {
        String groupId = TracingContext.tracing().groupId();
        String applicationId = Transactions.getApplicationId();
        logger.info("groupId : {}",groupId);
        logger.info("applicationId : {}",applicationId);

        //做一个insert操作
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        TestA a = new TestA();
        a.setTestCol("service-b插入"+uuid);
        save(a);
        String test = null;
        test.equals("");
        System.out.println(list());
        return JSON.toJSONString(list());
    }


}
