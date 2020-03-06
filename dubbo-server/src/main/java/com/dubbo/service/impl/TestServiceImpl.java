package com.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.service.TestService;

@Service(version = "1.0.0",timeout = 3000)
public class TestServiceImpl implements TestService {

    @Override
    public void testDubbo() {
        System.out.println("调用了dubbo测试接口");
    }
}
