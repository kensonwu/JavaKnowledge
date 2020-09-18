package com.kenson.generic1;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

/**
 * @description: 在非泛型类中定义泛型方法：
 * 通过在方法的返回类型前面用<T>
 * @author: Kenson
 * @date: 2020/9/15
 */
public class GenericMethod2<T> {
    // 泛型方法
    public static <T> T test(T t) {
        System.out.println(t);
        return t;
    }

    public static <T extends List> void test(T t) {
        System.out.println(t);
        t.add("aaa");
    }

    public static <T> Integer test2(T t) {
        System.out.println(t);
        return 0;
    }

    public static <E> void printAll(E... es) {
        for (E e : es) {
            System.out.println(e);
        }
    }

}
