package com.demo.serviceb.feign.impl;

import com.codingapi.txlcn.common.exception.TCGlobalContextException;
import com.codingapi.txlcn.common.util.Transactions;
import com.codingapi.txlcn.tc.TCAutoConfiguration;
import com.codingapi.txlcn.tc.core.checking.DTXExceptionHandler;
import com.codingapi.txlcn.tc.support.DTXUserControls;
import com.codingapi.txlcn.tracing.TracingContext;
import com.demo.serviceb.base.exception.BaseException;
import com.demo.serviceb.feign.ServiceA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ServiceAImpl implements ServiceA {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String callServiceA() {
        logger.info("callServiceA error");
        return "callServiceA error";
    }

    @Override
    public String callServiceAForLCN() {

        logger.info("callServiceAForLCN error");
//        DTXUserControls.rollbackGroup(TracingContext.tracing().groupId());

        String groupId = TracingContext.tracing().groupId();
        String applicationId = Transactions.getApplicationId();
        logger.info("groupId : {}",groupId);
        logger.info("applicationId : {}",applicationId);

        String test = null;
        test.equals("");

        return "callServiceAForLCN error";
    }
}
