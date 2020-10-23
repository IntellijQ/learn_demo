package com.example.demo.service.impl;

import com.example.demo.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author yds
 * @title: TestServiceImpl
 * @description: TODO
 * @date 2020/6/21 11:06
 */
@Service("test11")
public class TestServiceImpl implements TestService {
    @Override
    public void test() {
        System.out.println("test service method");
    }
}
