package org.lyflexi.spipractice;

import org.apache.coyote.http11.filters.VoidInputFilter;
import org.apache.dubbo.common.extension.SPI;

/**
 * @Description:
 * @Author: lyflexi
 * @project: spi-practice
 * @Date: 2024/11/4 10:50
 */
@SPI
public interface Robot {
    public void sayHello();
}
