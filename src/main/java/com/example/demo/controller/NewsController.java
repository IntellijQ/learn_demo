package com.example.demo.controller;

import com.example.demo.common.ResultT;
import com.example.demo.dto.NewsInfoVO;
import com.example.demo.param.NewsPageParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yds
 * @title: DemoController
 * @description: 测试api
 * @date 2020/5/29 19:02
 */
@Api(value = "新闻服务",tags = "新闻服务")
@ApiSort(2)
@RequestMapping("/api/demo/new")
@RestController
public class NewsController {

    @PostMapping("/listNews")
    @ApiOperation(value = "获取新闻列表",notes = "获取新闻列表")
    @ApiOperationSupport(order=1)
    public ResultT<List<NewsInfoVO>> listNews(@RequestBody NewsPageParam newsPageParam){
        ResultT resultT = new ResultT();
        return resultT.buildSuccess(null);
    }

    @PostMapping("/getNewsInfo")
    @ApiOperation(value = "获取新闻信息",notes = "获取新闻信息")
    @ApiOperationSupport(order=2)
    public ResultT<NewsInfoVO> getNewsInfo(String newsId){
        ResultT resultT = new ResultT();
        return resultT.buildSuccess(null);
    }

//
//    贷款信息：
//        贷款额度：200000元
//        贷款周期：36个月
//        贷款月费率：0.85%
//        还款方式：等额本息
//        还款月本金：5556元
//
//    扣款明细：
//        提前贷款手续费：200000*4.8%=9600元
//        提前利息费用：200000*0.4%*36=28880元
//
//    实际到手额度：
//        扣除后的本金：161600元
//
//    捷捷贷的计息规则：（他们一直按照我20w的本金算）
//        到期还款总利息：200000*0.45%*36=32400元
//        到期还款本息总额：200000+32400=232400元
//
//
//    我这边总结了一下我实际支付的金额：
//            9600+28880+（232400-161600）=109200元
//
//
//
//
//




}
