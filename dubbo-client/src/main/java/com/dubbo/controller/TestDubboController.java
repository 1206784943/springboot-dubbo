package com.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbo.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestDubboController {

    @Reference(version = "1.0.0", timeout = 300)
    private TestService testService;

    @RequestMapping("/testdubbo")
    @ResponseBody
    public String testdubbo() {
        testService.testDubbo();
        return "dubbo test success";
    }

}
