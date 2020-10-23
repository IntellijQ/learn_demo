package com.yds.gof.zerenlian.check;

import org.hibernate.validator.internal.util.ReflectionHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yds
 * @title: OpenCardHandlerRegister
 * @description: 开卡流程注册中心
 * @date 2020/6/19 16:20
 */
public class OpenCardHandlerRegister {
    List<OpenCardAbstractHandler> handlerList;

    public void register(Class<? extends OpenCardAbstractHandler> clazz) throws IllegalAccessException, InstantiationException {
        OpenCardAbstractHandler openCardAbstractHandler = clazz.newInstance();
        handlerList.add(openCardAbstractHandler);
    }

    public void initOpenCardHandler() throws InstantiationException, IllegalAccessException {
        register(CheckCardInfoHandler.class);
        register(CheckUserMemberInfoHandler.class);
        register(PayMemberHandler.class);

        for (OpenCardAbstractHandler inte : handlerList) {//打印
            inte.handleReuquest();
        }
    }
}
