package com.hm.tripleimplement.impl;

import com.hm.plugininterface.plugin.PluginInterface;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: liuyanoutsee@outlook.com
 * @Date: 2025/4/15 20:25
 * @Project: spi-practice
 * @Version: 1.0.0
 * @Description:  实现了PluginInterface接口的类。约定必须有个文件定义比如src/main/resources/hm.plugin
 */
public class TripleProvider implements PluginInterface {
    private AtomicInteger counter = new AtomicInteger(0);
    @Override
    public void preHandle() {
        System.out.println("TripleProvider preHandle："+counter.getAndIncrement());
    }
}
