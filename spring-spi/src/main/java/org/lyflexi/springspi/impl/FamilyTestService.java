package org.lyflexi.springspi.impl;

import org.lyflexi.springspi.MyTestService;

/**
 * @Description:
 * @Author: lyflexi
 * @project: spi-practice
 * @Date: 2024/11/4 10:37
 */
public class FamilyTestService implements MyTestService {
    public FamilyTestService(){
        System.out.println("FamilyTestService");
    }
    public void printMylife() {
        System.out.println("我的家庭");
    }
}