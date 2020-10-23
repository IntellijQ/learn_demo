package com.example.demo.controller;

import com.example.demo.SpringBeanUtil;
import com.example.demo.common.ResultT;
import com.example.demo.dto.UserInfoVO;
import com.example.demo.service.TestService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yds
 * @title: DemoController
 * @description: 测试api
 * @date 2020/5/29 19:02
 */
@Api(value = "用户服务",tags = "用户服务")
@ApiSort(1)
@RequestMapping("/api/demo/user")
@RestController
public class UserController {

    @PostMapping("/listUser")
    @ApiOperation(value = "获取用户列表",notes = "获取用户列表")
    @ApiOperationSupport(order=1)
    public ResultT<List<UserInfoVO>> listUser(){
        TestService test11 = (TestService)SpringBeanUtil.getBean("test11");
        test11.test();
        ResultT resultT = new ResultT();
        return resultT.buildSuccess(null);
    }

}
