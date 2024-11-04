package org.lyflexi.spipractice.impl;

import org.lyflexi.spipractice.Robot;

/**
 * @Description:
 * @Author: lyflexi
 * @project: spi-practice
 * @Date: 2024/11/4 10:56
 */
public class Bumblebee implements Robot {
    @Override
    public void sayHello() {
        System.out.println("Bumblebee...");
    }
}
