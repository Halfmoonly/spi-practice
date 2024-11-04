package org.lyflexi.spi;

/**
 * @Author: ly
 * @Date: 2024/1/14 16:43
 */

import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.util.Iterator;
import java.util.ServiceLoader;

@Slf4j
public class SearchDoc {

    public static void main(String[] args) {
        new SearchDoc().searchDocByKeyWord("hello world");
    }

    public void searchDocByKeyWord(String keyWord) {

        ServiceLoader<ISearch> searchServiceLoader = ServiceLoader.load(ISearch.class);

        log.info("for循环方式");
        for (ISearch search : searchServiceLoader) {
            String doc = search.searchDoc(keyWord);
            System.out.println(doc);
        }

        log.info("forEach循环方式");
        // 1. forEach 模式
        searchServiceLoader.forEach(search -> {
            String doc = search.searchDoc(keyWord);
            System.out.println(doc);
        });
        log.info("迭代器模式循环方式");
        // 2. 迭代器模式
        Iterator<ISearch> iterator = searchServiceLoader.iterator();
        while (iterator.hasNext()) {
            ISearch iSearch = iterator.next();
            String doc = iSearch.searchDoc(keyWord);
            System.out.println(doc);
        }
    }
}
