package com.hm.bizapp;

import com.hm.plugininterface.plugin.PluginInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Objects;

/**
 * @Author: liuyanoutsee@outlook.com
 * @Date: 2025/4/15 20:35
 * @Project: spi-practice
 * @Version: 1.0.0
 * @Description:
 */
@RestController("/test")
public class PluginController {
    PluginInterface pluginInterface;

    /**
     * 多次请求返回：
     *
     * TripleProvider preHandle：0
     * TripleProvider preHandle：1
     * TripleProvider preHandle：2
     * TripleProvider preHandle：3
     * TripleProvider preHandle：4
     * @return
     */
    @GetMapping("/main")
    public String plugin() {
        if (Objects.nonNull(pluginInterface)) {
            pluginInterface.preHandle();
        }
        return "plugin";
    }

    /**
     * invoke plugin implements
     * <p>
     * 先将triple-implement打包放在biz-app根目录
     * <p>
     * http://127.0.0.1:8080/obtainPlugin/triple-implement-0.0.1-SNAPSHOT.jar
     *
     * @param path
     * @return
     * JAR 文件路径：E:\github\spi-practice\spi-classloader-facade\biz-app\triple-implement-0.0.1-SNAPSHOT.jar
     * JAR 文件是否存在：true
     */
    @GetMapping("/obtainPlugin/{path}")
    public String plugin(@PathVariable String path) {
        path = "spi-classloader-facade//biz-app//"+path;
        //默认会拼接上相对根目录的相对路径：E:\github\spi-practice
        File file = new File(path);
        System.out.println("JAR 文件路径：" + file.getAbsolutePath());
        System.out.println("JAR 文件是否存在：" + file.exists());
        //jar包加载器
        try (URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{file.toPath().toUri().toURL()});
             //加载jar包中的约定文件hm.plugin
             InputStream resourceAsStream = urlClassLoader.getResourceAsStream("hm.plugin");) {
            String pluginFullClassName = new String(resourceAsStream.readAllBytes());
            Class<?> aClass = urlClassLoader.loadClass(pluginFullClassName);
            Constructor<?> constructor = aClass.getConstructor();
            pluginInterface = (PluginInterface) constructor.newInstance();
            return "plugin加载成功：" + aClass.getName();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
