package com.demo.servicea.service;

import com.demo.servicea.entity.TestA;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Jingran.Zhang
 * @since 2020-05-09
 */
public interface TestAService extends IService<TestA> {

    public String LCNTest();

}
