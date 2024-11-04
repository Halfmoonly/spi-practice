package org.lyflexi.springspi.impl;

import org.lyflexi.springspi.MyTestService;

/**
 * @Description:
 * @Author: lyflexi
 * @project: spi-practice
 * @Date: 2024/11/4 10:37
 */
public class WorkTestService implements MyTestService {
    public WorkTestService(){
        System.out.println("WorkTestService");
    }
    public void printMylife() {
        System.out.println("我的工作");
    }
}