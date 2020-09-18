package com.kenson.generic1;

/**
 * @description:
 * @author: Kenson
 * @date: 2020/9/15
 */
public interface GenericInterface<T> {
    // 全局变量
    // 注释部分表示都是可以省略的, 因为静态常量默认就是公有静态的
    /*public static final */int MAX_VALUE = 1000;
    // 定义抽象的方法
    /*public abstract */ T compare(T t);
}
