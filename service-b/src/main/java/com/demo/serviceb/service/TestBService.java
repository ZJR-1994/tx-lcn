package com.demo.serviceb.service;

import com.demo.serviceb.entity.TestB;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Jingran.Zhang
 * @since 2020-05-09
 */
public interface TestBService extends IService<TestB> {

    public String lcnTest();

}
