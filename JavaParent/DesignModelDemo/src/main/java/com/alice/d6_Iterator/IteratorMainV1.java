package com.alice.d6_Iterator;

import cn.hutool.core.util.RandomUtil;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 迭代器
 * @author liusc
 * 2020-7-17 14:52:36
 */
public class IteratorMainV1 {
    public static void main(String[] args) {

        ArrayList<String> lists = Lists.newArrayList();

        LinkedList<String> objects = Lists.newLinkedList();

        for (int i = 0; i < 5; i++) {
            String s = RandomUtil.randomString(5);
            objects.add(s);
            System.out.println(s);
        }

        System.out.println("===========");

        // 接口的调用方式
        Iterator<String> stringIterator = objects.iterator();
        while (stringIterator.hasNext()) {
            String str = stringIterator.next();
            System.out.println(str);
        }
    }
}
